import java.util.Scanner;

//https://github.com/Mohammed-gr9/LibrarySimulator.git

 class Member{
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

  


public class LibrarySimulator {
    public static void main(String[] args) {
         Scanner kb = new Scanner(System.in);
         Member m1 = new Member(1130987465, "ahmad", 3);
         Member m2 = new Member(1020457668, "mohammed", 0);
         Member m3 = new Member(1103876543, "muhanned", 4);

        
    while (true) {
        String action;
        

        System.out.println("===== Welcome to Library Simulator ====");
         System.out.println("Select an account:");
            System.out.printf("%d - %s%n", m1.getId(), m1.getName());
            System.out.printf("%d - %s%n", m2.getId(), m2.getName());
            System.out.printf("%d - %s%n", m3.getId(), m3.getName());
            System.out.println("A - Login as Administrator");
            System.out.println("E - Exit Program");
            System.out.print("Enter choice: ");
         String input = kb.nextLine().toLowerCase().trim();
        if (input.equals("e")) {
              System.out.println("Exiting program... Goodbye!");
              break;
            
        }
        

         else if (input.equals("a")){
            while (true) {
                   System.out.println("\n--- Administrator Menu ---");
                    System.out.println("1. View Total Revenue");
                    System.out.println("2. Most Frequent Operation");
                    System.out.println("3. Exit to Main Menu");
                    System.out.print("Enter choice: ");;
                   action = kb.nextLine().toLowerCase();
                   switch (action) {
                    case "1":
                        System.out.printf("Total revenue collected: %.2f SR%n", Member.TotalRevenue);
                        break;
                    case "2":
                       if (Member.TotalBorrows > Member.TotalReturns)
                            System.out.println("Most frequent operation: Borrow");
                        else if (Member.TotalReturns > Member.TotalBorrows)
                            System.out.println("Most frequent operation: Return");
                        else
                            System.out.println("Both operations are equally frequent.");
                        break;
                    case "3":{
                     System.out.println("Returning to main menu...");
                     break;
                    }
                    default:
                       System.out.println("Invalid input. Try again.");
                
                        
                   }
                   if(action.equals("3")){
                    break;
                   }
               }
            
       }

    
         else if(input.equals(String.valueOf(m1.getId())) || input.equals(m1.getName().toLowerCase())) {
             while (true) {
                  
                  System.out.println("1. View Borrowed Books Count");
                    System.out.println("2. Borrow Book");
                    System.out.println("3. Return Book");
                    System.out.println("4. View Session Summary");
                    System.out.println("5. Exit to Main Menu");
                    System.out.print("Enter choice: ");
                   action = kb.nextLine().toLowerCase();
                   switch (action) {
                    case "1":{
                      m1.viewBorrowedCount();
                      break;}
                    case "2":{
                       m1.borrowOne();
                      break;}
                      case "3":{
                      m1.returnOne();
                       break;}
                       case "4":{
                        m1.displayStatistics();
                        break;}
                       case"5":{
                        m1.reset();
                       break;}
                   
                    default:
                     System.out.println("Invalid input. Try again.");
                        break;
                   }
       
        if (action.equals("5")){
         break;
        }
     }
    }

       else if(input.equals(String.valueOf(m2.getId())) || input.equals(m2.getName().toLowerCase())){

               while (true) {
                    System.out.println("1. View Borrowed Books Count");
                    System.out.println("2. Borrow Book");
                    System.out.println("3. Return Book");
                    System.out.println("4. View Session Summary");
                    System.out.println("5. Exit to Main Menu");
                    System.out.print("Enter choice: ");
                   action = kb.nextLine().toLowerCase();
                   switch (action) {
                    case "1":{
                      m2.viewBorrowedCount();
                        break;}
                    case "2":{
                     m2.borrowOne();
                      break;}
                      case "3":{
                      m2.returnOne();
                       break;}
                       case "4":{
                        m2.displayStatistics();
                        break;}
                       case"5":{
                        m2.reset();
                       break;}
                   
                    default:
                     System.out.println("Invalid input. Try again.");
                        break;
                   }
              if (action.equals("5")){
         break;
        }     
}
}
       else if(input.equals(String.valueOf(m3.getId())) || input.equals(m3.getName().toLowerCase())){
            while (true) {
                
            
                    System.out.println("1. View Borrowed Books Count");
                    System.out.println("2. Borrow Book");
                    System.out.println("3. Return Book");
                    System.out.println("4. View Session Summary");
                    System.out.println("5. Exit to Main Menu");
                    System.out.print("Enter choice: ");
                   action = kb.nextLine().toLowerCase();
                   switch (action) {
                    case "1":{
                          m3.viewBorrowedCount();
                        break;}
                    case "2":{
                      m3.borrowOne();
                      break;}
                      case "3":{
                        m3.returnOne();
                       break;}
                       case "4":{
                        m3.displayStatistics();
                        break;}
                       case"5":{
                        m3.reset();
                       break;}
                   
                    default:
                     System.out.println("Invalid input. Try again.");
                        break;
                   }
                   if (action.equals("5")){
         break;
        }
    }
       
       
       
        
        
    } else {
    System.out.println("Invalid choice. Please enter a valid ID, 'A' for Admin, or 'E' to Exit.");}
        }}}
