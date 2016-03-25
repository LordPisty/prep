package codility.leader.equiLeader;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        int size = 0;
        int value = -1;
        for (int i = 0; i < n; i++) {
            if (size == 0) {
                size += 1;
                value = A[i];
            } else {
                if (value != A[i]) {
                    size -= 1;
                } else {
                    size += 1;
                }
            }
        }
        int candidate = -1;
        if (size > 0) {
            candidate = value;
        }
        int leader = -1;
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (A[j] == candidate) {
                count += 1;
            }
        }
        if (count > n/2) {
            leader = candidate;
        }

        int[] countL = new int[n];
        int[] countR = new int[n];

        countL[0] = A[0] == leader ? 1 : 0;
        countR[n-1] = A[n-1] == leader ? 1 : 0;


        for (int i = 1; i < n; i++) {
            countL[i] = countL[i-1] + (A[i] == leader ? 1 : 0);
            countR[n-1 - i] = countR[n - i] + (A[n-1 - i] == leader ? 1 : 0);
        }

        int retVal = 0;
        for (int i = 0; i < n -1; i++) {
            if (countL[i] > ((i+1)/2) && countR[i+1] > (n - (i+1))/2) {
                retVal++;
            }
        }
        return retVal;
    }
}
