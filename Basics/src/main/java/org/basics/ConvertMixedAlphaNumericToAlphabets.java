package org.basics;

public class ConvertMixedAlphaNumericToAlphabets {
    public static void main(String[] args) {
        String input="a2b3c4d1";
        String alphabetString="";
        for (int i=0;i<input.length();i++){
//            var currentCharacter=input.charAt(i);
            System.out.println("Current Character :"+input.charAt(i));
            if (Character.isAlphabetic(input.charAt(i))){
                alphabetString=alphabetString+input.charAt(i);
            }
            else {
                int numericValue=Character.getNumericValue(input.charAt(i));
                for (int j=1;j<numericValue;j++){
                    alphabetString=alphabetString+input.charAt(i-1);
                }
            }
        }
        System.out.println(alphabetString);
    }
}
