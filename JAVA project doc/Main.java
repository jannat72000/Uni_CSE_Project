
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static project.Customer.userInput;
import static project.Product.productName;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File dir= new File("G:/Rity/Java/Project/Supershop");
        dir.mkdir();
        File file1= new File("G:/Rity/Java/Project/Supershop/Customer.txt");
        File file2= new File("G:/Rity/Java/Project/Supershop/Product.txt");
        File file3= new File("G:/Rity/Java/Project/Supershop/Sellsman.txt");
        File file4= new File("G:/Rity/Java/Project/Supershop/Store.txt");
        File file5= new File("G:/Rity/Java/Project/Supershop/Payment.txt");

        try{
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
            file4.createNewFile(); 
            file5.createNewFile();
            System.out.println("File has been created.");
            
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("------------Welcome to the SuperShop Management System------------");
        System.out.println("-----------------------------------------------------------------");
         while (true) {
            int ch= choose();
             if(ch==1){ 
             Customer customer = new Customer();          
                 while (true) {
            customer.displayMainMenu();
            char choice = customer.inputAndCheck();
            if (choice == 'A' || choice == 'a') {
                customer.addCustomer();
            } 
            else if (choice == 'B' || choice == 'b') {
                                customer.printCoustomer();
                     }
            else if(choice=='C'||choice=='c'){
                while (true) {
                    int subChoice = customer.displaySubmenuAndInput();
                    if (subChoice == 1) {
                        System.out.print("Enter Customer ID: ");
                        int ID = customer.userInput.nextInt();
                        customer.userInput.nextLine();
                        Customer.search(customer.customerID, ID, customer.cutsomerCount);
                        customer.displayCustomerInformation(customer.customerID, customer.firstName, customer.lastName, customer.totalPurchase,
                         customer.gender, customer.city);
                    } else if (subChoice == 2) {
                        System.out.print("Enter Customer First Name: ");
                        String custFirstName = customer.userInput.nextLine();
                        System.out.print("Enter Customer Last Name: ");
                        String custLastName = customer.userInput.nextLine();
                        customer.Search(customer.firstName, customer.lastName, custFirstName, custLastName, customer.cutsomerCount);
                       customer.displayCustomerInformation(customer.customerID, customer.firstName, customer.lastName, customer.totalPurchase,
                               customer.gender, customer.city);
                    } else if (subChoice == 0) {
                        break;
                    }
                }
            }
                 else if (choice == 'D' || choice == 'd') {
                System.out.println("...................................... Thanks you for using the Customer Management System!...............................");
                break;
            }
        }                 
             }
             
             else if(ch==2){    
              Product product = new Product();
                  while (true) {
            product.displayMainMenu();
            char choice = product.inputAndCheck();
            if (choice == 'A' || choice == 'a') {
                product.addProduct ();
            }
            
            else if (choice == 'B' || choice == 'b') {
                product.printProduct();
            }
                        else if(choice=='C'||choice=='c'){
                while (true) {
                    int subChoice = product.displaySubmenuAndInput();
                    if (subChoice == 1) {
                        System.out.print("Enter Product ID: ");
                        int ID = product.userInput.nextInt();
                        product.userInput.nextLine();
                        product.search(product.productID, ID, product.productCount);
                        product.displayProductInformation(product.productID, productName,
                         product.amount, product.quantity);
                    } else if (subChoice == 2) {
                        System.out.print("Enter Product Name: ");
                        String proproductName= product.userInput.nextLine();
                        product.Search(product.productName, proproductName, product.productCount);
                       product.displayProductInformation(product.productID,product.productName, 
                               product.amount, product.quantity);
                    } else if (subChoice == 0) {
                        break;
                    }
                }
            } 
            else if (choice == 'D' || choice == 'd') {
                System.out.println(".................................. Thanks you for using the Product Management System!....................................");
                break;
            }
        }                 

            }
             else if(ch==3){
             SellsMan sellsman = new SellsMan();          
                 while (true) {
            sellsman.displayMainMenu();
            char choice = sellsman.inputAndCheck();
            if (choice == 'A' || choice == 'a') {
                sellsman.addSellsman ();
            } 
            else if (choice == 'B' || choice == 'b') {
            sellsman.printSellsMan();
            }
            else if (choice == 'C' || choice == 'c') {
                while (true) {
                    int subChoice = sellsman.displaySubmenuAndInput();
                    if (subChoice == 1) {
                        System.out.print("Enter Sellsman ID: ");
                        int ID = sellsman.userInput.nextInt();
                        sellsman.userInput.nextLine();
                        int index = sellsman.search(sellsman.ID, ID, sellsman.SellsmanCount);
                        sellsman.displaySellsmanInformation(sellsman.ID, sellsman.firstName, sellsman.lastName, sellsman.totalSell,
                         sellsman.gender);
                    } else if (subChoice == 2) {
                        System.out.print("Enter sellsman First Name: ");
                        String custFirstName = sellsman.userInput.nextLine();
                        System.out.print("Enter sellsman Last Name: ");
                        String custLastName = sellsman.userInput.nextLine();
                       sellsman.Search(sellsman.firstName, sellsman.lastName, custFirstName, custLastName, sellsman.SellsmanCount);
                       sellsman.displaySellsmanInformation(sellsman.ID, sellsman.firstName, sellsman.lastName, sellsman.totalSell,
                               sellsman.gender);
                    } else if (subChoice == 0) {
                        break;
                    }
                }
            }
                 else if (choice == 'D' || choice == 'd') {
                System.out.println(".................................... Thanks you for using the sellsman Management System!.................................");
                break;
            }
             }
             }
             else if(ch==4){
             Stores store = new Stores();   
         while (true) {
            store.displayMainMenu();
            char choice = store.inputAndCheck();
            if (choice == 'A' || choice == 'a') {
                store.addStore ();
            } else if (choice == 'B' || choice == 'b') {
            store.printStore();
            }
                             else if (choice == 'C' || choice == 'c') {

                while (true) {
                    int subChoice = store.displaySubmenuAndInput();
                    if (subChoice == 1) {
                        System.out.print("Enter Store ID: ");
                        int ID = store.userInput.nextInt();
                        store.userInput.nextLine();
                         store.search(store.storeID, ID, store.storeCount);
                        store.displayStoreInformation(store.storeID, store.Branch, store.Address);
                    } else if (subChoice == 2) {
                        System.out.print("Enter sellsman Branch Name: ");
                        String strBranch = store.userInput.nextLine();
                        store.Search(store.Branch,strBranch, store.storeCount);
                       store.displayStoreInformation(store.storeID, store.Branch, store.Address);
                    } else if (subChoice == 0) {
                        break;
                    }
                }
            }
                 else if (choice == 'D' || choice == 'd') {
                System.out.println("..................................... Thanks you for using the store Management System!...................................");
                break;
            }
             }
             }
             else if (ch==5){
                 Memo m= new Memo();
                 m.memo();
             }
             else if (ch==6){
                                  Memo m= new Memo();
                                  m.sellDetails();
             }
             else if(ch==0){
                 
                System.out.println("..................................... Thanks you for using the SuperShop Management System!...............................");
                System.out.println("..................................................... Good Bye........................................................... ");
                break;
             }
         }
                      userInput.close();
    }
     public static int choose(){
     Scanner userInput = new Scanner(System.in);

    int input = 0;
        while (true) {
        System.out.println(" | 1: Enter 1 for Customer |");
        System.out.println(" | 2: Enter 2 for Products |");
        System.out.println(" | 3: Enter 3 for Sealsmen |");
        System.out.println(" | 4: Enter 4 for StoreInfo |");
        System.out.println(" | 5: Enter 5 for Purches |");       
        System.out.println(" | 6: Enter 6 for Sell Details |");       
        System.out.println(" | 0: Enter 0 for Exit |");
        System.out.println("-----------------------------------------------------------------");
        System.out.print("> Please enter your choice: ");
            input = userInput.nextInt();
                        userInput.nextLine();

            if (input == 1 || input == 2 || input == 3||input==4||input==5||input==6||input==0) {
                break;
            } else {
                System.out.println("Invalid selection! Please try again.");
            }
        }
        return input;
    }
        }
