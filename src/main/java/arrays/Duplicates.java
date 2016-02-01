package arrays;

import java.util.*;

/**
 * Created by crespis on 2/1/2016.
 */
public class Duplicates {

    // Memory: O(1)
    // Time: O(n^2)
    public static Set<Integer> duplicates(int[] input) {
        Set<Integer> retVal = new HashSet<>();
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i+1; j < input.length; j++) {
                if (input[i] == input[j]) {
                    retVal.add(input[i]);
                }
            }
        }
        return retVal;
    }

    // Memory: O(n)
    // Time: O(n)
    public static Set<Integer> duplicates2(int[] input) {
        Set<Integer> retVal = new HashSet<>();
        Set<Integer> check = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            if (check.add(input[i]) == false) {
                retVal.add(input[i]);
            }
        }
        return retVal;
    }

    // Memory: O(n)
    // Time: (2n)
    public static Set<Integer> duplicates3(int[] input) {
        Set<Integer> retVal = new HashSet<>();
        Map<Integer, Integer> occ = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (occ.get(input[i]) == null) {
                occ.put(input[i],0);
            }
            occ.put(input[i], occ.get(input[i])+1);
        }
        for (int i = 0; i < input.length; i++) {
            if (occ.get(input[i]) > 1) {
                retVal.add(input[i]);
            }
        }
        return retVal;
    }

    // Assumption: finite range 0-N
    // Memory: O(N)
    // Time: O(n)
    public static Set<Integer> duplicates4(int[] input, int alphabetSize) {
        Set<Integer> retVal = new HashSet<>();
        int[] occ = new int[alphabetSize];
        for (int i = 0; i < input.length; i++) {
            occ[input[i]] = occ[input[i]]+1;
        }
        for (int i = 0; i < occ.length; i++) {
            if (occ[i] > 1) {
                retVal.add(i);
            }
        }
        return retVal;
    }

    // changes order
    // Memory: O(n)
    // Time: O(nlogn)
    public static int[] removeDuplicates(int[] input) {
        int[] temp = new int[input.length];
        Arrays.sort(input);
        int previous = input[0];
        int j = 0;
        temp[j++]=previous;
        for (int i = 1; i < input.length; i++) {
            if (input[i] != previous) {
                temp[j++] = input[i];
                previous = input[i];
            }
        }
        return Arrays.copyOf(temp, j);
    }

    // maintains order
    // Memory: O(n)
    // Time: O(n)
    public static int[] removeDuplicates2(int[] input) {
        int[] temp = new int[input.length];
        Set<Integer> uniques = new HashSet<>();
        int j = 0;
        for (int i : input) {
            if (uniques.add(i) == true) {
                temp[j++] = i;
            }
        }
        return Arrays.copyOf(temp, j);
    }

    public static void main(String[] args) {
        System.out.println(duplicates3(new int[]{1, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 2, 3, 2, 8, 8}).equals(duplicates4(new int[]{1, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 2, 3, 2, 8, 8}, 10)));
        System.out.println(duplicates2(new int[]{1, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 2, 3, 2, 8, 8}).equals(duplicates4(new int[]{1,3,4,5,6,7,7,7,7,7,7,2,3,2,8,8},10)));
        System.out.println(duplicates(new int[]{1, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 2, 3, 2, 8, 8}).equals(duplicates4(new int[]{1,3,4,5,6,7,7,7,7,7,7,2,3,2,8,8},10)));

        System.out.println(Arrays.toString(removeDuplicates(new int[]{1,1,1,1,3,4,5,6,7,7,7,7,7,7,2,3,2,8,8})));
    }
}
