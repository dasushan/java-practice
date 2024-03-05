package strings;
// https://leetcode.com/problems/count-prefixes-of-a-given-string/description/
import java.util.HashSet;

public class PrefixesofString {
    public static void main(String[] args) {
        String s = "abc";
        String[] words = {"a","b","c","ab","bc","abc"};
        System.out.println(countPrefixes(words, s));

    }

    public static int countPrefixes(String[] words, String s){
        HashSet<String> hset = new HashSet<>();
        for(int i=s.length(); i>=1; i--){
            hset.add(s.substring(0, i));
        }
        int cnt =0;
        for(int i=0; i<words.length; i++){
            if(hset.contains(words[i])){
                cnt++;
            }
        }
        return cnt;
    }
}
