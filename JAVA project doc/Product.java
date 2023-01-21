
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Product {
    
    
    public static Scanner userInput = new Scanner(System.in);
    public static int productID;
    public static String productName;
    public static double amount;
    public static int quantity;
    public static int productCount = 0;
     public static void addProduct () throws FileNotFoundException {
          try{
               Formatter formatter1 = new Formatter("G:/Rity/Java/Project/Supershop/Product.txt");
           System.out.print("Enter Product ID: ");
        productID= userInput.nextInt();
        userInput.nextLine();
        System.out.print("Enter Product Name: ");
        productName = userInput.nextLine();
           System.out.print("Enter Amount: ");
           amount= userInput.nextDouble();
           System.out.print("Enter Quantity: ");
        quantity= userInput.nextInt();
                    
                    formatter1.format("%s   %s   %s   %s\r\n",productID,productName,amount,quantity);
                     formatter1.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
       
        productCount ++;
    }
     }
     public static void printProduct() throws FileNotFoundException{
         
        try{
            File file = new File("G:/Rity/Java/Project/Supershop/Product.txt");
            try (Scanner scan = new Scanner(file)) {
                while(scan.hasNext()){
                    int productID=scan.nextInt();
                    String productName=scan.next();
                    double amount=scan.nextDouble();
                    int quantity=scan.nextInt();
                    System.out.println("Product ID: "+productID+"\n Product Name: "+productName+"\n Amount: "+amount+ "\n Quantity: "+quantity);
                }
                scan.close();
            }
          
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
     } 
    public static void displayMainMenu () {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("------- Product Management System ---------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println(" | A/a: Enter A or a for Adding Product |");
        System.out.println(" | B/b: Enter B or b for Printing Product details |");   
        System.out.println(" | C/c: Enter C or c for Search Product details |");
        System.out.println(" | D/d: Enter D or d for Exiting the program |");
        System.out.println("-----------------------------------------------------------------");
        System.out.print("> Please enter your choice: ");
    }
    public static int displaySubmenuAndInput () {
        int input = 0;
        while (true) {
            System.out.println("> Enter 1 to search/display Product by ID number");
            System.out.println("> Enter 2 to search/display Product by name");
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
            if (input.equalsIgnoreCase("A") || input.equalsIgnoreCase("B") || input.equalsIgnoreCase("C")|| input.equalsIgnoreCase("D")) {
                break;
            } else {
                System.out.println("Invalid selection! Please try again.");
            }
        }
        return input.charAt(0);
    }
    public static int search(int productIDs, int productID, int productCount) {
        for (int i=0;i<productCount;i++) {
            if (productIDs == productID) {
                return i;
            }
        }
        return 1;
    }
    public static int Search(String productNames, String productName, int productCount) {
        for (int i=0;i<productCount;i++) {
            if (productNames.equalsIgnoreCase(productName)) {
                return i;
            }
        }
        return 1;
    }
    public static void displayProductInformation (int productID,String productName,double amount, int quantity) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Product Amount: " + (double)amount);
        System.out.println("Product Quantity: " + (int)quantity);
        System.out.println("");
    }
}
