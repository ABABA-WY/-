package Competition;

class Robot {
    int g[][];
    String[] dir={"East","North","West","South"};
    int[][] di={{1,0},{0,1},{-1,0},{0,-1}};
    int d=0;
    int x=0,y=0;
    int w,h;
    public Robot(int width, int height) {
        g=new int[width][height];
        d=0;
        w=width;
        h = height;
    }

    public void move(int num) {
        int s = 2 * w + 2 * h - 4;
        if (num >= s ) {
            num %= s;
            //注意再次回到元点时，方向是向南
            if(x == 0 && y == 0){
                d = 3;
            }
        }

        while(num!=0) {
            if(d==0&&x<w-1) {
                x++;
                num--;
            }
            else if (d==1&&y<h-1) {
                y++;
                num--;
            }
            else if(d==2&&x>0) {
                x--;
                num--;
            }
            else if(d==3&&y>0) {
                y--;
                num--;
            }
            else{
                d=(d+1)%4;
            }

        }

    }

    public int[] getPos() {
        return new int[]{x,y};
    }

    public String getDir() {
        return dir[d];
    }
}
