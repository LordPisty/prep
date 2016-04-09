package sorting;

/**
 * Created by screspi on 4/9/16.
 */
public class Quick extends Sort implements Sortable{

    public int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }


    /**
     * O(2NlgN)
     * bad:
     * - fragile to degrading performance depending on partition
     * - non stable (randomize a start for good partitioning!!! ==> otherwise O(N^2))
     * good:
     * - in place
     * - asymptotically optimal
     *
     * Optimizations:
     * - cutoff to insertion sort
     * - median of 3 partition
     *
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
}
