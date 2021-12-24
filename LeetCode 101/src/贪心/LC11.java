package 贪心;

public class LC11 {
    public static void main(String[] args) {
        int[] h={1,8,6,2,5,4,8,3,7};
        System.out.println(new LC11().maxArea(h));
    }
    public int maxArea(int[] height) {
        int n = height.length;
        int l=0,r=n-1;
        int res=0;
        while(l<r){
            res=height[l]<height[r]?Math.max(res,(r-l)*height[l++]):Math.max(res,(r-l)*height[r--]);
        }
        return res;
    }
}
