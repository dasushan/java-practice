package strings;

public class LongestSubstringAtLeastKRepeatingChars2 {
    public static void main(String[] args) {
        String s = "aaabbcddaeaaff";
        int k = 2;
        System.out.println(longestSubstring(s, k));
    }
    public static int longestSubstring(String s, int k){
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        boolean valid = true;
        int start = 0;
        int maxiLen = 0;
        for(int end=0; end<s.length(); end++){
            if(freq[s.charAt(end)-'a']>0 && freq[s.charAt(end)-'a']<k){
                String subString = s.substring(start, end);
                start = end+1;
                maxiLen= Math.max(maxiLen, longestSubstring(subString, k));
                valid = false;
            }
        }
        if(valid){
            return s.length();
        }else{
            return Math.max(maxiLen, longestSubstring(s.substring(start), k));
        }
    }
}
