package org.basics;

public class PyramidPattern {
    public static void main(String[] args) {
        pyramidPattern(5);
        }

    private static void pyramidPattern(int n) {
        int space=n-1;
        int star=1;
        for(int i=0;i<n;i++){
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int k=0;k<star;k++){
                System.out.print("*");
            }
            System.out.println();
            space--;
            star=star+2;
    }
}
}
