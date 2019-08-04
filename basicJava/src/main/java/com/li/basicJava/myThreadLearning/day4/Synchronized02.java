package com.li.basicJava.myThreadLearning.day4;

import java.util.concurrent.TimeUnit;

/**
 * 模拟脏读
 * @author 有之君
 *
 */
public class Synchronized02 {
	private String name;
	private int balance;

	public synchronized void write(String name,int money){
		this.name = name;
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.balance = money;
	}
	
	public int read(String name){
		return this.balance;
	}
	
	public static void main(String[] args) {
		Synchronized02 sy02 = new Synchronized02();
		new Thread(()->sy02.write("li", 100)).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(sy02.read("li"));
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(sy02.read("li"));
		
	}
}
