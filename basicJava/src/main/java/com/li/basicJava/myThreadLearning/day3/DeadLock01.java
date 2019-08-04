package com.li.basicJava.myThreadLearning.day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 死锁的定义：
 * 复现一种死锁的情况
 * 
 * @author 有之君
 *
 */
public class DeadLock01 {
	
	

}

class DeadLock02{
	public synchronized void getLock03(DeadLock03 dl03){
		try {
			Thread.sleep(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}

class DeadLock03{
	public synchronized void getLock02(DeadLock02 dl02){
//		ExecutorService
	}
}
