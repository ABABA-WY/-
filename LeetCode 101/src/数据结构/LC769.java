package 数据结构;

public class LC769 {
    public static void main(String[] args) {
        int[] arr={1,0,2,3,4};
        System.out.println(new LC769().maxChunksToSorted(arr));
    }
    public int maxChunksToSorted(int[] arr) {
        int count=0;
        int curmax=0;
        for(int i=0;i<arr.length; i++){
            curmax=Math.max(curmax,arr[i]);
            if(curmax==i){
                count++;
            }
        }
        return count;
    }

}
