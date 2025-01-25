package org.basics;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LongestConsecutiveNumbers {
    public static void main(String[] args) {
        /*
        As given in the array below, we have an array of integers. As you can see the longest consecutive occurrence of integers are 6,7,8,9. There is a consecutive increment of 1 . So the output will be 4.

         */

        int[] arr = { 4, 3, 25, 6, 7, 8, 9, 2, 3, 10,0,1,3,5,6,7,8,9,10,11 };

        int count = 0;
        int max =0;

        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] +1== arr[i+1]) {
                count++;
            }else {
                count = 0;
            }

            max = Math.max(max, count+1);
        }
        System.out.println(max);
    }
    }
