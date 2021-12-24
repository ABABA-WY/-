import java.util.*;

class Edge {
    int x;
    int y;
    int d;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getD() {
        return d;
    }

    Edge(int a, int b, int c) {
        x = a;
        y = b;
        d = c;
    }
}

public class P3714 {
    public static List<Edge> edges = new LinkedList<>();
    public static long INF = 1000000000000L;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        while (T-- > 0) {
            edges = new LinkedList<>();
            int n = input.nextInt();
            for (int i = 0; i < n; i++) {
                int x = input.nextInt();
                int y = input.nextInt();
                edges.add(new Edge(x, y, 0));
            }
            for (int i = n; i < 2 * n; i++) {
                int x = input.nextInt();
                int y = input.nextInt();
                edges.add(new Edge(x, y, 1));
            }
            Collections.sort(edges, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return Integer.compare(o2.getX(), o1.getX());
                }
            });
            double ans = ClosestPointPair(0, 2 * n - 1);
            System.out.printf("%.3f%n", ans);
        }

    }

    public static double ClosestPointPair(int l, int r) {
        if (l == r) return (double) INF;
        int mid = l + r >> 1;
        double a = ClosestPointPair(l, mid);
        double b = ClosestPointPair(mid + 1, r);
        double c = Math.min(a, b);
        for (int i = mid; i >= l; i--) {
            if (edges.get(mid).x - edges.get(i).x > c) break;
            for (int j = mid + 1; j <= r; j++) {
                if (edges.get(j).x - edges.get(i).x > c) break;
                double temp = dist(i, j);
                if (edges.get(j).d != edges.get(i).d) {
                    c = Math.min(c, temp);
                }
            }
        }
        return c;
    }

    public static double dist(int i, int j) {
        return Math.sqrt((edges.get(i).x - edges.get(j).x) * (edges.get(i).x - edges.get(j).x)
                + (edges.get(i).y - edges.get(j).y) * (edges.get(i).y - edges.get(j).y));
    }
}
