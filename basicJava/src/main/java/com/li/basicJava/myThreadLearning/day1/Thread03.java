package com.li.basicJava.myThreadLearning.day1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 1.实现Callable接口
 * 2.FutureTask类包装Callable接口，为Thread构造器的target
 * 3.调用Thread的构造器生成实例
 * 3。推荐使用这种方法
 * @author 有之君
 *
 */
public class Thread03 implements Callable{

	@Override
	public Object call() throws Exception {
		for(int i = 0;i<10;i++){
			System.out.println(Thread.currentThread().getName());
		}
		return Thread.currentThread().getName();
	}
	
	public static void main(String[] args) {
		FutureTask ftask = new FutureTask(new Thread03());
		new Thread(ftask).start();
	}

}