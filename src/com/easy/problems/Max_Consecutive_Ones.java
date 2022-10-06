// https://leetcode.com/problems/max-consecutive-ones/

/*
	Given a binary array nums, return the maximum number of consecutive 1's in the array.
	
	Example 1:
	
	Input: nums = [1,1,0,1,1,1]
	Output: 3
	Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
	Example 2:
	
	Input: nums = [1,0,1,1,0,1]
	Output: 2
*/

package com.easy.problems;

public class Max_Consecutive_Ones {
	public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1)
                res++;
            else{
                max = Math.max(max, res);
                res = 0;
            }
            if(i == nums.length - 1 && res > max)
                return res;
        }
        return max;
    }
}
