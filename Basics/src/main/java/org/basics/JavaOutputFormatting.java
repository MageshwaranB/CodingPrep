package org.basics;

import java.util.Scanner;

public class JavaOutputFormatting {
    /*
    Java's System.out.printf function can be used to print formatted output. The purpose of this exercise is to test your understanding of formatting output using printf.

    To get you started, a portion of the solution is provided for you in the editor; you must format and print the input to complete the solution.

    Input Format

    Every line of input will contain a String followed by an integer.
    Each String will have a maximum of 10  alphabetic characters, and each integer will be in the inclusive range from  to 0 to 999

    Output Format

    In each line of output there should be two columns:
    The first column contains the String and is left justified using exactly 15 characters.
    The second column contains the integer, expressed in exactly 3 digits; if the original input has less than three digits, you must pad your output's leading digits with zeroes.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            //Complete this line
            if (x>= 10 && x <100 && s1.length()<=10){
                String convertedString= "0" + x;
                System.out.printf( "%-15s %-15s%n", s1, convertedString);
            }
            else if(s1.length()<=10) {
                System.out.printf( "%-15s %-15s%n", s1, x);
            }
        }
        System.out.println("================================");

    }
}