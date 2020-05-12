/**
 * Customer Class
 * 
 * Purpose: To obtain cutomer information regarding their account 
 *          and output information regarding account preledges and
 *          reinvestment options
 *         
 * Programmer: Dontez Wherry 
 * Course:     IS 2043
 */
public class Customer {
  
  private String custNumber; //A unique identifier for a customer
  private String tin; //Customer's tax reporting number - TIN, EIN, or SSN
  private String last; //Customer's last name (or surname) as per legal identification
  private String first; //Customer's first (or given) name as per legal indentification
  private int margin; /*Margin limit for trading; expressed as whole dollars; if equal 
   *to zero - customer is not authorized for margin trading
   */
  private boolean drip; /*Indicates customer's instructions on dividend reinvestment: 
   *true = automatic reinvestment; false by customer instruction
   */
  private boolean futures; //Indicates whether customer is authorized for futures contracts trading
  
  
  /*Two-parm constructor, accepts values for customer number and tax identifier only; returns a 
   *reference to a fully functional Customer object
   */
  public Customer(String nbr, String id){
    
    this.custNumber = nbr; //set "this" object's customer number
    this.tin = id; //set "this" object's tax identifier
    
    this.last = " "; //set "this' object's last name
    this.first = " "; //set "this' object's first name
        
  }//end two parameter constructor Customer
  
  
  /* Full constructor; returns a reference to a fully formed and functional 
   * Customer
   */
  public Customer(String nbr, String id, String lName, String fName, int lim, boolean reUp, boolean fAuth){
    
    this.custNumber = nbr; //set "this" object's customer number
    this.tin = id; //set "this" object's tax identifier
    this.last = lName; //set "this" object's last name
    this.first = fName; //set "this" object's first name
    this.margin = lim; //set "this" object's margin limits
    this.drip = reUp; //set "this" object's reinvestment option
    this.futures = fAuth; //set "this" object's futures trade option     
    
  }//end full custructor Customer
  
  
  //Set the value of the instance variable custNumber
  public final void setCustNumber(String nbr){
    
    custNumber = nbr;
    
  }//end method setCustNumber
  
  
  //Set the value of the instance variable tin
  public final void setTin(String id){
    
    tin = id;
    
  }//end method setTin
  
  
  //Set the value of the instance variable last
  public final void setLast(String lName){
    
    last = lName;
    
  }//end method setLast
  
  
  
  //Set the value of the instance variable first
  public final void setFirst(String fName){
    
    first = fName;
    
  }//end method setFirst
  
  
  
  //Set the value of the instance variable margin
  public final void setMargin(int lim){
    
    margin = lim; 
    
  }//end method setMargin
  
  
  
  //Set the value of the instance variable drip
  public final void setDrip(boolean reUp){
    
    drip = reUp;
    
  }//end method setDrip
  
  
  
  //Set the value of the instance variable futures
  public final void setFutures(boolean fAuth){
    
    futures = fAuth; 
    
  }//end method setFutures
  
  
  
  //Return the value of the instance variable custNumber
  public final String getCustNumber(){
    
    return custNumber;
    
  }//end method getCustNumber
  
  
  //Return the value of the instance variable tin
  public final String getTin(){
    
    return tin;
    
  }//end method getTin
  
  
  //Return the value of the instance variable last
  public final String getLast(){
    
    return last;
    
  }//end method getLast
  
  
  
  //Return the value of the instance variable first
  public final String getFirst(){
    
    return first;
    
  }//end method getFirst
  
  
  
  //Return the value of the instance variable margin
  public final int getMargin(){
    
    return margin; 
    
  }//end method getMargin
  
  
  
  //Return the value of the instance variable drip
  public final boolean getDrip(){
    
    return drip;
    
  }//end method getDrip
  
  
  
  //Return the value of the instance variable futures
  public final boolean getFutures(){
    
    return futures; 
    
  }//end method getFutures
  
  
  
  //Returns a formatted String object with a verbose description of the Customer object
  public String describeCustomer(){
    
    /* if/else statments to dispay formatted string depending if futures and
     * drip are true or false
     */
    if(getDrip() == false && getFutures() == true){
      
      return String.format("%n%s%s,%s %s.%n%s%n%s%n%s", "Customer ", getCustNumber(), 
                           getFirst(), getLast(), "This account does not have margin privileges. ",
                           "Dividends will be deposited as cash funds.",
                           "The account is authorized to trade in futures contracts.");
      
    }//end if when drip is false and futures is true
    
    if(getDrip() == true && getFutures() == false){
      
      return String.format("%n%s%s,%s %s.%n%s$%d.00.%n%s%n%s", "Customer ", getCustNumber(), 
                           getFirst(), getLast(), "The account carries a margin limit of ", getMargin(),
                           "The account will reinvest dividends as recieved.",
                           "The account is not authorized to trade futures contracts.");
      
    }//end if when drip is true and futures is false
     
    if(getDrip() == true && getFutures() == true){
      
      return String.format("%n%s%s,%s %s.%n%s$%d.00.%n%s%n%s", "Customer ", getCustNumber(), 
                           getFirst(), getLast(), "The account carries a margin limit of ", getMargin(),
                           "The account will reinvest dividends as recieved.",
                           "The account is authorized to trade in futures contracts.");
      
    }//end if when drip is true and futures is true
     
    else {
        
      return String.format("%n%s%s,%s %s.%n%s%n%s%n%s", "Customer ", getCustNumber(), 
                           getFirst(), getLast(), "This account does not have margin privileges. ",
                           "Dividends will be deposited as cash funds.",
                           "The account is not authorized to trade futures contracts.");
      
    }//end else when drip and futures do not receive a response
    
  }//end method describeCustomer
  
  
  
  public String toString(){
    
    return String.format("%n%s,%s,%s,%s,%d,%b,%b", getCustNumber(), getTin(), getLast(), getFirst(), 
                         getMargin(), getDrip(), getFutures());
    
  }//end method toString
  
  
  
}//end class Customer
