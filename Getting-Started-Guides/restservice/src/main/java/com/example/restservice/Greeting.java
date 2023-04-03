package com.example.restservice;

/**
 * record (java 14) 는..
 * "데이터 클래스"이며 순수하게 데이터를 보유하기 위한 특수한 종류의 클래스이다.
 * 레코드는 암묵적으로 final 이며, 모든 필드는 private final 이다.
 * 레코드는 컴파일러가 자동으로 생성자, getter, equals(), hashCode(), toString() 메소드를 생성해준다.
 *
 * DTO 클래스를 생성할때 사용되면 굉장히 좋다.
 *
 * component 로 id, content 를 가지고 있다.
 */
public record Greeting(
        long id,
        String content
) {}
