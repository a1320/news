package com.gdglc.news.annotation;

public class ChilrdenTest extends AuthTest{
	public static void main(String[] args) {
		Auth auth = ChilrdenTest.class.getAnnotation(Auth.class);
		System.out.println(auth);
	}
}
