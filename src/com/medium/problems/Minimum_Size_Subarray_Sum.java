// https://leetcode.com/problems/minimum-size-subarray-sum/

/*
	Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous 
	subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. 
	If there is no such subarray, return 0 instead.
	
	Example 1:
	
	Input: target = 7, nums = [2,3,1,2,4,3]
	Output: 2
	Explanation: The subarray [4,3] has the minimal length under the problem constraint.
	Example 2:
	
	Input: target = 4, nums = [1,4,4]
	Output: 1
	Example 3:
	
	Input: target = 11, nums = [1,1,1,1,1,1,1,1]
	Output: 0
	
	Constraints:
	
	1 <= target <= 109
	1 <= nums.length <= 105
	1 <= nums[i] <= 104
	
	Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
*/

package com.medium.problems;

public class Minimum_Size_Subarray_Sum {
	public int minSubArrayLen(int target, int[] nums) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        sum[1] = nums[0];
        
        if(nums[0] >= target)
            return 1;
        
        for(int i = 2; i <= nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
            if(nums[i-1] >= target)
                return 1;
        }
        
        if(sum[sum.length - 1] < target)
            return 0;
        
        int i = 0;
        int j = 1;
        int res = Integer.MAX_VALUE;
        
        while(j < nums.length && i < nums.length){
            if(sum[j] - sum[i] >= target){
                res = Math.min(res, j-i);
                i++;
            }
            else
                j++;
            
            while(j == sum.length-1 && i < sum.length){
                if(sum[j] - sum[i] >= target)
                    res = Math.min(res, j-i);
                if(i == j)
                    break;
                i++;
            }
        }
        
        return res;
    }
}
