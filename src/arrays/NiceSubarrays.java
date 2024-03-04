package arrays;

public class NiceSubarrays {
    //https://leetcode.com/problems/count-number-of-nice-subarrays/description/
    public static void main(String[] args) {
        int[] A = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(A, k));
    }
    public static int numberOfSubarrays(int[] nums, int k){
        int i=0, j=0, cnt=0, ans=0;
        int n = nums.length;

        while(j<n){
            if(nums[j]%2 != 0){
                cnt++;
            }
            while(cnt>k){
                if(nums[i]%2 != 0){
                    cnt--;
                }
                i++;
            }

            if(cnt==k){
                int val = i;
                while(cnt==k){
                    ans++;
                    if(nums[val]%2 != 0){
                        cnt--;
                    }
                    val++;
                }
                val--;
                while(val>=i){
                    if(nums[val]%2 != 0){
                        cnt++;
                    }
                    val--;
                }

            }
            j++;
        }
        return ans;
    }
}
