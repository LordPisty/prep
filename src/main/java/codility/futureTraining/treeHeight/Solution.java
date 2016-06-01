package codility.futureTraining.treeHeight;

/**
 * Created by crespis on 3/14/2016.
 */
public class Solution {

    class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    public int solution(Tree T) {
        // write your code in Java SE 8
        if (T == null) {
            return -1;
        } else {
            return Math.max(solution(T.l),solution(T.r)) + 1;
        }
    }
}
