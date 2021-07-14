package com.simplilearn.calculator;

import java.util.Scanner;

public class Utility {
    public static void main(String[] args) {
        // write your code here
        Calc c = new Calc();
        Scanner sc = new Scanner(System.in);

        int choice, num1, num2;

        System.out.println("Select the operation needed to be performed by entering the number: ");
        System.out.println("1. Add 2 numbers");
        System.out.println("2. Subtract 2 numbers");
        System.out.println("3. Multiply 2 numbers");
        System.out.println("4. Divide one number by another");
        System.out.println("5. Find the Square Root of a number");
        System.out.println("6. Find the Percentage of one number over another");
        System.out.print("Enter your choice: ");
        System.out.println();

        choice = sc.nextInt();

        switch (choice){
            case 1:
                System.out.print("Enter 1st number: ");
                num1 = sc.nextInt();
                System.out.println();
                System.out.print("Enter 2nd number: ");
                num2 = sc.nextInt();
                System.out.println();
                c.add(num1, num2);
                break;

            case 2:
                System.out.print("Enter 1st number: ");
                num1 = sc.nextInt();
                System.out.println();
                System.out.print("Enter 2nd number: ");
                num2 = sc.nextInt();
                System.out.println();
                c.subtract(num1, num2);
                break;

            case 3:
                System.out.print("Enter 1st number: ");
                num1 = sc.nextInt();
                System.out.println();
                System.out.print("Enter 2nd number: ");
                num2 = sc.nextInt();
                System.out.println();
                c.multiply(num1, num2);
                break;

            case 4:
                System.out.print("Enter 1st number: ");
                num1 = sc.nextInt();
                System.out.println();
                System.out.print("Enter 2nd number: ");
                num2 = sc.nextInt();
                System.out.println();
                c.divide(num1, num2);
                break;

            case 5:
                System.out.print("Enter the number: ");
                num1 = sc.nextInt();
                System.out.println();
                c.squareRoot(num1);
                break;

            case 6:
                System.out.print("Enter 1st number: ");
                num1 = sc.nextInt();
                System.out.println();
                System.out.print("Enter 2nd number: ");
                num2 = sc.nextInt();
                System.out.println();
                c.percentage(num1, num2);
                break;

            default:
                System.out.println("Wrong selection, try again !!");
                break;
        }

    }
}
