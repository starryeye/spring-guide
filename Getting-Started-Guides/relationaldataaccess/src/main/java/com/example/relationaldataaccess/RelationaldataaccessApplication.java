package com.example.relationaldataaccess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

@SpringBootApplication
public class RelationaldataaccessApplication {

	/**
	 * 예제는 JdbcTemplate을 사용하지만, NamedParameterJdbcTemplate 을 사용하였다.
	 */

	private static final Logger logger = LoggerFactory.getLogger(RelationaldataaccessApplication.class);

	private static final RowMapper<Customer> customerRowMapper =
			(rs, rowNum) -> new Customer(
					rs.getLong("id"),
					rs.getString("first_name"),
					rs.getString("last_name")
			);

	@Bean
	ApplicationRunner run(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		return args -> {

			//init
			logger.info("init start");

			JdbcTemplate classicJdbcTemplate = namedParameterJdbcTemplate.getJdbcTemplate();

			classicJdbcTemplate.execute("DROP TABLE customers IF EXISTS");

			classicJdbcTemplate.execute("CREATE TABLE customers(" +
					"id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

			List<String> names = List.of("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long");

			//insert
			logger.info("insert start");

			List<Customer> customers = names.stream()
					.map(name -> name.split(" "))
					.filter(name -> name.length == 2)
					.map(name -> new Customer(0L, name[0], name[1]))
					.toList();

			String insertSql = "INSERT INTO customers(first_name, last_name) VALUES (:firstName, :lastName)";

			SqlParameterSource[] parameterSource = customers.stream()
					.map(BeanPropertySqlParameterSource::new)
					.toArray(SqlParameterSource[]::new);

			namedParameterJdbcTemplate.batchUpdate(insertSql, parameterSource);

			//select
			logger.info("select start");

			String selectSql = "SELECT id, first_name, last_name FROM customers WHERE first_name = :firstName";

			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("firstName", "Josh");

			namedParameterJdbcTemplate.query(selectSql, params, customerRowMapper)
					.forEach(customer -> System.out.println(customer.toString()));

		};
	}
	public static void main(String[] args) {
		SpringApplication.run(RelationaldataaccessApplication.class, args);
	}

}
