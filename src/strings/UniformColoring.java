package strings;
// sharpner test question
public class UniformColoring {
    public static void main(String[] args) {
        String s ="WWBBBBWW";
        System.out.println(minimumFlips(s));

    }
    public static int minimumFlips(String s){
        int[] arr = new int[s.length()];
        for(int i=0; i<arr.length; i++){
            if (s.charAt(i) == 'W'){
                arr[i] = 1;
            }else{
                arr[i] = 0;
            }
        }
        int len0 =0;
        int len1 =0;
        int max = 0;
        int cnt = 0;
        for(int i=0;i<arr.length; i++){
            //max no of consecutive 1's
            if(arr[i] == 1){
                cnt++;
            }else{
                cnt =0;
            }
            max = Math.max(max,cnt);
        }
        len1 = max;
        max=0;
        for(int i=0;i<arr.length; i++){
            //max no of consecutive 0's
            if(arr[i] == 0){
                cnt++;
            }else{
                cnt =0;
            }
            max = Math.max(max,cnt);
        }
        len0 = max;
        max=0;
        System.out.println(len0);
        System.out.println(len1);
        int replacement = 0;
        if(len0>len1){
            replacement = 1;
        }
        if(len1>len0){
            replacement = 0;
        }
        int flips = 0;
        int l =0;
        int r =0;
        while(r<arr.length){
            if(arr[r] != replacement){
                l = r;
                while(arr[l] != replacement){
                    l++;
                    if(l==arr.length){
                        break;
                    }
                }
                r = l-1;
                flips++;
            }
            r++;
        }

        return flips;

    }
}
