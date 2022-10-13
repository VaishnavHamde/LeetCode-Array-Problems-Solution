// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

/*
	Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
	If target is not found in the array, return [-1, -1].
	You must write an algorithm with O(log n) runtime complexity.
	
	Example 1:
	
	Input: nums = [5,7,7,8,8,10], target = 8
	Output: [3,4]
	Example 2:
	
	Input: nums = [5,7,7,8,8,10], target = 6
	Output: [-1,-1]
	Example 3:
	
	Input: nums = [], target = 0
	Output: [-1,-1]
	
	Constraints:
	
	0 <= nums.length <= 105
	-109 <= nums[i] <= 109
	nums is a non-decreasing array.
	-109 <= target <= 109
*/

package com.medium.problems;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
	public int[] searchRange(int[] nums, int target) {
        int res = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = (low+high)/2;
            if(target < nums[mid])
                high = mid-1;
            else if(target > nums[mid])
                low = mid+1;
            else{
                res = mid;
                break;
            } 
        }
         if((res == -1 && nums.length > 1) || nums.length == 0 || (nums.length == 1 && nums[0] != target))
                return new int[]{-1, -1};
            
        if(nums.length == 1 && nums[0] == target)
            return new int[]{0,0};
        
            int i = res;
            int j = res;
            while(i >= 0 && nums[i] == nums[res] )
                i--;
            while(j < nums.length && nums[j] == nums[res])
                j++;
        return new int[]{i+1, j-1};
    }
}
