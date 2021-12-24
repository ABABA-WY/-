import java.util.*;


public class P1328 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        while (true) {
            int n = input.nextInt();
            double d = input.nextDouble();
            if (n == 0 && d == 0) break;
            count++;
            List<double[]> g = new ArrayList<double[]>();
            for (int i = 0; i < n; i++) {
                double x = input.nextDouble();
                double y = input.nextDouble();
                g.add(new double[]{x, y});
            }
            Collections.sort(g, new Comparator<double[]>() {
                @Override
                public int compare(double[] o1, double[] o2) {
                    return (int) (o1[0] - o2[0]);
                }
            });
            int res = 0;
            double mid = Integer.MIN_VALUE / 2;
            for (int i = 0; i < n; i++) {
                double x = g.get(i)[0];
                double y = g.get(i)[1];
                if (y > d) {
                    res = -1;
                    break;
                }
                if (i == 0 || !inarea(x, y, mid, d)) {
                    res++;
                    mid = Math.sqrt((d * d) - (y * y)) + x;
                }
            }
            System.out.println("Case " + count + ": " + res);
        }

    }

    //xy为该点坐标，mid为地雷坐标，判断该点是否在地雷覆盖范围内
    public static boolean inarea(double x, double y, double mid, double d) {
        double a = d * d;
        double b = ((x - mid) * (x - mid));
        double c = y * y;
        return a >= b + c;
    }
}
