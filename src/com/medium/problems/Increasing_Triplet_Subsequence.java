// https://leetcode.com/problems/increasing-triplet-subsequence/

/*
	Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
	 If no such indices exists, return false.

	Example 1:
	
	Input: nums = [1,2,3,4,5]
	Output: true
	Explanation: Any triplet where i < j < k is valid.
	Example 2:
	
	Input: nums = [5,4,3,2,1]
	Output: false
	Explanation: No triplet exists.
	Example 3:
	
	Input: nums = [2,1,5,0,4,6]
	Output: true
	Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
	 
	Constraints:
	
	1 <= nums.length <= 5 * 105
	-231 <= nums[i] <= 231 - 1
	 
*/

package com.medium.problems;

public class Increasing_Triplet_Subsequence {
	public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)
            return false;
        
        boolean bool = false;
        int n = nums.length;
        int[] lMin = new int[n];
        int[] rMax = new int[n];
        lMin[0] = nums[0];
        rMax[n - 1] = nums[n - 1];
        
        for(int i = 1; i < n; i++){
            lMin[i] = Math.min(lMin[i-1], nums[i]);
            rMax[n - 1 - i] = Math.max(rMax[n - i], nums[n - 1 - i]);
        }
        
        for(int i = 1; i < nums.length - 1; i++){
            if(lMin[i] < nums[i] && nums[i] < rMax[i])
                return true;
        }
        
        return false;
    }
}
