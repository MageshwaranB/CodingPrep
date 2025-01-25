package org.basics;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JavaIfElseProblem {
    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);

        /*
        Task
        Given an integer, , perform the following conditional actions:

        If  is odd, print Weird
        If  is even and in the inclusive range of  2 to 5, print Not Weird
        If  is even and in the inclusive range of 6 to 10, print Weird
        If  is even and greater than 20 , print Not Weird
        Complete the stub code provided in your editor to print whether or not  is weird.

        Input Format

        A single line containing a positive integer, .

        Constraints

        Output Format

        Print Weird if the number is weird; otherwise, print Not Weird.
         */

        var scanner=new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (N%2!=0){
            System.out.println("Weird");
        } else if (N%2==0) {
                if (N>=2 && N<=5){
                    System.out.println("Not Weird");
                }
                if (N>=6 && N<=20){
                    System.out.println("Weird");
                }
                if (N>20){
                    System.out.println("Not Weird");
                }

        }
        scanner.close();
    }
}