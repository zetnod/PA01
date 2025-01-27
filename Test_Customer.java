/**
 * This is a SIMPLE test harness for the Customer class.
 * 
 * Keyboard input is accepted from the user and then used to instantiate a Customer object.
 *   Once an object has been instantiated, it will be stored in an array.
 *   An enhanced for loop will then be used to output information about all objects in the array.
 */

import java.util.Scanner;                                      // to accept keboard input

public class Test_Customer
{
  private static int        limit     = 5;
  /*
   *  Using the limit declared above, 
   *    DECLARE AN ARRAY HERE TO HOLD CUSTOMER OBJECTS THAT YOU WILL BUILD IN THIS TEST HARNESS.
   *  The access modifiers are alread provided for you;DO NOT CHANGE THEM!
   */
  private static Customer[] custArray = new Customer[limit];
 
  public static void main(String[] args) 
  { 
    loadArray( );
    outputCustomers( );    
  }  // end main
  
  private static void loadArray( )
  {
    /************************************************************************************************************
     *  The first part of this method is simply 'set up' for the real work to be done later.
     *   We will:
     *      > Instantiate the Scanner here to accept keyboard input
     *      > Create a 'holding' space for the Customer object(s) to be isntantiated
     *      > Declare variables to hold the user responses
     *      > Declare a variable to use in controlling the input loop
     ************************************************************************************************************/
    Scanner input = new Scanner( System.in );                  // instantiate Scanner for use; tie to keyboard
    
    Customer newCustomer;                                      // "holding reference" for the Customer object
    
    // create prompts for use in loop
    String askAllInfo = "Do you have ALL the Customer information available? Y or N: ";
    String askCustNbr = "Enter a Customer Number as 7 digits: ";
    String askTIN     = "Enter a 9-digit tax identifier: ";
    String askFirst   = "Enter a first name: " ;
    String askLast    = "Enter a last name: ";
    String askMargin  = "Enter a margin limit as an integer: ";
    String askDrip    = "Does the customer want to reinvest dividends? True or False: ";
    String askFutures = "Is the customer eligible to trade in futures contracts? True or False: ";
    
    // declare variables to hold instance values
    String  allInfo,
            custNbr,
            tin,
            first,
            last;
    int     margin;
    boolean drip,
            futures;
    
    // Declare a loop control variable
    int countCusts = 0;
    

    /************************************************************************************************************
     *  The data input loop will continue until the array has been filled.
     *  
     *  Each prompt is offered in turn; the response from the user is stored in the appropriate variable
     ************************************************************************************************************/
    while( countCusts < limit )
    {
      // Prompt for the minimum required data values
      System.out.printf( "%s%n", askCustNbr );
      custNbr = input.next( );
      System.out.printf( "%s%n", askTIN );
      tin     = input.next( );
      
      // Does the user have ALL the customer's information?
      System.out.printf( "%s%n", askAllInfo );
      allInfo = input.next( );
      
      // Are we building a full object or a partial object?
      if( allInfo.charAt(0) == 'N' )
      {
        newCustomer = new Customer( custNbr,
                                   tin );
        
        custArray[ countCusts ] = 
          
          newCustomer;
      }
      else
      { 
        // Collect the rest of the information
        System.out.printf( "%s%n", askFirst );
        first   = input.next( );
        System.out.printf( "%s%n", askLast );
        last    = input.next( );
        System.out.printf( "%s%n", askMargin );
        margin  = input.nextInt( ); 
        input.nextLine( );                                    // for clearing the 'hanging' end of line marker
        System.out.printf( "%s%n", askDrip );
        drip    = input.nextBoolean( );
        System.out.printf( "%s%n", askFutures );
        futures = input.nextBoolean( );
        
        /************************************************************************************************************
          *  The data gathered from the user will be used to instantiate a new Customer object. 
          *  We will use the 'holding' reference declared at the top of the method to point to the 
          *    Customer object just created.
          *  Then the referenct to the new Customer object is stored in the array.
          *  The loop control counter is incremented for the next pass through the loop.
          ************************************************************************************************************/
        
        newCustomer = new Customer( custNbr,
                                   tin,
                                   last,
                                   first,
                                   margin,
                                   drip, 
                                   futures );
        
        custArray[ countCusts ] = newCustomer;
      }
      countCusts += 1;      
    } // end of loop
    
    // Reflect to user that loop has ended
    System.out.printf( "%nData input complete. Thank you.%n" );
    
  } // end loadArray
  
  private static void outputCustomers( )
  {
    /************************************************************************************************************
     *  An ENHANCED FOR LOOP is used to process each object in the array.
     *     The describeCustomer method of each object is called; the return value is then output to the console.
     * 
     * YOU WILL WRITE THE ENHANCED FOR LOOP BELOW. It is the ONLY code needed in this method. DO NOT alter the 
     *     method header in any way.
     ************************************************************************************************************/

    for(Customer outputCustomers : custArray){
      
      System.out.println(outputCustomers.describeCustomer());
     
    }//end enhanced for loop

  } // end outputCustomers
    
}  // end Test_Customer
