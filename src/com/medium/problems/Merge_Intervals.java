// https://leetcode.com/problems/merge-intervals/description/

/*
	Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
	and return an array of the non-overlapping intervals that cover all the intervals in the input.
	
	
	Example 1:
	
	Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
	Output: [[1,6],[8,10],[15,18]]
	Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
	Example 2:
	
	Input: intervals = [[1,4],[4,5]]
	Output: [[1,5]]
	Explanation: Intervals [1,4] and [4,5] are considered overlapping.
	 
	
	Constraints:
	
	1 <= intervals.length <= 104
	intervals[i].length == 2
	0 <= starti <= endi <= 104
*/

package com.medium.problems;
import java.util.*;

public class Merge_Intervals {
	public int[][] merge(int[][] intervals) {
        int max = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(max < intervals[i][1]){
                max = intervals[i][1];
            }
        }

        int[] arr = new int[max+1];

        for(int i = 0; i < intervals.length; i++){
            for(int j = intervals[i][0]; j <= intervals[i][1]; j++){
                if(j == intervals[i][1]){
                    if(arr[j] == 1)
                        continue;
                    arr[j] = -1;
                }
                else{
                    arr[j] = 1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int j = -1;
        int k = -1;
        boolean bool = true;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1 && bool){
                bool = false;
                j = i;
            }
            else if(arr[i] == -1 && !bool){
                bool = true;
                k = i;
                list.add(j);
                list.add(k);
            }
            else if(arr[i] == -1 && bool){
                list.add(i);
                list.add(i);
            }
        }

        k = 0;
        int[][] res = new int[list.size()/2][2];

        for(int i = 0; i < list.size()/2; i++){
            res[i][0] = list.get(k);
            k++;
            res[i][1] = list.get(k);
            k++;
        }

        return res; 
    }
}
