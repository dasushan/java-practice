package strings;

public class StrLenAftrDelSimilarEnds2 {
    public static void main(String[] args) {

       // String s = "aabccabba";
        String s ="ca";
        System.out.println(minimumLength(s));
    }

    public static int minimumLength(String s){

        int len = 0;
        int min = Integer.MAX_VALUE;
        int l=0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l) == s.charAt(r)){
                while((l+1<r) && s.charAt(l)==s.charAt(l+1)){
                    l++;
                }
                while((r-1>l) && s.charAt(r-1)==s.charAt(r)){
                    r--;
                }

                len = r-l-1;
                min = Math.min(len, min);
                l++;
                r--;

            }
            else{
                break;
            }
        }

        return min==Integer.MAX_VALUE?r-l+1:min;
    }
}
