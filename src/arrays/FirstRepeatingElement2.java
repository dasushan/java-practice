package arrays;


import java.util.HashMap;

public class FirstRepeatingElement2 {
    public static void main(String[] args) {
        int[] A ={10,5,3,4,3,5,6};
        System.out.println(repeatElement(A));
    }
    public static int repeatElement(int[] A){
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int min = -1;
        int n = A.length;
        for(int i=n-1; i>=0; i--){
            if(!hmap.containsKey(A[i])){
                hmap.put(A[i],i);
            }else{
                min = i;
            }
        }
        return min==-1?-1:A[min];
    }
}
