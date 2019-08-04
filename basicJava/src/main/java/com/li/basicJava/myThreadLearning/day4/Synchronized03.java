package com.li.basicJava.myThreadLearning.day4;

/**
 * 一个同步方法可以调用一个同步方法
 * @author 有之君
 *
 */
public class Synchronized03 {
	
	public synchronized void m1(){
		System.out.println("同步方法m1");
		m2();
	}

	public synchronized void m2(){
		System.out.println("同步方法m2");
	}
	
	public static void main(String[] args) {
		Synchronized03 sy03 = new Synchronized03();
		new Thread(()->sy03.m1()).start();
	}
	
}
