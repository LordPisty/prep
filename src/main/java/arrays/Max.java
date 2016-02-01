package arrays;

/**
 * Created by crespis on 2/1/2016.
 */
public class Max {

    public static void top2(int[] input) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i : input) {
            if (i > max1) {
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max2 = i;
            }
        }
        System.out.printf("1:%d 2:%d %n", max1, max2);
    }

    public static void top2Distinct(int[] input) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i : input) {
            if (i > max1) {
                max2 = max1;
                max1 = i;
            } else if (i != max1 && i > max2) {
                max2 = i;
            }
        }
        System.out.printf("1:%d 2:%d %n", max1, max2);
    }

    public static void main(String[] args) {
        top2(new int[]{1,1,1,1,3,4,5,6,7,7,7,7,7,7,2,3,2,8,8,8});
        top2Distinct(new int[]{1,1,1,1,3,4,5,6,7,7,7,7,7,7,2,3,2,8,8,8});
    }
}
