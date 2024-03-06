package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistinctElementsInKWindowSize {


    public static void main(String[] args) {
        int[] A= {1,2,1,3,4,2,3};
        int k = 4;
        System.out.println(countDistinct(A, k));
    }
    public static List countDistinct(int[] A, int k){
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int cnt =0;

        for(int i=0; i<k; i++){
            if(!hmap.containsKey(A[i])){
                hmap.put(A[i], 1);
                cnt++;
            }else{
                hmap.put(A[i], hmap.get(A[i])+1);
            }
        }
        list.add(cnt);
        for(int i=0; i<A.length-k; i++){
            hmap.put(A[i], hmap.get(A[i])-1);
            if(hmap.get(A[i])==0){
                cnt--;
                hmap.remove(A[i]);
            }
            if(!hmap.containsKey(A[i+k])){
                hmap.put(A[i+k], 1);
                cnt++;
            }else{
                hmap.put(A[i+k], hmap.get(A[i+k])+1);
            }
            list.add(cnt);
        }
        return list;
    }
}
