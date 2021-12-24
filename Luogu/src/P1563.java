import java.util.Scanner;
/*抓小偷模拟*/
public class P1563 {
    public static String[] ss;
    public static int[] face;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ss = new String[n + 1];
        face = new int[n + 1];
        for (int i = 0; i < n; i++) {
            face[i] = input.nextInt();
            ss[i] = input.next();
        }
        int now = 0;
        for (int i = 0; i < m; i++) {
            int way = input.nextInt();
            int distance = input.nextInt();
            if ((way ^ face[now]) == 0) {
                now = (now + n - distance) % (n);
            } else {
                now = (now + distance) % (n);
            }

        }
        if (n == 1) {
            System.out.println(ss[1]);
            return;
        }
        System.out.println(ss[now]);
    }
}
/*
用ss来存放各个字符串，face存放每个人的朝向
存放数据从0~n-1存，而不是1~n。
way为每个人的左边或者右边，distance为距离
一共可以分为四种情况，通过列出四种情况可以
看出用异或解题更加方便，然后进行对应的加减运算
加减运算注意要取模，这样可以形成环路，用now记录
当前位置，每次运算都进行更新，最后输出最后一次
运算后对应的字符串。
 * */