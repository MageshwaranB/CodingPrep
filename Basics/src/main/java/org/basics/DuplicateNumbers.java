package org.basics;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class DuplicateNumbers {
    public static void main(String[] args) {
        int[] array = { 3, 2, 1, 1, 2, 2, 3, 2, 1, 3 };
        LinkedList<Integer> integerLinkedList=new LinkedList<>();
        for (int i=0;i<array.length-1;i++){
            int count=0;
            for (int j = 1; j < array.length-1; j++) {
                if (array[i]==array[j]){
                    count++;
                }
            }
            if ((count>0)&&(!integerLinkedList.contains(array[i]))){
                integerLinkedList.add(array[i]);
            }
        }
        System.out.println(integerLinkedList);
    }
}
