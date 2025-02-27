package org.basics;

import java.util.Scanner;

public class JavaLoops2 {
    /*
    We use the integers , , and  to create the following series:

        You are given  queries in the form of , , and . For each query, print the series corresponding to the given , , and  values as a single line of  space-separated integers.

        Input Format

        The first line contains an integer, , denoting the number of queries.
        Each line  of the  subsequent lines contains three space-separated integers describing the respective , , and  values for that query.

        Constraints

        Output Format

        For each query, print the corresponding series on a new line. Each series must be printed in order as a single line of  space-separated integers.

        Sample Input

        2
        0 2 10
        5 3 5
        Sample Output

        2 6 14 30 62 126 254 510 1022 2046
        8 14 26 50 98
        Explanation

        We have two queries:

        We use , , and  to produce some series :

        ... and so on.

        Once we hit , we print the first ten terms as a single line of space-separated integers.

        We use , , and  to produce some series :

        We then print each element of our series as a single line of space-separated values.
     */
    public static void main(String []argh) {
        Scanner in = new Scanner(System.in);
        int queries =in.nextInt();
        check(queries,in);

    }
    public static void check(int queries,Scanner in){
        for (int i = 0; i < queries; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            int total =in.nextInt();
            int res=0;
            int sum=0;
            int adder=0;
            while(total>0){
                res=0;
                for (int j=0;j<=adder;j++){
                    for (int k=j;k<=j;k++){
                        int powerRes=power(k);
                        res=powerRes*end+res;
                    }
                }
                sum=start+res;
                System.out.print(sum+" ");
                total--;
                adder++;
            }
        }
    }

    public static int power(int exponent){
        int base = 2;
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}
