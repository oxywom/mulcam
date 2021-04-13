package com.mulcam.bank.vo;

import org.springframework.stereotype.Component;

@Component("account")
public class Account {
	private String id;
	private String name;
	private int balance;
	private String sect;
	private String grade;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getSect() {
		return sect;
	}
	public void setSect(String sect) {
		this.sect = sect;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public boolean deposit(int money) {
		if(money <= 0) return false;
		if(sect.equals("normal")) {
			balance += money;
		} else {
			switch(grade) {
			case "VIP": balance += (int)(money*1.04); break;
			case "Gold": balance += (int)(money*1.03); break;
			case "Silver": balance += (int)(money*1.02); break;
			case "Normal": balance += (int)(money*1.01); break;
			}
		}
		return true;
	}
	
	public boolean withdraw(int money) {
		if(balance>=money) {
			balance-=money;
			return true;
		}
		return false;
	}	
}
