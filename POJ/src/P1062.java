import java.util.Arrays;
import java.util.Scanner;
class Msg{
    int P,L,X;
    int[] T,V;
    Msg(int P,int L,int X){
        this.P = P;
        this.L = L;
        this.X = X;
        this.T = new int[X];
        this.V = new int[X];
    }
}
public class P1062 {
    public static final int maxNum = 0x3f3f3f3f;
    public static int M,N;
    public static int[][] map;
    public static int[] dist;
    public static boolean[] st;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        M = input.nextInt();
        N = input.nextInt();
        Msg[] msg = new Msg[N+1];
        map = new int[N+1][N+1];
        dist = new int[N+1];
        st = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            int P = input.nextInt();
            int L = input.nextInt();
            int X = input.nextInt();
            map[0][i] = P;
            msg[i] = new Msg(P,L,X);
            for(int j = 0; j < X; j++){
                int T = input.nextInt();
                int V = input.nextInt();
                msg[i].T[j] = T;
                msg[i].V[j] = V;
                map[T][i] = V;
            }
        }
        for (int i = 1; i <= N; i++) {
            int X = msg[i].X;
            for(int j = 0; j < X; j++){
                //不符合条件，则设置为已经遍历过
                if(msg[i].T[j] < i || i - msg[i].T[j] > M){
                    st[msg[i].T[j]] = true;
                }
                else {
                    st[msg[i].T[j]] = false;
                }
            }
        }
        int res = dijkstra();
        if(res > msg[1].P){
            res = msg[1].P;
        }
        System.out.println(res);
    }
    public static int dijkstra(){
        Arrays.fill(dist, maxNum);
        for(int i=1;i<=N;i++) {
            dist[i] = map[0][i];
        }
        for (int i = 1; i <= N; i++) {
            int t = -1;
            //i到t找到距离最小的点
            for (int j = 1; j <= N; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            st[t] = true;
            for (int j = 1; j <= N; j++) {
                if(!st[j] && map[t][j] > 0) {
                    dist[j] = Math.min(dist[j], dist[t] + map[t][j]);
                    //  System.out.println(dist[j]);
                }
            }
        }
        return dist[1];
    }

}
