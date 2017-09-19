package com.gdglc.news.annotation;
@Auth
public class AuthTest {
	static{
		System.out.println("static AuthTest");
	}
	
	public AuthTest(){
		System.out.println("create AuthTest");
	}
	
	@Auth
	private String name;
	@Auth
	public void test(@Auth String name){
		System.out.println("test");
	}
}
