package arrays;

import java.util.HashMap;

public class SubarraysWithEqualNoof1sn0s {
    public static void main(String[] args) {
        int[] binary = {1,0,0,1,0,1,1};
        int n = binary.length;
        System.out.println(countSubArrWithEqualZeroAndOne(binary, n));
    }
    public static int countSubArrWithEqualZeroAndOne(int[] arr, int n){
        if(arr[0] == 0){
            arr[0] = -1;
        }
        for(int i=1; i<arr.length; i++){
            if(arr[i] == 0){
                arr[i] = -1;
            }
            arr[i] = arr[i] + arr[i-1];
        }
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                cnt++;
            }
            if(hmap.containsKey(arr[i])) {
                cnt += hmap.get(arr[i]);
                hmap.put(arr[i], hmap.get(arr[i]) + 1);
            }else{
                hmap.put(arr[i] , 1);
            }

        }
        return cnt;
    }
}
