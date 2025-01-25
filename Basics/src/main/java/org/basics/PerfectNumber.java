package org.basics;

public class PerfectNumber {
    /*
        Perfect Number - 28
        Divisor - 1,2,4,7,14
     */
    public static void main(String[] args) {
        int number=28;
        int sum=0;
        int a=1;

        while (a<=number/2){
            if (number%a==0){
                sum=sum+a;
            }
            a++;
        }
        if (sum==number){
            System.out.println("Perfect Number");
        }
        else {
            System.out.println("Not Perfect Number");
        }
    }
}
