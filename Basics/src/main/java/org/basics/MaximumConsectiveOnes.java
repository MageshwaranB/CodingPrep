package org.basics;

public class MaximumConsectiveOnes {
    public static void main(String[] args) {
        int[] array = { 1, 1, 0, 0, 1, 1, 1, 0, 0, 1,1,1,1, 1,0, 1, 1, 1,1 };
        findConsecutiveOnes(array);
    }

    private static void findConsecutiveOnes(int[] array) {
        int count=0;
        int max=0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i]==array[i+1]){
                count++;
            }
            else {
                count=0;
            }
            if (count>=max){
                max=Math.max(max,count+1);
            }
        }
        System.out.println(max);
    }
}
