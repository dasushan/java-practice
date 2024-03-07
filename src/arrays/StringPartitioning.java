package arrays;

import java.util.ArrayList;
import java.util.HashMap;

// partition a given string so that each letter appears in atmost one part
public class StringPartitioning {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        int[] ans = printPartitions(s);
        for(int x: ans){
            System.out.print(x + " ");
        }
    }
    public static int[] printPartitions(String s){
        HashMap<Character, Integer> hmap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for(int i=0; i<n; i++){
            hmap.put(chars[i], i);
        }
        int start = 0;
        int end = 0;
        while(end<n){

            if(hmap.get(chars[end])>end){
                end = hmap.get(chars[end]);
                while(start<=end){
                    if(hmap.get(chars[start])>end){
                        end=hmap.get(chars[start]);

                    }else{
                        start++;
                    }
                }
            }
            if(hmap.get(chars[end]) == end){
                list.add(end+1);
                end++;
            }
        }
        int[] res = new int[list.size()];
        int j=0;
        res[j] = list.get(j);
        for( j=1; j<list.size(); j++){
            res[j] = list.get(j) - list.get(j-1);
        }
        return res;
    }
}
