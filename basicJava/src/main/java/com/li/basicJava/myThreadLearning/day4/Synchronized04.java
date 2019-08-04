package com.li.basicJava.myThreadLearning.day4;

import java.util.concurrent.TimeUnit;

/**
 * synchronized锁的堆里面的对象
 * @author 有之君
 *
 */
public class Synchronized04 {
	private Object obj = new Object();
	
	void m(){
		synchronized (obj) {
			while(true){
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println(Thread.currentThread().getName());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Synchronized04 sy04 = new Synchronized04();
		
		new Thread(sy04::m,"T1").start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread t2 = new Thread(sy04::m,"T2");
		sy04.obj = new Object();
		
		t2.start();
		
	}

}
