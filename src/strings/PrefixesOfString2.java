package strings;

import java.util.HashSet;

public class PrefixesOfString2 {
    public static void main(String[] args) {
        String s = "abc";
        String[] words = {"a","b","c","ab","bc","abc"};
        System.out.println(countPrefixes(words, s));

    }
    // In Java, startsWith() method is used to check whether the string starts with a specific prefix
    // public boolean startsWith(String prefix)
    // returns true if the character sequence represented by the argument is a prefix of the character sequence represented by this string
    public static int countPrefixes(String[] words, String s){

        int cnt =0;
        for(String i: words){
            if(s.startsWith(i)) cnt++;
        }

//        String s1 = "aa";
//        int l=0;
//        int r= s1.length()-1;
//        s1 = s1.substring(l+1, r);
//        System.out.println(s1.length());
//        System.out.println(s1);
        return cnt;
    }
}
