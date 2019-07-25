package com.li.basicJava.myThreadLearning.day2;

/**
 * 银行类提供一个取存款的方法，该方法是一个synchronize修饰的同步方法，保证账户上前的同步安全问题
 * 目的：使用synchronized关键字保证线程安全
 * @author 有之君
 *
 */
public class Bank02 {
	
	private String account;
	private int balance;
	
	public Bank02(String account, int balance) {
		super();
		this.account = account;
		this.balance = balance;
	}
	
	public synchronized void drawMoney(int money,String name){
		if(this.balance > money){
			System.out.println(name+"取了"+money+"元");
			this.balance = this.balance - money;
			System.out.println(name+"还剩下"+this.balance+"元");
		}
	}
	
	public static void main(String[] args) {
		
		Bank02 nb = new Bank02("1000", 1000);
		
		new People("甲",100, nb).start();
		new People("乙",400, nb).start();
	}

}

class People extends Thread {
	private String name;
	private int money;
	private Bank02 nb;
	public People(String name,int money, Bank02 nb) {
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