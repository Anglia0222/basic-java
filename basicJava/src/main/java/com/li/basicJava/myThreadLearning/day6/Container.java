package com.li.basicJava.myThreadLearning.day6;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 一个生产者消费者例子。2个生产者，10个消费者。
 * @author 有之君
 *
 */
public class Container {
	
	private LinkedList container = new LinkedList();
	private int count = 0;
	
	public synchronized void provider(Object o){
		try {
			while(container.size()==10){
				this.wait();
			}
			container.add(o);
			count ++;
			System.out.println(Thread.currentThread().getName()+"生产1个"+"，这时有"+count);
			this.notifyAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public synchronized void consumer(){
		try {
			while(container.size() == 0){
				this.wait();
			}
			container.removeFirst();
			count--;
			System.out.println(Thread.currentThread().getName()+"消费1个，"+"这是有"+count);
			this.notifyAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {
		
		Container pool = new Container();
		for(int i = 0;i<10;i++){
			new Thread(()->{
				try {
					while(true){
						pool.consumer();
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			},"消费者"+i).start();
		}
		try {
			TimeUnit.MILLISECONDS.sleep(1000);;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for(int i = 0;i<2;i++){
			new Thread(()->
			{
				try {
					while(true){
						pool.provider(Thread.currentThread().getName());
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			,"生产者"+i).start();
		}
		
		
	}

}
