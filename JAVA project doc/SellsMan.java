
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class SellsMan {
    
    public static Scanner userInput = new Scanner(System.in);
    public static int ID;
    public static String lastName;
    public static String firstName;
    public static double totalSell;
    public static String gender;
    public static int SellsmanCount = 0;
     public static void addSellsman () throws FileNotFoundException {
          try{
                    Formatter formatter1 = new Formatter("G:/Rity/Java/Project/Supershop/Sellsman.txt");
           System.out.print("Enter Sellsman ID: ");
        ID= userInput.nextInt();
        userInput.nextLine();
        System.out.print("Enter Sellsman Last Name: ");
        lastName = userInput.nextLine();
        System.out.print("Enter Sellsman First Name: ");
        firstName = userInput.nextLine();
        totalSell = readTotalSells("Enter Total Sells: ");
        gender = readSellsmanGender("Enter Sellsman Gender: ");
                    
                    formatter1.format("%s   %s   %s   %s   %s\r\n",ID,firstName,lastName,totalSell,gender);
                     formatter1.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
       
        SellsmanCount ++;
    }
     }
     public static void printSellsMan() throws FileNotFoundException{
         
        try{
            File file = new File("G:/Rity/Java/Project/Supershop/Sellsman.txt");
            Scanner scan= new Scanner(file);
            while(scan.hasNext()){
                
            int ID=scan.nextInt();
            String lastName=scan.next();
            String firstName=scan.next();
            double totalSell=scan.nextDouble();
            String gender=scan.next();
            System.out.println("ID: "+ID+"\n Name: "+firstName+" "+lastName+"\n TotalPurched: "+totalSell+ "\n Gender: "+gender);
            }
            scan.close();
        }catch(Exception e){
            System.out.println(e);
        }
     }
    public static double readTotalSells (String message) {
        System.out.print(message);
        double totalSells = userInput.nextDouble();
        return totalSells;
    }
    public static String readSellsmanGender (String message) {
        String gender = "";
        while (true) {
            System.out.print(message);
            gender = userInput.nextLine();
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")){
                break;
            } else {
                System.out.println("Invalid input! (gender must be male or female)");
            }
        }
        return gender;
    }
    public static void displayMainMenu () {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("------- Customer Management System ---------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println(" | A/a: Enter A or a for Adding Sellsman |");
        System.out.println(" | B/b: Enter B or b for Printing Sellsman details |");
        System.out.println(" | C/c: Enter C or c for Search Sellsman details |"); 
        System.out.println(" | D/d: Enter D or d for Exiting the program |");
        System.out.println("-----------------------------------------------------------------");
        System.out.print("> Please enter your choice: ");
    }
    public static int displaySubmenuAndInput () {
        int input = 0;
        while (true) {
            System.out.println("> Enter 1 to search/display sellsman by ID number");
            System.out.println("> Enter 2 to search/display sellsman by name");
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
    public static int search(int IDs, int ID, int SellsmanCount) {
        for (int i=0;i<SellsmanCount;i++) {
            if (IDs == ID) {
                return i;
            }
        }
        return 1;
    }
    public static int Search(String firstNames,String lastNames, String firsName,String lastName, int SellsmanCount) {
        for (int i=0;i<SellsmanCount;i++) {
            if (firstNames.equalsIgnoreCase(firsName) && lastNames.equalsIgnoreCase(lastName)) {
                return i;
            }
        }
        return 1;
    }
    public static void displaySellsmanInformation (int ID,String firstName, String lastName,
                                                   double totalsells,String gender) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Sellsman ID: " + ID);
        System.out.println("Sellsman Name: " + firstName + " " + lastName);
        System.out.println("Sellsman Total Sells: " + (int)totalsells);
        System.out.println("Sellsman Gender: " + gender);
        System.out.println("");
    }
}
