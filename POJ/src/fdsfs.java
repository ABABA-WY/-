import java.util.*;


class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int d = input.nextInt();
        List<double[]> g = new ArrayList<double[]>();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            if (y > d) {
                System.out.println("-1");
                return;
            }
            double dis = (int) Math.sqrt(d * d - y * y);
            g.add(new double[]{x - dis, x + dis});
        }
/*        Collections.sort(g, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });*/
        for (int i = 0; i < n; i++) {
            System.out.println(g.get(i)[0]);
        }
        int res = 1;
        double maxr = g.get(0)[1];
        for (int i = 1; i < n; i++) {
            if (maxr < g.get(i)[0]) {
                maxr = g.get(i)[1];
                res++;
            }
        }
        System.out.print(res);
    }
}