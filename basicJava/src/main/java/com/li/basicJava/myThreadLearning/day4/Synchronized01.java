package com.li.basicJava.myThreadLearning.day4;

/**
 * 一个同步方法可以调用一个非同步方法
 * @author 有之君
 *
 */
public class Synchronized01 {
	
	public synchronized void m1(){
		System.out.println("这是一个同步方法");
	}
	
	public void m2(){
		System.out.println("这是一个非同步方法");
	}
	
	public static void main(String[] args) {
		Synchronized01 sy = new Synchronized01();
		new Thread(new Runnable() {
			public void run() {
				sy.m1();
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				sy.m2();
			}
		}).start();
	}

}
