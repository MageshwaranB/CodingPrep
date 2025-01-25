package org.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaLoops {
//    Objective
//    In this challenge, we're going to use loops to help us do some simple math.
//
//    Task
//    Given an integer, , print its first  multiples. Each multiple  (where ) should be printed on a new line in the form: N x i = result.
//
//            Input Format
//
//    A single integer, .
//
//    Constraints
//
//    Output Format
//
//    Print  lines of output; each line  (where ) contains the  of  in the form:
//    N x i = result.
public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(bufferedReader.readLine().trim());
    for (int i =1 ;i<=10;i++){
        System.out.printf("%d x %d = %d%n",N,i, N*i);
    }

    bufferedReader.close();
}
}
