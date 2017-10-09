package shoppingBase;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/


import java.util.*;

// line 1 "shoppingBase.ump"
public class Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String name;
  private double totalAccountSpent;
  private int information;

  //Customer Associations
  private List<Account> accounts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aName, double aTotalAccountSpent, int aInformation)
  {
    name = aName;
    totalAccountSpent = aTotalAccountSpent;
    information = aInformation;
    accounts = new ArrayList<Account>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }


  public boolean setTotalAccountSpent(double aTotalAccountSpent)
  {
    boolean wasSet = false;
    totalAccountSpent = aTotalAccountSpent;
    wasSet = true;
    return wasSet;
  }

  public boolean setInformation(int aInformation)
  {
    boolean wasSet = false;
    information = aInformation;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }


  public double getTotalAccountSpent()
  {
    return totalAccountSpent;
  }

  public int getInformation()
  {
    return information;
  }

  public Account getAccount(int index)
  {
    Account aAccount = accounts.get(index);
    return aAccount;
  }

  public List<Account> getAccounts()
  {
    List<Account> newAccounts = Collections.unmodifiableList(accounts);
    return newAccounts;
  }

  public int numberOfAccounts()
  {
    int number = accounts.size();
    return number;
  }

  public boolean hasAccounts()
  {
    boolean has = accounts.size() > 0;
    return has;
  }

  public int indexOfAccount(Account aAccount)
  {
    int index = accounts.indexOf(aAccount);
    return index;
  }

  public static int minimumNumberOfAccounts()
  {
    return 0;
  }

  public boolean addAccount(Account aAccount)
  {
    boolean wasAdded = false;
    if (accounts.contains(aAccount)) { return false; }
    Customer existingCustomer = aAccount.getCustomer();
    boolean isNewCustomer = existingCustomer != null && !this.equals(existingCustomer);
    if (isNewCustomer)
    {
      aAccount.setCustomer(this);
    }
    else
    {
      accounts.add(aAccount);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccount(Account aAccount)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccount, as it must always have a customer
    if (!this.equals(aAccount.getCustomer()))
    {
      accounts.remove(aAccount);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAccountAt(Account aAccount, int index)
  {  
    boolean wasAdded = false;
    if(addAccount(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccountAt(Account aAccount, int index)
  {
    boolean wasAdded = false;
    if(accounts.contains(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccountAt(aAccount, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=accounts.size(); i > 0; i--)
    {
      Account aAccount = accounts.get(i - 1);
      aAccount.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "totalAccountSpent" + ":" + getTotalAccountSpent()+ "," +
            "information" + ":" + getInformation()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " ;
  }
}