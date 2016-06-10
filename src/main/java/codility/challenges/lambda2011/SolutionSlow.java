package codility.challenges.lambda2011;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SolutionSlow {
    public int solution(int[] T) {
        // write your code in Java SE 8
        int N = T.length;
        int currMin  = Integer.MAX_VALUE;
        int minIdx = -1;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (i != T[i]) {
                if (!adj.containsKey(i)) {
                    adj.put(i, new HashSet<>());
                }
                adj.get(i).add(T[i]);

                if (!adj.containsKey(T[i])) {
                    adj.put(T[i], new HashSet<>());
                }
                adj.get(T[i]).add(i);
            }
        }

        for (int i = 0; i < N; i++) {
            Set<Integer> reached = new HashSet<>();
            reached.add(i);
            Set<Integer> added = new HashSet<>();
            added.add(i);
            int dist = 1;
            int currD = 0;
            while(reached.size() < N - 1) {
                Set<Integer> newAdded = new HashSet<>();
                for (int j : added) {
                    for (int z : adj.get(j)) {
                        if (!reached.contains(z)) {
                            currD += dist;
                            newAdded.add(z);
                            reached.add(z);
                        }
                    }
                }
                added = newAdded;
                dist++;
            }
            if (currD < currMin) {
                currMin = currD;
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void main(String... args) {
        SolutionSlow s = new SolutionSlow();
        System.out.println(s.solution(new int[]{9,1,4,9,0,4,8,9,0,1}));
    }
}