package org.basics;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String text="GeeksForGeeks";
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i=0;i<text.length();i++)
        {
            var currentValue=text.charAt(i);
            if (map.containsKey(text.charAt(i))){
                map.put(currentValue, map.get(currentValue)+1);
            }
            else {
                  map.put(currentValue,1);
            }
        }
        for (int i=0;i<text.length();i++){
            Character character=text.charAt(i);
            if (map.get(character)==1){
                System.out.println("Non repeating character: "+character);
                break;
            }
        }
    }
}
