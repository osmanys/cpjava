import java.util.*;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int i, res;
        Hashtable<Integer, Integer> hash = new Hashtable();
        for(i = 0; i < nums.length; i++){
            res = target - nums[i];
            if(!hash.containsKey(res))
                hash.put(res, i);
        }
        for(i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i]))
                break;
        }
        return new int[]{i, hash.get(nums[i])};
    }

    public static void main(String[] args){
        int r[] = twoSum(new int[]{ 2, 7, 11, 15 }, 9);
        System.out.println(r[0] + " " + r[1]);
    }
}
