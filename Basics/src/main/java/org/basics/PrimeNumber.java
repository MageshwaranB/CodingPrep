package org.basics;

import java.util.LinkedList;

public class PrimeNumber {
    public static void main(String[] args) {
        /*
        1 2 3 5 7 11
         */
        System.out.println(isPrime(11));
        LinkedList<Integer> list = getPrime(10);
        System.out.println("Prime Number");
        list.forEach(value -> System.out.println(value));
    }

    public static boolean isPrime(int number){
        int i=2;
        while(i <= number/2){
            if (number % i ==0){
                break;
            }
            i++;
        }
        if (i > number/2){
            System.out.println("Prime");
            return true;
        }
        else {
            System.out.println("Not prime");
            return false;
        }
    }
    public static LinkedList<Integer> getPrime(int limit){
        LinkedList<Integer> prime=new LinkedList<>();
        int count=0;
        int num=2;
        while (count<limit){
            if(isPrime(num)){
                System.out.println("Prime");
                prime.add(num);
            }
            count++;
            num++;
        }
        return prime;
    }
}

