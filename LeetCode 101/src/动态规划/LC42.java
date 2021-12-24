package 动态规划;

public class LC42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax=new int [n+1];
        int[] rightMax=new int[n+1];
        leftMax[0]=height[0];
        for(int i = 0; i < n; i++){
            leftMax[i+1]=Math.max(leftMax[i],height[i] );
        }
        rightMax[n]=height[n-1];
        for (int i=n-1;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1], height[i]);
        }
        int res=0;
        for(int i=0;i < n; i++){
            res+=Math.min(rightMax[i],leftMax[i])-height[i];
        }
        return res;
    }
}
