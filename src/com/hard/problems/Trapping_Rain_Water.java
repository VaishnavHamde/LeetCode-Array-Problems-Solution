// https://leetcode.com/problems/trapping-rain-water/

/*
	Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

	Example 1:
	
	Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
	Output: 6
	Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
	In this case, 6 units of rain water (blue section) are being trapped.
	Example 2:
	
	Input: height = [4,2,0,3,2,5]
	Output: 9
*/

package com.hard.problems;

public class Trapping_Rain_Water {
	public int trap(int[] height) {
        int res = 0;
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];
        
        lMax[0] = height[0];
        rMax[height.length - 1] = height[height.length-1];
        
        for(int i = height.length - 2; i > -1; i--){
            rMax[i] = Math.max(height[i], rMax[i+1]);
        }
        
        for(int i = 1; i < height.length; i++){
            lMax[i] = Math.max(height[i], lMax[i-1]);
            res +=  (Math.min(lMax[i], rMax[i]) - height[i]);
        }
        
        return res;
    }
}
