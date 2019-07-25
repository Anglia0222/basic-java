package com.li.basicJava.myThreadLearning.day1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 线程的控制方法
 * @author 有之君
 *
 */
public class Thread04 implements Callable{

	public int num = 0;
	@Override
	public Object call() throws Exception {
		for(int i = 0;i<100;i++){
			num ++;
			if(i == 9){
//				Thread th2 = new Thread(new FutureTask(new Thread04()),"第二个线程");
//				th2.start();
//				th2.join();
			}
			System.out.println(Thread.currentThread().getName()+",num="+num);
		}
		return num;
	}
	
	
	
	public static void main(String[] args) throws Exception {
//		Thread th1 = new Thread(new FutureTask(new Thread04()),"第一个线程");
//		th1.start();
//		System.out.println(Thread.currentThread().getName());
//		for(int i =0;i<100;i++){
//			if(i == 20){
//				Thread th2 = new Thread(new FutureTask(new Thread04()),"第二个线程");
//				th2.start();
//				th2.join();
//			}
//			System.out.println(Thread.currentThread().getName()+",i="+i);
//		}
		
		
		
		Thread th2 = new Thread(new FutureTask(new Thread04()),"第一个线程");
		th2.start();
		System.out.println(Thread.currentThread().getName());
		
		
		
		
		
		
		
		
		
		
		
	}

}
