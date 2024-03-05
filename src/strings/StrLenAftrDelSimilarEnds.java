package strings;

public class StrLenAftrDelSimilarEnds {


    public static void main(String[] args) {
        String s = "ca";
        System.out.println(minimumLength(s));
    }

    public static int minimumLength(String s){
        StringBuilder str = new StringBuilder(s);

        int l=0;
        int r = str.length()-1;
        while(l<r){
            if(str.charAt(l) == str.charAt(r)){
                while((l+1<r) && str.charAt(l)==str.charAt(l+1)){
                    l++;
                }
                while((r-1>l) && str.charAt(r-1)==str.charAt(r)){
                    r--;
                }
                str = new StringBuilder(str.substring(l+1, r));
//                System.out.println(str);

                l = 0;
                r = str.length()-1;
//                System.out.println(l);
//                System.out.println(r);
            }
            else{
                break;
            }
        }
//        System.out.println(str);
        return str.length();
    }
}
