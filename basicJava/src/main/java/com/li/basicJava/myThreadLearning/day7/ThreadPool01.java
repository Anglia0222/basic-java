package com.li.basicJava.myThreadLearning.day7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 线程池实现
 * @author 有之君
 *
 */
public class ThreadPool01 {
	
	
	public static void main(String[] args) throws Exception, ExecutionException{
		ExecutorService pool = Executors.newFixedThreadPool(5);
		for(int i = 0 ;i<10;i++){
			pool.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println(Thread.currentThread().getName());
				}
			});
			
		}
		System.out.println(pool);
		
		Future fu = null;
		
		for(int i=0;i<2;i++){
			try {
				fu = pool.submit(new cl01());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println(fu.get());
		pool.shutdown();
	}

}
class cl01 implements Callable{
	@Override
	public Object call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return 1;
	}
	
}
