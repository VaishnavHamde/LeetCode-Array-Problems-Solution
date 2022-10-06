package com.debugger.problems;

public class Debugger {
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,4,5,18,17,6};
		 System.out.println(maxArea(arr));;
		 System.out.println(arr.length);
	}
	
	 static public int maxArea(int[] height) {
	        if(height.length == 1)
	            return 0;
	            
	        int i = 0;
	        int j = i + 1;
	        int max = 0;
	        
	        for(j = i+1; j < height.length; j++){
	             max = Math.max(max, (j-i) * Math.min(height[i],height[j]));
	            if(j == height.length - 1){
	                i++;
	                j = i+1;
	            }
	        }
	        
	        return max;
	    }
}
