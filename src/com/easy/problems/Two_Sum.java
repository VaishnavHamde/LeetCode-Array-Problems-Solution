// https://leetcode.com/problems/two-sum/

/*
 	Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	You can return the answer in any order.
	
	Example 1:
	
	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
	Example 2:
	
	Input: nums = [3,2,4], target = 6
	Output: [1,2]
	Example 3:
	
	Input: nums = [3,3], target = 6
	Output: [0,1] 
	
*/

package com.easy.problems;


public class Two_Sum {
	public int[] twoSum(int[] nums, int target) {
        int memory = target;
        for(int i = 0; i<nums.length; i++){
            int temp1 = target - nums[i];
            for(int j = i+1; j<nums.length; j++){
                int temp2 = temp1 - nums[j];
                if(temp2 == 0){
                    int[] arr = new int[]{i, j};
                    return arr;
                }
            }
        }
        return new int[]{-1};
    }
}
