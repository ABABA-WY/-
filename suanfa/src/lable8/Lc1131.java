package lable8;

public class Lc1131 {
    public static void main(String[] args) {
        int[] arr1 = {1, -2, -5, 0, 10};
        int[] arr2 = {0, -2, -1, -7, -4};
        int result = maxAbsValExpr(arr1, arr2);
        System.out.println(result);
    }

    public static int maxAbsValExpr(int[] arr1, int[] arr2) {
        int amin = Integer.MAX_VALUE, bmin = Integer.MAX_VALUE, cmin = Integer.MAX_VALUE, dmin = Integer.MAX_VALUE;
        int amax = Integer.MIN_VALUE, bmax = Integer.MIN_VALUE, cmax = Integer.MIN_VALUE, dmax = Integer.MIN_VALUE;
        int ret = 0;
        for (int i = 0; i < arr1.length; i++) {
            amin = Math.min(amin, arr1[i] + arr2[i] + i);
            amax = Math.max(amax, arr1[i] + arr2[i] + i);
            bmin = Math.min(bmin, arr1[i] + arr2[i] - i);
            bmax = Math.max(bmax, arr2[i] + arr2[i] - i);
            cmin = Math.min(cmin, arr1[i] - arr2[i] + i);
            cmax = Math.max(cmax, arr1[i] - arr2[i] + i);
            dmin = Math.min(dmin, arr1[i] - arr2[i] - i);
            dmax = Math.max(dmax, arr1[i] - arr2[i] - i);
        }
        ret=Math.max(Math.max(amax-amin,bmax-bmin),Math.max(cmax-cmin,dmax-dmin));
        return ret;
    }
}
