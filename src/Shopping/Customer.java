package Shopping;

import java.util.ArrayList;

public class Customer {
	private String name;
	  private ArrayList<Account> accountsInStock;
	  private double totalAccountSpent;
	  private int information;
	  
	  public Customer(String n,int i){
		  name = n;
		  accountsInStock = new ArrayList<Account>();
		  setInformation(i);
	  }

	public ArrayList getAccountsInStock() {
		return accountsInStock;
	}

	public int getInformation() {
		return information;
	}

	public void setInformation(int information) {
		this.information = information;
	}
	public void addAccount(Account a) {
		accountsInStock.add(a);
	}
	
	public void changeName(String n) {
		name = n;
	}

}
