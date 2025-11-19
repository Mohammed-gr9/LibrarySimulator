class Member{

  
//https://github.com/Mohammed-gr9/LibrarySimulator.git

// Name:محمد سفر الغامدي
// ID: 446104699

    // Instance variables: Unique to each member object
    private int id;
    private String name;
    private int borrowedCount ;
    private int numViewBorrowed;
    private int numBorrows = 0;
    private int numReturns = 0;
    private double sessionFees = 0.0 ;
    // Static variables: Shared across ALL members, used for Admin statistics
    static double TotalRevenue =0.0;
    static int TotalViewBorrowed=0;
    static int TotalBorrows=0;
    static int TotalReturns=0;
    public int getId(){
         return id;
    }

    public String getName(){
         return name;
    }

    public int getnumViewBorrowed(){
         return numViewBorrowed;
    }
      // Constructor to initialize a new member with ID, name, and current borrowed count
       Member(int id, String name,int borrowedCount){
           this.id = id;
           this.name = name;
           this.borrowedCount = borrowedCount;
       }

    // Checks if the member can borrow based on the 5-book limit
       boolean canBorrow(){
        if(borrowedCount <5){
                         return true;
       }else{
        System.out.println("you cannot borrow more than 5 books at once.");
        return false;
       }
      }

// Checks if the member has books to return (count > 0)
      boolean canReturn(){
        if(borrowedCount == 0){
            System.out.println("Error: you don't have any books");
          return false;
       }else{
        return true;
      }
       }
       void viewBorrowedCount(){
         System.out.printf("You currently have %d book(s) borrowed.%n", borrowedCount);
         numViewBorrowed++;
         TotalViewBorrowed++;

       
      }
        // Simulates borrowing a book and updates counts and session fees
       boolean borrowOne(){
                if(canBorrow() == false){
                         return false;
                     }else {
                        numBorrows += 1;
                        sessionFees += 0.5;
                        borrowedCount = borrowedCount + 1;
                        TotalBorrows = TotalBorrows + 1;
                        
                        TotalRevenue += 0.5;
                         System.out.printf("You borrowed book. Fee: %.2f SR%n", 0.50);
                         return true;
                     }
       }
    // Simulates returning a book and updates counts
       boolean returnOne(){
           if(canReturn() == true){
               numReturns += 1;
               borrowedCount = borrowedCount - 1;
               TotalReturns = TotalReturns+1 ;
               System.out.println("you returned 1 book. ");
               return true;
          }
            else{
              return false;
            }        
       }
    // Resets only the session-specific statistics for the current member
       void reset(){
        System.out.println("Ending session and returning to main menu...");
        numViewBorrowed = 0;
        numBorrows = 0;
        numReturns = 0;
        sessionFees = 0.0;
       }
       void displayStatistics(){
        System.out.println("\n--- Session Summary ---");
        System.out.printf("Books borrowed: %d%n", numBorrows);
        System.out.printf("Books returned: %d%n", numReturns);
        System.out.printf("Total fees: %.2f SR%n", sessionFees);
       }
    }
