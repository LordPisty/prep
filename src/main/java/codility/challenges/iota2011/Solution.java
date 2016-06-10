package codility.challenges.iota2011;

import java.util.*;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 1 || A[0] == A[A.length -1]) return 1;

        Set<Integer> reached = new HashSet<>();
        Map<Integer, Set<Integer>> adjacent = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!adjacent.containsKey(A[i])) {
                adjacent.put(A[i], new HashSet<>());
            }
            if (i > 0) {
                adjacent.get(A[i]).add(A[i - 1]);
            }
            if (i < A.length - 1) {
                adjacent.get(A[i]).add(A[i + 1]);
            }
        }
        int step = 2;
        Set<Integer> curr = new HashSet<>();
        curr.add(A[0]);
        reached.add(A[0]);

        while (true) {
            Set<Integer> news = new HashSet<>();
            for (Integer i : curr) {
                for (Integer j : adjacent.get(i)) {
                    if (j == A[A.length - 1]) {
                        return step;
                    } else {
                        if (!reached.contains(j)) {
                            news.add(j);
                            reached.add(j);
                        }
                    }
                }
            }
            step++;
            curr = news;
        }
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1,10,6,5,10,7,5,2}));
    }
}