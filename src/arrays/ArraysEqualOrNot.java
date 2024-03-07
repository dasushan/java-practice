package arrays;

import java.util.HashMap;

public class ArraysEqualOrNot {
    public static void main(String[] args) {
        long[] A={1,2,5,4,0};
        long[] B={2,4,5,0,1};
        System.out.println(check(A, B));
    }
    public static boolean check(long[] A,long[] B)
    {
        //Your code here
        // Approach 1
        // Arrays.sort(A);
        // Arrays.sort(B);
        // for(int i=0; i<A.length; i++){
        //     if(A[i] != B[i]){
        //         return false;
        //     }
        // }
        // return true;

        // Approach 2
        if(A.length != B.length){
            return false;
        }
        HashMap<Long, Integer> mp1 = new HashMap<>();
        HashMap<Long, Integer> mp2 = new HashMap<>();
        for(int i=0;i<A.length; i++){
            if(!mp1.containsKey(A[i])){
                mp1.put(A[i], 1);
            }
            else{
                mp1.put(A[i], mp1.get(A[i])+1);
            }
        }
        for(int i=0; i<B.length; i++){
            if(!mp2.containsKey(B[i])){
                mp2.put(B[i], 1);
            }else{
                mp2.put(B[i], mp2.get(B[i])+1);
            }
        }
        for(int i=0; i<A.length; i++){
            if(mp2.containsKey(A[i]) && mp1.get(A[i])==mp2.get(A[i])){
                continue;
            }else{
                return false;
            }
        }
        return true;

    }
}
