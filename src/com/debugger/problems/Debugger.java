package com.debugger.problems;

public class Debugger {
	public static void main(String[] args) {
		 System.out.println(rotateString("abcde", "cbdea"));
	}
	
	 static public boolean rotateString(String s, String goal) {
	        if(s.length() != goal.length())
	            return false;
	        
	        int x = s.length();
	        
	        for(int i = 0; i < x; i++){
	            char temp = s.charAt(0);
	            s = s.substring(1,x) + temp;
	            System.out.println(s);
	            if(equal(s, goal));
	                return true;
	        }
	         return false;
	    };
	    
	    static public boolean equal(String s, String goal){
	        for(int i = 0; i< s.length(); i++){
	            if(s.charAt(i) != goal.charAt(i))
	                return false;
	        }           
	        return true;
	    }
}
