package sorting;

/**
 * Created by screspi on 4/9/16.
 */
public class MergeBU extends Sort implements Sortable{

    Comparable[] aux;

    public void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }


    /**
     * O(NlgN)
     * bad:
     * - non in place
     * good:
     * - asymptotically optimal
     * - stable
     *
     * Optimizations:
     * - not merge if a[mid] < a[mid+1]
     * - insertion sort for small arrays
     *
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int size = 1; size < N; size = size + size) {
            for (int lo = 0; lo < N - size; lo += size + size) {
                merge(a, lo, lo+size-1, Math.min(lo+size+size-1, N-1));
            }
        }
    }
}
