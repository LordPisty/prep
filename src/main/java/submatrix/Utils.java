package submatrix;

/**
 * Created by screspi on 2/15/16.
 */
public class Utils {

    public static Node[] nodify(int[] values) {
        Node[] retVal = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            retVal[i] = new Node(values[i]);
        }
        return retVal;
    }

    public static Node buildTree(Node[] leaves) {
        Node root = null;
        if (leaves != null) {
            if (leaves.length > 1) {
                Node[] newLevel = new Node[(int)Math.ceil(((double)leaves.length)/2)];
                int i = 0;
                for (; i < leaves.length - 1; i+=2) {
                    newLevel[i / 2] = new Node(leaves[i], leaves[i+1]);
                    leaves[i].setParent(newLevel[i/2]);
                    leaves[i+1].setParent(newLevel[i/2]);
                }
                if (i == leaves.length - 1) {
                    newLevel[newLevel.length - 1] = new Node(leaves[i], null);
                    leaves[i].setParent(newLevel[newLevel.length - 1]);
                }
                return buildTree(newLevel);
            } else if (leaves.length == 1) {
                root = leaves[0];
            }
        }
        return root;
    }

    public static void main(String... args) {
        System.out.println(buildTree(nodify(new int[] {1})));
        System.out.println(buildTree(nodify(new int[] {1,2,3})));
        System.out.println(buildTree(nodify(new int[] {1,-1,-1,1})));
        System.out.println(buildTree(nodify(new int[] {1,-1,2,3,4,5})));
    }
}
