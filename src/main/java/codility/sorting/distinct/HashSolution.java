package codility.sorting.distinct;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by crespis on 3/21/2016.
 */
public class HashSolution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }
        return set.size();
    }
}