package lable11;

public class LC1855 {
    public static void main(String[] args) {
        int[] nums1 = {55, 30, 5, 4, 2};
        int[] nums2 = {100, 20, 10, 10, 5};
        System.out.println(new LC1855().maxDistance(nums1, nums2));
    }

    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                if (i == j) {
                    j++;
                    i++;
                }
                else i++;
            }
            else {
                ans=Math.max(ans, j-i);
                j++;
            }
        }
        return ans;
    }
}
