import java.util.Scanner;

//https://github.com/Mohammed-gr9/LibrarySimulator.git
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
