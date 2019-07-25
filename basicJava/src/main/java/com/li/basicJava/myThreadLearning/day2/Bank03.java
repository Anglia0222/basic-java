package com.li.basicJava.myThreadLearning.day2;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 使用Lock，来进行加锁，保证线程安全
 *
 */
public class Bank03 {
	

	private final ReentrantLock lock = new ReentrantLock();
	private String account;
	private int balance;
	
	public Bank03(String account, int balance) {
		super();
		this.account = account;
		this.balance = balance;
	}
	
	
	public void drawMoney(int money,String name){
		lock.lock();
		try {
			if(this.balance > money){
				System.out.println(name+"取了"+money+"元");
				this.balance = this.balance - money;
				System.out.println(name+"还剩下"+this.balance+"元");
			}
		} catch (Exception e) {
		}finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		Bank03 nb = new Bank03("1000", 1000);
		new People03("甲",100, nb).start();
		new People03("乙",400, nb).start();
	}
	
}

class People03 extends Thread {
	private String name;
	private int money;
	private Bank03 nb;
	public People03(String name,int money, Bank03 nb) {
		super();
		this.name = name;
		this.money = money;
		this.nb = nb;
	}
	@Override
	public void run() {
		nb.drawMoney(money,this.name);
	}
	
}
