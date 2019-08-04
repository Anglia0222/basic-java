package com.li.basicJava.myThreadLearning.day5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试可重入锁的trylock方法
 * 场景：两个线程去操作同一个对象
 * @author 有之君
 *
 */
public class Reentranlock02 {

	private ReentrantLock lock = new ReentrantLock();
	
	public void m1(){
		lock.lock();
		try {
			for(int i = 0 ;i<20;i++){
				TimeUnit.SECONDS.sleep(1);
				System.out.println(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			lock.unlock();
		}
		
	}
	
	public void m2(){
		boolean result = true;
		try {
			TimeUnit.SECONDS.sleep(5);
			result = lock.tryLock();
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(result){
				lock.unlock();
			}
			
		}
	}
	
	public static void main(String[] args){
		Reentranlock02 lock02 = new Reentranlock02();
		
		new Thread(()->lock02.m1()).start();
		new Thread(()->lock02.m2()).start();
		
		
	}
	
	
}
