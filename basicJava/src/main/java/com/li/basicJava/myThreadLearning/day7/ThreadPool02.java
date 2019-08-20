package com.li.basicJava.myThreadLearning.day7;

import java.util.concurrent.Executor;

/**
 * 原始的线程池的实现
 * 实现executor接口，执行execute方法时，需要传入一个runnable类型的对象
 *
 */
public class ThreadPool02 implements Executor{

	@Override
	public void execute(Runnable command) {

		command.run();
	}
	
	public static void main(String[] args) {
		ThreadPool02 th02 = new ThreadPool02();
		th02.execute(new InnerThreadPool02());
	}

}
class InnerThreadPool02 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}}
