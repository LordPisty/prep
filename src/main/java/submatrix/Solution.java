package submatrix;

/**
 * Created by screspi on 2/15/16.
 */
public class Solution {

    // maximum sum subrectangle in sparse matrix
    // props to http://stackoverflow.com/a/17595372
    public static void main(String[] args) {

        int[][] input = new int[4][];
        input[0] = new int[]{1,0,0,1};
        input[1] = new int[]{0,0,8,0};
        input[2] = new int[]{0,-1,0,0};
        input[3] = new int[]{-2,0,0,1};

        System.out.println(maxSubRectangle(input));
    }

    // input should be square and sparse
    private static int maxSubRectangle(int[][] matrix) {
        int retVal = 0;
        int size = matrix.length;
        Node[] base = Utils.nodify(new int[size]);
        Node root = Utils.buildTree(base);
        for (int i = 0; i < size; i++) { // O(n)
            // reset tree
            for (int t = 0; t < size; t++) {
                base[t].setValue(0);
            }
            for (int j = i; j < size; j++) {        // O(m)
                for (int k = 0; k < size; k++) {    // !!!SPARSE!!!
                    if (matrix[j][k] != 0) {
                        base[k].setValue(base[k].getValue()+ matrix[j][k]); // O(log n)
                    }
                }
                if (root.getMaxSum() > retVal) {
                    retVal = root.getMaxSum();
                }
            }
        }

        return retVal;
    }
}
