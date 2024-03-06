package arrays;
// find the minimum length unsorted subarray, sorting which makes the complete array sorted
public class FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] arr = {10,12,20,30,25,40,32,31,35,50,60};
        int[] res = subUnsort(arr);
        for(int x:res){
            System.out.print(x+" ");
        }
    }
    public static int[] subUnsort(int[] arr){
        int start = -1;
        int end = -1;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                start = i;
                break;
            }
        }
        for(int i=arr.length-1; i>0; i--){
            if(arr[i]<arr[i-1]){
                end = i;
                break;
            }
        }
        if(start==-1 && end==-1){
            return new int[]{};
        }
        int max= Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        for(int i=start; i<=end; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        for(int i=0; i<start; i++){
            if(arr[i]>min){
                start=i;
                break;
            }
        }
        for(int i=arr.length-1; i>end; i--){
            if(arr[i]<max){
                end =i;
                break;
            }
        }
        return new int[]{start, end};
    }
}

