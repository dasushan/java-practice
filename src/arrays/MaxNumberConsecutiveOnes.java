package arrays;

import java.util.ArrayList;

public class MaxNumberConsecutiveOnes {

    // find zeros to remove to get max number of consecutive ones
    // can only remove m no. of zeros
    public static void main(String[] args) {
        int[] arr = {1,0,0,1,1,0,1,0,1,1,1};
        int m =2;
        System.out.println(findZeros(arr, m));
    }

    public static ArrayList findZeros(int[] nums, int m){
        ArrayList<Integer> list = new ArrayList<>();
        int wL = 0, wR = 0, bestL = 0, bestWindow = 0;
        int zerosCount = 0;
        while(wR<nums.length){
            if(zerosCount<=m){
                if(nums[wR] == 0) zerosCount++;
                wR++;
            }
            if(zerosCount>m){
                if(nums[wL] == 0) zerosCount--;
                wL++;
            }
            if((wR-wL>bestWindow) && zerosCount<=m){
                bestWindow = wR-wL;
                bestL= wL;
            }
        }
        for(int i=0; i<bestWindow; i++){
            if(nums[bestL+i] == 0){
                list.add(bestL+i);
            }
        }
        return list;
    }
}
