package org.basics;

public class FibonacciSeries {
    public static void main(String[] args) {
        int range=5;
        int f1=0;
        int f2=1;
        int f3=f1+f2;
        while (range>0){
            f1=f2;
            f2=f3;
            f3=f1+f2;
            range--;
            System.out.println(f1);
        }

    }
}
