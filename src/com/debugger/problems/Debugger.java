package com.debugger.problems;
import java.util.*;

public class Debugger {
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(fourSum(new int[]{-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492}, 1682));
		
	}
	
	static public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4){
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            return lists;
        }
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                long temp = nums[i]+nums[j];

                int k = j+1;
                int l = nums.length-1;

                while(k < l){
                    if(nums[k]+nums[l]+temp > target){
                        l--;
                    }
                    else if(nums[k]+nums[l]+temp < target){
                        k++;
                    }
                    else{
                        lists.add(List.of(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                    }
                }
            }
        }

        if(lists.isEmpty()){
            List<List<Integer>> listss = new ArrayList<List<Integer>>();
            return listss;
        }

        List<List<Integer>> lists2 = new ArrayList<List<Integer>>();
        List<Integer> li = new ArrayList<Integer>();

        for(int i = 0; i < 4; i++){
            li.add(lists.get(0).get(i));
        }

        lists2.add(li);

        for(int i = 0; i < lists.size(); i++){
            boolean bool2 = true;
            for(int k = 0; k < lists2.size(); k++){
                boolean bool = true;
                for(int j = 0; j < 4; j++){
                    if(lists.get(i).get(j) != lists2.get(k).get(j)){
                        bool = false;
                        break;
                    }
                }
                if(bool){
                    bool2 = false;
                    break;
                }
            }
            
            if(bool2){
                lists2.add(lists.get(i));
            }
        }

        return lists2;
    }
}
