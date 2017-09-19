package com.gdglc.news.annotation;

import java.lang.annotation.Annotation;

public class Test {
	public static void main(String[] args) {
		try {
			Class targetClass = Class.forName("com.gdglc.news.annotation.AuthTest");
			Annotation annotation = targetClass.getAnnotation(Auth.class);
			System.out.println(annotation);
			if(null!= annotation){
				//创建对象
				Object obj = targetClass.newInstance();
				System.out.println(obj);
			}
		} catch (Exception e) {
			// todo Auto-generated catch block
			e.printStackTrace();
		}
	}
}
