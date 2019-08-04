package com.li.basicJava.myThreadLearning.day6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 验证是否响应中断
 * 场景：一个线程一直执行，占用cpu；另一个线程一直尝试去获得cpu资源。
 * @author 有之君
 *
 */
public class Reentranlock03 {
	private ReentrantLock lock = new ReentrantLock();
	
	public void m1(){
		lock.lock();
		try {
			while(true){
				TimeUnit.SECONDS.sleep(1);
				System.out.println(Thread.currentThread().getName());
			}
		} catch (Exception e) {
			System.out.println("m1方法异常");
		}finally {
			lock.unlock();
		}
	}
	
	public void m2(){
		try {
//		lock.lock();
			lock.lockInterruptibly();
			while(true){
				TimeUnit.SECONDS.sleep(1);
				System.out.println(Thread.currentThread().getName());
			}
		} catch (Exception e) {
			System.out.println("m2方法异常");
		}finally {
			System.out.println("我跳出了循环");
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		Reentranlock03 lock03 = new Reentranlock03();
		
		new Thread(()->lock03.m1()).start();
		Thread th2 = new Thread(()->lock03.m2());
		th2.start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception e) {
		}
		th2.interrupt();
	}
}
