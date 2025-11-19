public class Member{
    private int id;
    private String name;
    private int borrowedCount ;
    private int numViewBorrowed = 0;
    private int numBorrows = 0;
    private int numReturns = 0;
    private double sessionFees = 0.0 ;
    static double TotalRevenue =0.0;
    static int TotalViewBorrowed=0;
    static int TotalBorrows=0;
    static int TotalReturns=0;
    int getId(){
         return id;
    }

    String getName(){
         return name;
    }

    int getnumViewBorrowed(){
         return numViewBorrowed;
    }

       Member(int id, String name,int borrowedCount){
           this.id = id;
           this.name = name;
           this.borrowedCount = borrowedCount;
       }
       boolean canBorrow(){
        if(borrowedCount <5){
                         return true;
       }else{
        System.out.println("you cannot borrow more than 5 books at once.");
        return false;
       }
      }


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
