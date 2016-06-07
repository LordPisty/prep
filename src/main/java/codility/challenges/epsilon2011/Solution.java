package codility.challenges.epsilon2011;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    private static final double EPS = 0.0000001d;
    private static final double INF = 10000000d;

    class Point {
        double x;
        double y;
    }

    class Line {
        int a;
        int b;
    }

    private int cmp0(double x) {
        return (Math.abs(x) < EPS) ? 0 : (x>0 ? 1 : -1);
    }

    private double f(Line[] lines, int i, double x) {
        return lines[i].a * x + lines[i].b;
    }

    private void getIntersection(Line[] lines, int i, int j, Point p) {
        p.x = (lines[j].b - lines[i].b + 0.0) / (lines[i].a - lines[j].a);
        p.y = f(lines, i, p.x);
    }

    private int cmpSlope(Line u, Line v) {
        return ((u.a < v.a) || (u.a == v.a && u.b>v.b)) ? -1 : 1;
    }

    private int getUpperLower(Line[] lines, int b, int e, int inc, int[] idx, Point[] ps)
    {
        ps[0].x = -INF;
        ps[0].y = f(lines, b, ps[0].x);
        idx[0] = b;
        int i, j, k = 0;
        for (j = b+inc; j != e; j += inc) {
            i = idx[k];
            if (lines[j].a != lines[i].a) {
                ++k;
                getIntersection(lines, i, j, ps[k]);
                if (cmp0(ps[k].x - ps[k-1].x) == 0) {
                    --k;
                } else {
                    while (k>=2 && ps[k].x<ps[k-1].x) {
                        getIntersection(lines, idx[k - 2], j, ps[k - 1]);
                        --k;
                    }
                }
                idx[k] = j;
            }
        }
        ps[++k].x = INF;
        ps[k].y = f(lines, idx[k-1], ps[k].x);
        return k;
    }

    public double solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int i, j, un, vn;
        int n = A.length;
        Line[] lines = new Line[n];
        for (i = 0; i < n; ++i) {
            lines[i] = new Line();
            lines[i].a = A[i];
            lines[i].b = B[i];
        }
        Arrays.sort(lines, new Comparator<Line>() {
            @Override
            public int compare(Line u, Line v) {
                return ((u.a < v.a) || (u.a == v.a && u.b > v.b)) ? -1 : 1;
            }
        });

        int[] iu = new int[n+1];
        Point[] pu = new Point[n+1];
        for (int t = 0; t < n+1; t++) {
            pu[t] = new Point();
        }
        un = getUpperLower(lines, 0, n, 1, iu, pu);

        int[] iv = new int[n+1];
        Point[] pv = new Point[n+1];
        for (int t = 0; t < n+1; t++) {
            pv[t] = new Point();
        }
        vn = getUpperLower(lines, n-1, -1, -1, iv, pv);

        if (un<=1 && vn<=1)
            return pu[0].y - pv[0].y;

        double r = INF, dy;
        for (i = 1, j = 1; i<un || j<vn;) {
            if (pu[i].x < pv[j].x) {
                dy = pu[i].y - f(lines, iv[j-1], pu[i].x);
                ++i;
            } else {
                dy = f(lines, iu[i-1], pv[j].x) - pv[j].y;
                ++j;
            }
            r = (dy < r) ? dy : r;
        }

        return Math.abs(r);

    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{-1,1,0,-2},new int[]{3,0,2,2}));
    }
}
