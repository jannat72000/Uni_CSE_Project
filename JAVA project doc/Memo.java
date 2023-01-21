
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Memo extends Customer{
        Scanner input = new Scanner(System.in);
            public void memo() throws FileNotFoundException{
        Purches p = new Purches();
          try{
             Formatter formatter1 = new Formatter("G:/Rity/Java/Project/Supershop/Payment.txt");

        System.out.print("Enter Customer Name: ");
        String name=input.next();
        System.out.print("Enter Customer Address: ");
        String address=input.next();
        System.out.print("Enter Customer Modile Number: ");
        String mbnm=input.next();
        System.out.print("Enter Customer age: ");  
        int age=input.nextInt();
        System.out.print("Enter Customer Email: ");
        String email=input.next();
        double i=p.Total();
        formatter1.format("%s   %s   %s   %s   %s   %s\r\n",name,address,mbnm,age,email,i);

        System.out.println(".......................COME AGAIN.......................\n\t\t\t THANK YOU\t\t");
        formatter1.close();
    }catch( FileNotFoundException e){
                System.out.println(e);
   }
     }
            public void sellDetails(){
                try{
            File file = new File("G:/Rity/Java/Project/Supershop/Payment.txt");
            try (Scanner scan = new Scanner(file)) {
                while(scan.hasNext()){
                    String name=scan.next();
                    String address=scan.next();
                    String mbnm=scan.next();
                    int age=scan.nextInt();
                    String email=scan.next();
                    double i=scan.nextDouble();
                    System.out.println("Name: "+name+"\n Address: "+address+"\n Mobile Numbert: "+mbnm+ "\n Age: "+age+"\n Email: "+email+"Purches: "+i);
                }
                scan.close();
            }
          
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
            }
}
       
