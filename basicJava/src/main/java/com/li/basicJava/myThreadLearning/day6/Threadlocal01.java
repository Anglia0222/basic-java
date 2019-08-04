package com.li.basicJava.myThreadLearning.day6;

import java.util.concurrent.TimeUnit;

/**
 * 线程间的局部变量
 * @author 有之君
 *
 */
public class Threadlocal01 {
	private static ThreadLocal<Person> threadLocal = new ThreadLocal<Person>();

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
					System.out.println(threadLocal.get());
				} catch (Exception e) {
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
					threadLocal.set(new Person());
				} catch (Exception e) {
				}
			}
		}).start();
	}
}

class Person{
	public String name = "张三";
}