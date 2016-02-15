package submatrix;

/**
 * Created by screspi on 2/15/16.
 */
public class Node {

    // sum over range
    private int sum = 0;

    // maximum subarray sum in range
    private int maxSum = 0;

    // sum max subarray start left
    private int lSum = 0;

    // sum max subarray end right
    private int rSum = 0;

    private Node left;

    private Node right;

    private Node parent;

    private int value;

    public Node(int value) {
        this.value = value;
        this.update();
    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
        this.update();
    }

    private void update() {
        if (left == null && right == null) {
            sum = value;
            maxSum = Math.max(0, value);
            lSum = maxSum;
            rSum = maxSum;
        } else {
            sum = (left != null ? left.getSum() : 0) + (right != null ? right.getSum() : 0);
            maxSum = Math.max(
                    Math.max((left != null ? left.getMaxSum() : 0), (right != null ? right.getMaxSum() : 0)),
                    ((left != null ? left.getrSum() : 0) + (right != null ? right.getlSum() : 0))
            );
            lSum = Math.max((left != null ? left.getlSum() : 0),
                    ((left != null ? left.getSum() : 0) + (right != null ? right.getlSum() : 0)));
            rSum = Math.max((right != null ? right.getrSum() : 0),
                    ((right != null ? right.getSum() : 0) + (left != null ? left.getrSum() : 0)));
        }
        if (parent != null) {
            parent.update();
        }
    }

    public int getSum() {
        return sum;
    }

    public int getMaxSum() {
        return maxSum;
    }

    public int getlSum() {
        return lSum;
    }

    public int getrSum() {
        return rSum;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        this.update();
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", rSum=" + rSum +
                ", lSum=" + lSum +
                ", maxSum=" + maxSum +
                ", sum=" + sum +
                '}';
    }
}
