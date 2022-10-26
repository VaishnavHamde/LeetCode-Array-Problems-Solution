package com.debugger.problems;
import java.util.*;

public class Debugger {
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(
singleNonDuplicate(new int[] {1,1,3,3,4,4,8,8,9,9,10,11,11,12,12,13,13,14,14,15,15,16,16}));
	}
	
	static public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        if(nums.length == 1)
            return nums[0];
        
        if(nums[0] != nums[1])
            return nums[0];
        
        if(nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length-1];
        
        while(low <= high){
            int mid = (low + high)/2;
            int temp = nums[mid];
            if(mid == 0){
                if(nums[mid] != nums[mid+1]){
                    return nums[mid];
                }
            }
            else if(mid == nums.length-1){
                if(nums[mid] != nums[mid - 1]){
                    return nums[mid];
                }
            }
            else if(nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]){
                return nums[mid];
            }
            
            if((mid - low)%2 == 0){
            	if(mid == low)
            		low = mid+1;
            	else if(mid == high)
            		high = mid - 1;
            	else if(nums[mid] == nums[mid-1]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
            	if(mid == low)
            		low = mid+1;
            	else if(mid == high)
            		high = mid - 1;
            	else if(nums[mid] == nums[mid-1]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            
        }
        
        return -1;
    }
}
