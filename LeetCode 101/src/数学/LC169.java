package 数学;

public class LC169 {
    public static void main(String[] args) {
        int[] nums={2,1,1};
        System.out.println(new LC169().majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        int res=0;
        int cnt=0;
        for (int i :nums) {
            if(cnt==0){
                res=i;
                cnt++;
            }
            else {
                if(res==i)
                    cnt++;
                else cnt--;
            }
        }
        return res;
    }
}
