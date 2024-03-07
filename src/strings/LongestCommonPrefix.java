package strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
       String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs){

        for(int i=0; i<strs.length; i++){
            System.out.print(strs[i] + " ");
        }

        StringBuilder temp = new StringBuilder(strs[0]);
        for(int i=1; i<strs.length; i++){


            String a = strs[i];
            StringBuilder temp2 = new StringBuilder();
            int j=0;
            while(j<temp.length() && j<a.length() && (temp.charAt(j) == a.charAt(j)) ){
                temp2.append(temp.charAt(j));
                j++;
            }
            temp = temp2;
            if(temp.length()==0){
                return "";
            }
        }
        return temp.toString();
    }
}
