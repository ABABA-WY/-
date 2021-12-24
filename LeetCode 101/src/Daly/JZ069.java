package Daly;

public class JZ069 {
    public static void main(String[] args) {
       int[] arr = {3,4,5,1};
        System.out.println(new JZ069().peakIndexInMountainArray(arr));
    }
    public int peakIndexInMountainArray(int[] arr) {
        int l=0,r=arr.length-1;
        while(l<r){
            int mid=(l+r+1)>>1;
            if(arr[mid]>arr[mid-1]&&arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(arr[mid]>arr[mid-1]&&arr[mid] < arr[mid + 1]){
                l=mid;
            }
            else
                r=mid;
        }
        return 0;
    }
}
