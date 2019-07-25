package com.li.basicJava.myThreadLearning.day1;

/**
 * 通过继承Thread类，来创建线程实例
 * @author 有之君
 *
 */
public class Thread01 extends Thread{

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println(getName());
		}
	}

	public static void main(String[] args) {
		
		
		
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName());
			if(i==5){
				Thread01 th01 = new Thread01();
				th01.start();
				
				Thread01 th02 = new Thread01();
				th02.start();
				
			}
		}
	}
	
}