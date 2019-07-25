package com.li.basicJava.myThreadLearning.day2;

/**
 * 从银行取钱的模型,无法模拟出来....
 * 
 * 利用synchronized进行加锁操作
 * @author 有之君
 *
 */
public class Bank01 {

	private String account;
	private int balance;
	public Bank01(String account, int balance) {
		super();
		this.account = account;
		this.balance = balance;
	}
	
	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	public static void main(String[] args) {
		Bank01 accout = new Bank01("lpz", 1000);
		new DrawMoney("甲", 500, accout).start();
		new DrawMoney("乙", 200, accout).start();
		
	}

}
class DrawMoney extends Thread{
	private String name;
	private int money;
	private Bank01 bank;
	
	public DrawMoney(String name, int money, Bank01 bank) {
		super();
		this.name = name;
		this.money = money;
		this.bank = bank;
	}
	@Override
	public void run() {
		
		int balance = bank.getBalance();
		int yue = balance - this.money;
		
		synchronized (bank) {
			
			if(yue > 0){
				System.out.println(this.name+"取出了"+this.money);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bank.setBalance(yue);
				System.out.println(this.name+"余额为："+bank.getBalance());
			}else{
				System.out.println("不能取钱");
			}
		}
		
	}
	
	
}
