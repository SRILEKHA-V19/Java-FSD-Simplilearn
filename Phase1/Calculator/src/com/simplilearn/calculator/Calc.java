package com.simplilearn.calculator;

public class Calc {
    public void add(int x, int y){
        System.out.println("The sum of " + x + " and " + y + " is: " + (x + y));
    }

    public void subtract(int x, int y){
        System.out.println("The difference of " + x + " and " + y + " is: " + (x - y));
    }

    public void multiply(int x, int y){
        System.out.println("The multiplication of " + x + " by " + y + " is: " + (x * y));
    }

    public void divide(int x, int y){
        if(y == 0)
            System.out.println("Cannot divide a number by Zero(0), try again !");
        else
            System.out.println("The division of " + x + " by " + y + " is: " + (x / y));
    }

    public void squareRoot(int x){
        System.out.println("The square root of " + x + " is: " + (Math.sqrt(x)));
    }

    public void percentage(int x, int y){
        if(y == 0)
            System.out.println("Cannot divide a number by Zero(0) to find percentage, try again !");
        else
            System.out.println("The percentage of " + x + " out of " + y + " is: " + ((x / y) * 100.00));
    }

}
