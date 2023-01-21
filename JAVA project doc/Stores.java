
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Stores {
     public static Scanner userInput = new Scanner(System.in);
    public static int storeID;
    public static String Branch;
    public static String Address;
    public static int storeCount = 0;
     public static void addStore () throws FileNotFoundException {
          try{
               Formatter formatter1 = new Formatter("G:/Rity/Java/Project/Supershop/Product.txt");
           System.out.print("Enter Product ID: ");
        storeID= userInput.nextInt();
        userInput.nextLine();
        System.out.print("Enter Branch: ");
        Branch = userInput.nextLine();
        System.out.print("Enter Address: ");
        Address = userInput.nextLine();
                    
                    formatter1.format("%s   %s   %s\r\n",storeID,Branch,Address);
                     formatter1.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
       
        storeCount ++;
    }
     }
     public static void printStore() throws FileNotFoundException{
         
        try{
            File file = new File("G:/Rity/Java/Project/Supershop/Product.txt");
            try (Scanner scan = new Scanner(file)) {
                while(scan.hasNext()){
                    int storeID=scan.nextInt();
                    String Branch=scan.next();
                    String Address=scan.next();
                    System.out.println("Branch ID: "+storeID+"\n Branch Name: "+Branch+"\n Branch Address: "+Address);
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
        System.out.println(" | A/a: Enter A or a for Adding Store |");
        System.out.println(" | B/b: Enter B or b for Printing Store details |");
        System.out.println(" | C/c: Enter C or c for Search Store |");
        System.out.println(" | D/d: Enter D or d for Exiting the program |"); 
        System.out.println("-----------------------------------------------------------------");
        System.out.print("> Please enter your choice: ");
    }
    public static int displaySubmenuAndInput () {
        int input = 0;
        while (true) {
            System.out.println("> Enter 1 to search/display Store by ID number");
            System.out.println("> Enter 2 to search/display Store by name");
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
    public static int search(int storeIDs, int storeID, int storeCount) {
        for (int i=0;i<storeCount;i++) {
            if (storeIDs == storeID) {
                return i;
            }
        }
        return 1;
    }
    public static int Search(String Branchs, String Branch, int storeCount) {
        for (int i=0;i<storeCount;i++) {
            if (Branchs.equalsIgnoreCase(Branch)) {
                return i;
            }
        }
        return 1;
    }
    public static void displayStoreInformation (int storeID,String Branch,
                                                   String Address) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Store ID: " + storeID);
        System.out.println("Store Branch Name: " + Branch);
        System.out.println("Store Address: " +Address);
        System.out.println("");
    }
}
