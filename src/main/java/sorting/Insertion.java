package sorting;

/**
 * Created by screspi on 4/9/16.
 */
public class Insertion extends Sort implements Sortable{

    /**
     * O(N^2)
     * bad:
     *
     * good:
     * - adaptive (# exchanges/compares = # inversions)
     *
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
}
