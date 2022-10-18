package com.debugger.problems;
import java.util.*;

public class Debugger {
	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}
	
	public static String countAndSay(int n) {
//        if(n == 1)
//            return Integer.toString(1);
        String res = "";
        if(n > 0)
            res = number(2, "1113213211");
        return res;
    }
    
    public static String number(int n, String num){
        StringBuilder n1 = new StringBuilder("");
        if(n > 0){
            int count = 1;
            int temp = 1;
            String s = num;
            for(int i = 0; i < s.length()-1;i++){
                int f = i;
                while(i < s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                    if(f == 0)
                        f = i;
                    count++;
                    temp = count;
                    i++;
                }
                if(i != s.length()-1 && s.charAt(i) != s.charAt(i+1)){
                    count = 1;
                }
                n1.append(Integer.toString(temp));
                n1.append(Character.toString(s.charAt(f)));
            }
            
            if(s.charAt(s.length()-2) != s.charAt(s.length()-1)){
                n1.append(Integer.toString(1));
                n1.append(s.charAt(s.length()-1));
            }
            num = number(n-1, n1.toString());
        }
        return num;
    }
}
