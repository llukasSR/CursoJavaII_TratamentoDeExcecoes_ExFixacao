package model.entities;

import model.exceptions.TransactionException;

public class Account {
	private Integer number;
	private String holder;
	private double balance;
	private double withdrawLimit;

	public Account(Integer number, String holder, double balance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		if(amount > balance) {
			throw new TransactionException("Withdraw error: Not enough balance!");
		}
		if(amount > withdrawLimit) {
			throw new TransactionException("Withdraw error: The amount exceeds withdraw limit!");
		}
		balance -= amount;
	}

}
