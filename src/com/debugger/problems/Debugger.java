package com.debugger.problems;

public class Debugger {
	public static void main(String[] args) {
		int[] arr = new int[] {5,-3,5};
		 System.out.println(maxSubarraySumCircular(arr));
	}
	
	 static public int maxSubarraySumCircular(int[] nums) {
	        int res = nums[0];
	        int maxEnding = nums[0];
	        boolean bool = true;
	        int count = 0;
	        
	        for(int i = 1; i < nums.length; i++){
	            if(count != nums.length){
	                maxEnding = Math.max(maxEnding + nums[i], nums[i]);
	                if(maxEnding == nums[i])
	                    count = 0;
	                res = Math.max(res, maxEnding);
	                if(i == nums.length - 1 && bool == true){
	                    bool = false;
	                    i = -1;
	                }
	                count++;
	            }
	        }
	        return res;
	    }
}
