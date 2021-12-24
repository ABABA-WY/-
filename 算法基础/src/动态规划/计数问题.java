package 动态规划;
import java.util.Scanner;

public class 计数问题 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int x = input.nextInt();
        int res = count(b, x) - count(a - 1, x);
        System.out.println(res);
    }

    public static int count(int num, int x) {
        int res = 0;
        int d = dgt(num);
        for (int j = d; j >= 1; j--) {
            int p = power10(j - 1);
            // l和r是第j位左边和右边的整数
            int l = num / p / 10;
            int r = num % p;
            //第j位数字
            int now = num / p % 10;
            // 计算第j位左边的整数小于l (视频中xxx = 000 ~ abc - 1)的情况
            if (x != 0) res += l * p;
            // 如果x = 0, 左边高位不能全为0(视频中xxx = 001 ~ abc - 1)
            if (x == 0 && l != 0) res += (l - 1) * p;
            // 计算第j位左边的整数等于l (视频中xxx = abc)的情况
            if (now > x && (x != 0 || l != 0)) res += p;
            if (now == x && (x != 0 || l != 0)) res += r + 1;
        }
        return res;
    }
    //计算十的k次方
    public static int power10(int k) {
        int res = 1;
        while (k-- > 0) {
            res *= 10;
        }
        return res;
    }

    public static int dgt(int n) // 计算整数n有多少位
    {
        int res = 0;
        while (n != 0) {
            ++res;
            n /= 10;
        }
        return res;
    }
}
