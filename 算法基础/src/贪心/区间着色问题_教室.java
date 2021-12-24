package 贪心;

import java.util.Arrays;
import java.util.Comparator;

public class 区间着色问题_教室 {
    public static int N=10010;
    public static int[] classRome=new int[N];//教室，最多N间教室
    public static int[][] activities={{1,4},{3,5},{2,6},{8,9},{4,5},{1,2}};//活动的开始时间和结束时间
    public static void main(String[] args) {
        //按照开始时间进行排序，开始时间相同则按照结束时间排序
        Arrays.sort(activities, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }
                else{
                    return a[0]-b[0];
                }
            }
        });
        int count =0;//已使用教室的数量
        //将第一个活动放到第一个教室
        classRome[count++]=activities[0][1];
        for (int i = 1; i < activities.length; i++) {
            boolean flag=false;//标记
            for(int j=0;j<count;j++){
                //如果该教室上一个活动结束时间小于当前活动时间
                //则将当前活动加到这个教室,并将此活动进行标记
                // 继续寻找下一个教室
                if(classRome[j]<=activities[i][0]){
                    classRome[j]=activities[i][1];
                    flag = true;
                    break;
                }
            }
            //未找到合适的教室，则重新开一间教室
            if(!flag)
                classRome[count++] = activities[i][1];
        }
        //将教室数量输出
        System.out.println(count);
    }
}
