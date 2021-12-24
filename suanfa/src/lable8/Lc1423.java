package lable8;

public class Lc1423 {
    public static void main(String[] args) {
        int []cardPoints={11,49,100,20,86,29,72};
        int k=4;
        int ret=maxScore(cardPoints,k);
        System.out.println(ret);
    }
    public static int maxScore(int[] cardPoints, int k) {
        int count = 0;
        int ret = 0;
        for(int i=cardPoints.length-k;i<cardPoints.length;i++){
            count += cardPoints[i];
        }
        ret=count;
        for (int i = 0; i < k; i++) {
            count += cardPoints[i];
            count-=cardPoints[cardPoints.length-k+i];
            ret=Math.max(count,ret);
        }
        return ret;
    }

}
