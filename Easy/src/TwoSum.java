import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/*
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * You can return the answer in any order.
 */

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans1 = twoSum1(nums, target);
        int[] ans2 = twoSum2(nums, target);
        int[] ans3 = twoSum3(nums, target);
        System.out.println("BruteForce Ans: "+ Arrays.toString(ans1));
        System.out.println("HashMap repeat element Ans: "+ Arrays.toString(ans2));
        System.out.println("HashMap Ans: "+ Arrays.toString(ans3));
    }

    // Method 1 - O(n^2) - two for loops - bruteforce
    public static int[] twoSum1(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j< nums.length; j++){
                if(nums[i]+nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }

    // Hashmap method O(n), but uses the same element twice - We don't want to do that
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i: nums) {
            if(map.containsKey(target-i)){
                return new int[] {map.get(i), map.get(target-i)};
            }
        }
        return new int[] {-1, -1};
    }

    // This should be good. Hashmap method O(n)
    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
