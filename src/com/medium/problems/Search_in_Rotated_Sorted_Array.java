// https://leetcode.com/problems/search-in-rotated-sorted-array/

/*
	There is an integer array nums sorted in ascending order (with distinct values).
	Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) 
	such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
	For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
	
	Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, 
	or -1 if it is not in nums.
	
	You must write an algorithm with O(log n) runtime complexity.
	
	Example 1:
	
	Input: nums = [4,5,6,7,0,1,2], target = 0
	Output: 4
	Example 2:
	
	Input: nums = [4,5,6,7,0,1,2], target = 3
	Output: -1
	Example 3:
	
	Input: nums = [1], target = 0
	Output: -1
	 
	Constraints:
	
	1 <= nums.length <= 5000
	-104 <= nums[i] <= 104
	All values of nums are unique.
	nums is an ascending array that is possibly rotated.
	-104 <= target <= 104
*/

package com.medium.problems;

public class Search_in_Rotated_Sorted_Array {
	public int search(int[] nums, int target) {
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
        boolean bool = false;
        
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
                bool = true;
                break;
            }
        }
        if(!bool)
            return -1;
        
        return (index + index1)%(nums.length);
    }

	public void reverse(int[] nums, int low, int high){
    while(low<high){
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
        low++;
        high--;
    	}
	}
}
