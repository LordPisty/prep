package codility.challenges.eta2011;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    class Road {
        int t1;
        int t2;

        Road(int t1, int t2) {
            this.t1 = Math.min(t1, t2);
            this.t2 = Math.max(t1, t2);
        }

        public int hashCode() {
            return t1 * t2;
        }

        public boolean equals(Object o) {
            Road r = (Road) o;
            return t1 == r.t1 && t2 == r.t2;
        }
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int M = A.length / 2 + 1;

        for (int i = 0; i < A.length; i++) {
            // check auto-circles
            if (A[i] == A[(i+1) % A.length]) {
                return -2;
            }
        }
        int towns[] = new int[M];
        for (int i : A) {
            towns[i]++;
        }
        for (int i : towns) {
            if (i != 1 && i != 3) {
                return -2;
            }
        }

        Map<Road, Integer> road2count = new HashMap<Road, Integer>();
        for (int i = 0; i < A.length; i++) {
            Road road = new Road(A[i], A[(i + 1) % A.length]);
            if (!road2count.containsKey(road)) {
                road2count.put(road, 0);
            }
            road2count.put(road, road2count.get(road) + 1);
        }

        for (int count : road2count.values()) {
            if (count != 2) {
                return -2;
            }
        }

        return 3;
    }

    public static void main (String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{4,0,4,3,4,1,5,1,7,6,7,2,7,1}));
    }
}