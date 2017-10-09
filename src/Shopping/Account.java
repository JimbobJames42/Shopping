package Shopping;

import java.util.ArrayList;

import shoppingBase.Customer;

public class Account {
	 private String accountName;
	  private ArrayList<Order> ordersMade;
	  private double totalSpent;
	  private int accountNumber;
	  private Customer customer;
	  
	  public Account (String s,int a, Customer c) {
		  setAccountName(s);
		  accountNumber = a;
		  customer =c;
		  totalSpent = 0;
		  ordersMade = new ArrayList<Order>();
	  }

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public void addOrder(Order o) {
		ordersMade.add(o);
		totalSpent+=o.getTotal();
	}
	public double getTotalSpent() {
		return totalSpent;
	}
}
