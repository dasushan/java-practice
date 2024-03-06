package strings;

import java.util.Arrays;

public class LongestSubstringAtLeastKRepeatingChars {
    public static void main(String[] args) {
        String s = "aaabbcddaeaaff";
        int k = 2;
        System.out.println(longestSubstring(s, k));
    }

    public static int longestSubstring(String s, int k) {
        int maxUniqueCharCount = getUniqueCount(s);
        int[] freqMap = new int[26];
        int result = 0;
        for(int currUniqueChar=1; currUniqueChar<=maxUniqueCharCount; currUniqueChar++){
            Arrays.fill(freqMap, 0);
            int uniqueCount=0, countAtLeastK=0, windowStart=0, windowEnd=0;
            while(windowEnd<s.length()){
                if(uniqueCount<=currUniqueChar){
                    // expand window
                    int ind = s.charAt(windowEnd) - 'a';
                    if(freqMap[ind] == 0){
                        uniqueCount++;
                    }
                    freqMap[ind]++;
                    if(freqMap[ind] == k){
                        countAtLeastK++;
                    }
                    windowEnd++;
                }else{
                    // shrink window
                    int ind = s.charAt(windowStart)-'a';
                    if(freqMap[ind] == k){
                        countAtLeastK--;
                    }
                    freqMap[ind]--;
                    if(freqMap[ind] == 0){
                        uniqueCount--;
                    }
                    windowStart++;
                }
                if(uniqueCount== currUniqueChar && uniqueCount==countAtLeastK){
                    result = Math.max(result, windowEnd- windowStart);
                }
            }
        }
        return result;
    }
    public static int getUniqueCount(String s){
        boolean[] chars = new boolean[26];
        int uniqueCount =0;
        for(char ch: s.toCharArray()){
            int ind = ch- 'a';
            if(chars[ind] == false){
                uniqueCount++;
                chars[ind] = true;
            }
        }
        return uniqueCount;
    }
}