package shoppingBase;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 19 "shoppingBase.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private int items;
  private double total;
  private int day;
  private int month;
  private int year;
  private boolean payedFor;

  //Order Associations
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(int aItems, double aTotal, int aDay, int aMonth, int aYear, boolean aPayedFor, Account aAccount)
  {
    items = aItems;
    total = aTotal;
    day = aDay;
    month = aMonth;
    year = aYear;
    payedFor = aPayedFor;
    boolean didAddAccount = setAccount(aAccount);
    if (!didAddAccount)
    {
      throw new RuntimeException("Unable to create order due to account");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setItems(int aItems)
  {
    boolean wasSet = false;
    items = aItems;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotal(double aTotal)
  {
    boolean wasSet = false;
    total = aTotal;
    wasSet = true;
    return wasSet;
  }

  public boolean setDay(int aDay)
  {
    boolean wasSet = false;
    day = aDay;
    wasSet = true;
    return wasSet;
  }

  public boolean setMonth(int aMonth)
  {
    boolean wasSet = false;
    month = aMonth;
    wasSet = true;
    return wasSet;
  }

  public boolean setYear(int aYear)
  {
    boolean wasSet = false;
    year = aYear;
    wasSet = true;
    return wasSet;
  }

  public boolean setPayedFor(boolean aPayedFor)
  {
    boolean wasSet = false;
    payedFor = aPayedFor;
    wasSet = true;
    return wasSet;
  }

  public int getItems()
  {
    return items;
  }

  public double getTotal()
  {
    return total;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public boolean getPayedFor()
  {
    return payedFor;
  }

  public boolean isPayedFor()
  {
    return payedFor;
  }

  public Account getAccount()
  {
    return account;
  }

  public boolean setAccount(Account aAccount)
  {
    boolean wasSet = false;
    if (aAccount == null)
    {
      return wasSet;
    }

    Account existingAccount = account;
    account = aAccount;
    if (existingAccount != null && !existingAccount.equals(aAccount))
    {
      existingAccount.removeOrder(this);
    }
    account.addOrder(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Account placeholderAccount = account;
    this.account = null;
    placeholderAccount.removeOrder(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "items" + ":" + getItems()+ "," +
            "total" + ":" + getTotal()+ "," +
            "day" + ":" + getDay()+ "," +
            "month" + ":" + getMonth()+ "," +
            "year" + ":" + getYear()+ "," +
            "payedFor" + ":" + getPayedFor()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}