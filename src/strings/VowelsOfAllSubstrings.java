package strings;

import java.util.HashSet;

public class VowelsOfAllSubstrings {
    public static void main(String[] args) {
        String word = "aba";
        System.out.println(countVowels(word));
    }
    public static long countVowels(String word) {
        long res =0, sz=word.length();
        for(int i=0; i<sz; i++){
            if("aeiou".indexOf(word.charAt(i)) != -1){
                res += (i+1)*(sz-i);
            }
        }
        return res;
    }
}
