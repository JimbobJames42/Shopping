package shoppingBase;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/


import java.util.*;

// line 10 "shoppingBase.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private String accountName;
  private double totalSpent;
  private int accountNumber;

  //Account Associations
  private List<Order> orders;
  private Customer customer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(String aAccountName, double aTotalSpent, int aAccountNumber, Customer aCustomer)
  {
    accountName = aAccountName;
    totalSpent = aTotalSpent;
    accountNumber = aAccountNumber;
    orders = new ArrayList<Order>();
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create account due to customer");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccountName(String aAccountName)
  {
    boolean wasSet = false;
    accountName = aAccountName;
    wasSet = true;
    return wasSet;
  }


  public boolean setTotalSpent(double aTotalSpent)
  {
    boolean wasSet = false;
    totalSpent = aTotalSpent;
    wasSet = true;
    return wasSet;
  }

  public boolean setAccountNumber(int aAccountNumber)
  {
    boolean wasSet = false;
    accountNumber = aAccountNumber;
    wasSet = true;
    return wasSet;
  }

  public String getAccountName()
  {
    return accountName;
  }

  public double getTotalSpent()
  {
    return totalSpent;
  }

  public int getAccountNumber()
  {
    return accountNumber;
  }

  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public static int minimumNumberOfOrders()
  {
    return 0;
  }

  public Order addOrder(int aItems, double aTotal, int aDay, int aMonth, int aYear, boolean aPayedFor)
  {
    return new Order(aItems, aTotal, aDay, aMonth, aYear, aPayedFor, this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Account existingAccount = aOrder.getAccount();
    boolean isNewAccount = existingAccount != null && !this.equals(existingAccount);
    if (isNewAccount)
    {
      aOrder.setAccount(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a account
    if (!this.equals(aOrder.getAccount()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public boolean setCustomer(Customer aCustomer)
  {
    boolean wasSet = false;
    if (aCustomer == null)
    {
      return wasSet;
    }

    Customer existingCustomer = customer;
    customer = aCustomer;
    if (existingCustomer != null && !existingCustomer.equals(aCustomer))
    {
      existingCustomer.removeAccount(this);
    }
    customer.addAccount(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
    Customer placeholderCustomer = customer;
    this.customer = null;
    placeholderCustomer.removeAccount(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "accountName" + ":" + getAccountName()+ "," +
            "totalSpent" + ":" + getTotalSpent()+ "," +
            "accountNumber" + ":" + getAccountNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "ordersMade" + "=" +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}