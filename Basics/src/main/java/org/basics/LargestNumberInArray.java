package org.basics;

public class LargestNumberInArray {
    public static void main(String[] args) {
        int[] arr={1,23,13,54,102,5,12,57,17};
        int big=biggestNumber(arr);
        System.out.println("Largest number: "+big);
        int secondBig=secondBiggestNumber(arr);
        System.out.println("Second Largest number: "+secondBig);
        int[] array = sortArray(arr);
        printArray(array);
        boolean status=findElement(arr,102);
        System.out.println(status);
    }

    public static int biggestNumber(int[] arr) {
        int big = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > big) {
                big = arr[i];
            }
        }
        return big;
    }

    public static int secondBiggestNumber(int[] arr){
        int big = arr[0];
        int biggest=biggestNumber(arr);
        for (int i=0;i<arr.length;i++){
            if (arr[i]>big&&arr[i]!=biggest){
                big=arr[i];
            }
        }
        return big;
    }

    public static int[] sortArray(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                int tmp=0;
                if (arr[i]>arr[j]){
                    tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static boolean findElement(int[] arr, int element){
        boolean isElementFound=false;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==element){
                isElementFound=true;
            }
        }
        return isElementFound;
    }
}
