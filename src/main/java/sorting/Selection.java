package sorting;

/**
 * Created by screspi on 4/9/16.
 */
public class Selection extends Sort implements Sortable{

    /**
     * O(N^2)
     * bad:
     * - non-adaptive
     * good:
     * - minimal number of exchanges
     *
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[i], a[j])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }
}
