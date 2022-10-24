package com.debugger.problems;
import java.util.*;

public class Debugger {
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(shortestCompletingWord( "1s3 PSt" ,new String[] {"step","steps","stripe","stepple"}));
	}
	
	static public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap <Character, Integer> hm = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i < licensePlate.length(); i++){
            if(licensePlate.charAt(i) >= 65 && licensePlate.charAt(i) <=90 || licensePlate.charAt(i) >= 97 && licensePlate.charAt(i) <=122){
                hm.put(Character.toLowerCase(licensePlate.charAt(i)), hm.getOrDefault(Character.toLowerCase(licensePlate.charAt(i)), 0)+1);
                count++;
            }
        }
        
        String res = "abcdefghijklmnopqrstuvwxyz";
        
        for(int i = 0; i < words.length; i++){
            HashMap<Character, Integer> hm1 = new HashMap<>();
            hm1.putAll(hm);;
            int temp = count;
            for(int j = 0; j < words[i].length(); j++){
                if(hm1.containsKey(Character.toLowerCase(words[i].charAt(j)))){
                    temp--;
                    hm1.put(Character.toLowerCase(words[i].charAt(j)), hm1.get(Character.toLowerCase(words[i].charAt(j))-1));
                    if(hm1.get(words[i].toLowerCase().charAt(j)) == 0){
                        hm1.remove(Character.toLowerCase(words[i].charAt(j)));
                    }
                }
                if(temp == 0){
                    if(res.length() > words[i].length()){
                        res = words[i];
                    }
                }
            }
        }
        return res;
    }
}
