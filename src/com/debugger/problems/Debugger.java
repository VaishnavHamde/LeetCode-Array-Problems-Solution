package com.debugger.problems;
import java.util.*;

public class Debugger {
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
	}
	
	static public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int i = 0; i < weights.length; i++) {
        	sum += weights[i];
        }
        
        while(low <= high){
            int mid = (low + high)/2;
            int temp = 0;
            if(sum >= mid)
            	temp = cal(weights, mid, days);
            else
            	temp = 1;
            if(temp <= days){
                res = Math.min(res, mid);
                high = mid - 1;
            }
            else if(temp > days){
                low = mid + 1;
            }
        }
        
        return res;
    }
    
    static public int cal(int[] weights, int mid, int days){
        int count = 0;
        
        for(int i = 0; i < weights.length; i++){
            int temp = mid;
            while(i < weights.length && temp > 0){
                temp -= weights[i];
                i++;
            }
            if(temp < 0)
                i--;
            count++;
            if(count > days) {
            	return count;
            }
            i--;
        }
        
        return count;
    }
}
