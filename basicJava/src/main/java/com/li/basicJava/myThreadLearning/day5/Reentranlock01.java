package com.li.basicJava.myThreadLearning.day5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 涉及一个可重入锁替换synchronized的场景
 * @author 有之君
 *
 */
public class Reentranlock01 {
	
	private ReentrantLock lock = new ReentrantLock();
	
	public void m1(){
		try {
			lock.lock();
			for(int i =0;i<20;i++){
				TimeUnit.SECONDS.sleep(1);
				System.out.println(Thread.currentThread().getName());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
	
	public void m2(){
		lock.lock();
		System.out.println(Thread.currentThread().getName());
		lock.unlock();
	}
	
	public static void main(String[] args) {
		Reentranlock01 lock01 = new Reentranlock01();
		new Thread(()->lock01.m1()).start();
		new Thread(()->lock01.m2()).start();
	}

}
