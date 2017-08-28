package com.gdglc.news;
/**
 * 
 *方法重写demo
 *1、方法的名称和参数一定要相同
 *2、只能扩大方法的使用范围--1、方法修饰符 2、父类方法如果有声明抛出异常，子类方法可以不抛出异常
 *3、子类方法只能更具体，不能更抽象
 *--3.1、方法的返回类型只能和父类相同或者时父类方法返回类型的子类型
 *--3.2、父类方法如果有声明抛出异常,子类的方法只能是父类异常的子类型或者完全相同
 * @author allan
 * @version $Date: 2017年8月28日 $
 */
public class Child extends Parent{

	@Override
	public Integer add(int a, int b)throws NullPointerException  {
		return null;
	}
	
}
