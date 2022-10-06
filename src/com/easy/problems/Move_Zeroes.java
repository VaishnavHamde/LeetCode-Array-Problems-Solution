// https://leetcode.com/problems/move-zeroes/

/*
	Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

	Note that you must do this in-place without making a copy of the array.
	 
	Example 1:
	
	Input: nums = [0,1,0,3,12]
	Output: [1,3,12,0,0]
	Example 2:
	
	Input: nums = [0]
	Output: [0]
*/

package com.easy.problems;

public class Move_Zeroes {
	public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                swap(nums, i, count);
                count++;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
