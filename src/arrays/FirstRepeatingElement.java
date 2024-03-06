package arrays;

import java.util.ArrayList;
import java.util.HashMap;

// find the element that occurs more than once and whose index of first occurrence is smallest
public class FirstRepeatingElement {
    public static void main(String[] args) {
        int[] A ={10,5,3,4,3,5,6};
        System.out.println(repeatElement(A));
    }

    public static int repeatElement(int[] A){
        HashMap<Integer, Integer> hmap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++){
            if(!hmap.containsKey(A[i])){
                hmap.put(A[i], i);
            }else{
                min = Math.min(min, hmap.get(A[i]));
            }
        }
        return min==Integer.MAX_VALUE?-1:A[min];
    }
}
