package sorting;

/**
 * Created by screspi on 4/9/16.
 */
public class Quick3Way extends Sort implements Sortable{

    /**
     * O(2lg2*NlgN) <= shannon entropy ~ almost linear for a lot of dups
     * bad:
     * - non stable (randomize a start for good partitioning!!! ==> otherwise O(N^2))
     * good:
     * - optimized for duplicate elements
     *
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
