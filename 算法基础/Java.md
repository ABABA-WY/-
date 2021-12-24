```Java
import java.io.*;

public class Main {
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in),32768));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static double nextDouble() throws IOException{ in.nextToken(); return in.nval; }
    public static float nextFloat() throws IOException{ in.nextToken(); return (float)in.nval; }
    public static int nextInt() throws IOException{ in.nextToken(); return (int)in.nval; }
    public static String next() throws IOException{ in.nextToken(); return in.sval; }
    public static int lower_bound(int[] arrays , int begin , int end , int target){
        while(begin < end){ int mid = begin + (end - begin) / 2;if(arrays[mid] < target) begin = mid + 1;else end = mid; }return begin; }
    public static int upper_bound(int[] arrays , int begin , int end , int target){
        while(begin < end){ int mid = begin + (end - begin) / 2;if(arrays[mid] <= target) begin = mid + 1;else end = mid; }return begin; }
    public static void main(String[] args) throws IOException{
        Main sol = new Main();

        out.println();
        out.close();
        out.flush();
    }

}
```

 

