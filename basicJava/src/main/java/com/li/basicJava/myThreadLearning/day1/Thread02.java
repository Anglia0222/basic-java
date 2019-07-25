package com.li.basicJava.myThreadLearning.day1;

/**
 * 1.实现Runnable接口，重写run()方法
 * 2.调用Thread的构造方法，生成线程实例
 * 3。推荐使用这种方法
 * @author 有之君
 *
 */
public class Thread02 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		Thread02 th02 = new Thread02();
		new Thread(th02).start();
	}

}
