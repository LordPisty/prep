package codility.challenges.lambda2011;

class Solution {
    public int solution(int[] T) {
        // write your code in Java SE 8
        int N = T.length;
        int[] D = new int[N];

        // count degree
        for (int i = 0; i < N; i++) {
            if (i!= T[i]) {
                D[T[i]]++;
            }
        }
        // craete order by level: leaves to root
        int[] O = new int[N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (D[i] == 0) {
                O[idx++] = i;
            }
        }
        for (int i = 0; i < N-1; i++) {
            int j = O[i];
            D[T[j]] -= 1;
            if (D[T[j]] == 0) {
                O[idx++] = T[j];
            }
        }

        // size of subtree rooted at i
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = 1;
        }
        // total length of paths sarting at i
        int[] P = new int[N];

        // paths down: x <- y ==> P[x] = P[y] + S[y]
        for (int i = 0; i < N-1; i++) {
            int y = O[i];
            int x = T[y];
            // accumulate subtrees
            S[x] = S[x] + S[y];
            // accumulate paths
            P[x] += P[y] + S[y];
        }

        // paths up: x <- y
        for (int i = N - 2; i >= 0; i--) {
            int y = O[i];
            int x = T[y];
            // (P[x] - S[y]): paths from x - overlap
            // (N - S[y]): additional link = whole tree - subtree
            P[y] = (P[x] - S[y]) + (N - S[y]);
        }

        int idxM = 0;
        for (int i = 1; i < N; i++) {
            if (P[i] < P[idxM]) {
                idxM = i;
            }
        }
        return idxM;
    }

    public static void main(String... args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{9,1,4,9,0,4,8,9,0,1}));
    }
}