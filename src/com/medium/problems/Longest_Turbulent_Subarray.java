// https://leetcode.com/problems/longest-turbulent-subarray/

/*
	Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
	A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
	More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
	
	For i <= k < j:
	arr[k] > arr[k + 1] when k is odd, and
	arr[k] < arr[k + 1] when k is even.
	Or, for i <= k < j:
	arr[k] > arr[k + 1] when k is even, and
	arr[k] < arr[k + 1] when k is odd.
	 
	Example 1:
	
	Input: arr = [9,4,2,10,7,8,8,1,9]
	Output: 5
	Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
	Example 2:
	
	Input: arr = [4,8,12,16]
	Output: 2
	Example 3:
	
	Input: arr = [100]
	Output: 1
*/

package com.medium.problems;

public class Longest_Turbulent_Subarray {
	public int maxTurbulenceSize(int[] arr) {
        int count = 0;
        int max = 0;
        boolean bool2 = true;
        boolean bool = false;
        
        for(int i = 1; i < arr.length; i++){
            if(count == 0){
               if(arr[i-1] > arr[i])
                    bool2 = false;
                else
                    bool2 = true;
            }
            
            if(!bool2){
                if(count == 0)
                    bool = false;
                if(bool){
                    bool = false;
                    if(arr[i-1] < arr[i]){
                        count++;
                        max = Math.max(count, max);
                    }
                    else
                        if(count != 0){
                            i--;
                            count = 0;
                        }
                }
                else{
                    bool = true;
                    if(arr[i-1] > arr[i]){
                        count++;
                        max = Math.max(count, max);
                    }
                    else
                        if(count != 0){
                            i--;
                            count = 0;
                        }
                }
            }
            else{
                if(count == 0)
                    bool = false;
                if(bool){
                    bool = false;
                    if(arr[i-1] > arr[i]){
                        count++;
                        max = Math.max(count, max);
                    }
                    else
                        if(count != 0){
                            i--;
                            count = 0;
                        }
                }
                else{
                    bool = true;
                    if(arr[i-1] < arr[i]){
                        count++;
                        max = Math.max(count, max);
                    }
                    else
                        if(count != 0){
                            i--;
                            count = 0;
                        }
                }
            }
            
        }
        return max + 1;
    }
}
