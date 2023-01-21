
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Customer {
    
    public static Scanner userInput = new Scanner(System.in);
    public static int customerID;
    public static String lastName;
    public static String firstName;
    public static double totalPurchase;
    public static String gender;
    public static String city;
    public static int cutsomerCount = 0;
     public static void addCustomer () throws FileNotFoundException {
          try{
                    Formatter formatter1 = new Formatter("G:/Rity/Java/Project/Supershop/Customer.txt");
           System.out.print("Enter Customer ID: ");
        customerID= userInput.nextInt();
        userInput.nextLine();
        System.out.print("Enter Customer Last Name: ");
        lastName = userInput.nextLine();
        System.out.print("Enter Customer First Name: ");
        firstName = userInput.nextLine();
        totalPurchase = readTotalPurchase("Enter Total Purchase: ");
        gender = readCustomerGender("Enter Customer Gender: ");
        city = readCustomerCity("Enter Customer City: ");
                    
                    formatter1.format("%s   %s   %s   %s   %s   %s\r\n",customerID,firstName,lastName,totalPurchase,gender,city);
                     formatter1.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
       
        cutsomerCount ++;
    }
     }
     public static void printCoustomer() throws FileNotFoundException{
         
        try{
            File file = new File("G:/Rity/Java/Project/Supershop/Customer.txt");
            Scanner scan= new Scanner(file);
            while(scan.hasNext()){
                
            int customerID=scan.nextInt();
     String lastName=scan.next();
    String firstName=scan.next();
    double totalPurchase=scan.nextDouble();
    String gender=scan.next();
     String city=scan.next();
                System.out.println("ID: "+customerID+"\n Name: "+firstName+" "+lastName+"\n TotalPurched: "+totalPurchase+ "\n Gender: "+gender+"\n City: "+city);
            }
            scan.close();
        }catch(Exception e){
            System.out.println(e);
        }
     }
    public static double readTotalPurchase (String message) {
        System.out.print(message);
        double totalPurchase = userInput.nextDouble();
        return totalPurchase;
    }
    public static String readCustomerGender (String message) {
        String gender = "";
        while (true) {
            System.out.print(message);
            gender = userInput.nextLine();
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")){
                break;
            }
        }
        return gender;
    }
    public static String readCustomerCity (String message) {
        System.out.print(message);
        return userInput.nextLine();
    }
    public static void displayMainMenu () {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("------- Customer Management System ---------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println(" | A/a: Enter A or a for Adding Customer |");
        System.out.println(" | B/b: Enter B or b for Printing customers details |");
        System.out.println(" | C/c: Enter C or c for Search Customer details |"); 
        System.out.println(" | D/d: Enter D or d for Exiting the program |");

        System.out.println("-----------------------------------------------------------------");
        System.out.print("> Please enter your choice: ");
    }
    public static int displaySubmenuAndInput () {
        int input = 0;
        while (true) {
            System.out.println("> Enter 1 to search/display customer by ID number");
            System.out.println("> Enter 2 to search/display customer by name");
            System.out.println("> Enter 0 to return to the Main Menu");
            System.out.print("> Please choice: ");
            input = userInput.nextInt();
            userInput.nextLine();
            if (input == 1 || input == 2 || input == 0) {
                break;
            } else {
                System.out.println("Invalid selection! Please try again.");
            }
        }
        return input;
    }
    public static char inputAndCheck() {
        String input = "";
        while (true) {
            input = userInput.nextLine();
            if (input.equalsIgnoreCase("A") || input.equalsIgnoreCase("B") || input.equalsIgnoreCase("C")||input.equalsIgnoreCase("D")) {
                break;
            } else {
                System.out.println("Invalid selection! Please try again.");
            }
        }
        return input.charAt(0);
    }
    public static int search(int customerIDs, int customerID, int customerCount) {
        for (int i=0;i<customerCount;i++) {
            if (customerIDs == customerID) {
                return i;
            }
        }
        return 1;
    }
    public static int Search(String firstNames,String lastNames, String firsName,String lastName, int customerCount) {
        for (int i=0;i<customerCount;i++) {
            if (firstNames.equalsIgnoreCase(firsName) && lastNames.equalsIgnoreCase(lastName)) {
                return i;
            }
        }
        return 1;
    }
    public static void displayCustomerInformation (int customerID,String firstName, String lastName,
                                                   double totalPurchase,String gender, String city) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Customer ID: " + customerID);
        System.out.println("Customer Name: " + firstName + " " + lastName);
        System.out.println("Customer Total Purchase: " + (int)totalPurchase);
        System.out.println("Customer Gender: " + gender);
        System.out.println("Customer City: " + city);
        System.out.println("");
    }
}
