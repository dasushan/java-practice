package arrays;

import java.util.HashMap;

// given a binary array return the maximum length of a contiguous subarray with an equal number of 0s n 1s
public class ContiguousArray {
    public static void main(String[] args) {
        int[] binary = {1,0,0,1,0,1,1};
        System.out.println(maxLength(binary));
    }
    public static int maxLength(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        // converting 0's to -1
        for(int i=0;i<nums.length; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int maxLen = 0;
        hmap.put(0, -1);   // pseudo index helpful for ease in length calculation
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];  // cummmulative sum
            if(hmap.containsKey(sum)){
                int last = hmap.get(sum);

                maxLen = Math.max(maxLen, i-last);
            }else{
                hmap.put(sum, i);
            }
        }
        return maxLen;
    }
}
