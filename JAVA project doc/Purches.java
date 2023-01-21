
package project;

import java.util.Scanner;

public class Purches extends Product{
    
    Scanner input = new Scanner(System.in);
    public double Total(){
        System.out.print("Enter your total item: ");
        int i = input.nextInt();
        System.out.print("Enter ammount: ");
        double a= input.nextDouble();
        System.out.print("Enter Customer Money: ");
        double M= input.nextInt();
        double MB= M-(i*a);
        return MB;
             }
}
