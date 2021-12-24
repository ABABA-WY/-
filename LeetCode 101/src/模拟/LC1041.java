package 模拟;

public class LC1041 {
    /*
    当走完一个轮回，机器人在原点，或者机器人的方向改变
    则走不出去
    * */
    public boolean isRobotBounded(String instructions) {
        //表示上，右，下,左四个方向
        int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        //表示所在的坐标
        int x=0,y=0;
        int i = 0;
        for(char c:instructions.toCharArray()){
            if(c=='G'){
                x+=dir[(i+4)%4][0];
                y+=dir[(i+4)%4][1];
            }
            //顺时针旋转
            else if(c=='R'){
                i=(i+1)%4;
            }
            //逆时针
            else if(c=='L'){
                i=(i-1+4)%4;
            }
        }
        return (x==0&&y==0)||i%4==0;
    }
}
