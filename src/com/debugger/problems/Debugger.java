package com.debugger.problems;

public class Debugger {
	public static void main(String[] args) {
		int[] nums = new int[] {4,5,6,7,0,1,2};
		 System.out.println(search(nums, 0));
	}
	
	 static public int search(int[] nums, int target) {
	        int index = 0;
	        for(int i = 1; i < nums.length; i++){
	            if(nums[i]-nums[i-1] < 0) {
	            	index = i;
	            	break;
	            }
	                
	        }
	        
	        reverse(nums, 0, index-1);
	        reverse(nums, index, nums.length - 1);
	        reverse(nums, 0, nums.length - 1);
	        
	        int low = 0;
	        int high = nums.length - 1;
	        int index1 = -1;
	        
	        while(low<=high){
	            int mid = (low + high)/2;
	            if(nums[mid] > target){
	                high = mid-1;
	            }
	            else if(nums[mid] < target){
	                low = mid+1;
	            }
	            else{
	                index1 = mid;
	                break;
	            }
	        }
	        
	        return (index + index1)%(nums.length);
	    }
	 
	 static public void reverse(int[] nums, int low, int high){
	        while(low<high){
	            int temp = nums[low];
	            nums[low] = nums[high];
	            nums[high] = temp;
	            low++;
	            high--;
	        }
	    }
}
