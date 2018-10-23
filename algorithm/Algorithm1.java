
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Algorithm1 {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 3, 4, 5, 5, 6, 7 };

        execute(a, 0, a.length);
    }

    private static int execute(int[] a, int low, int high) {

        while (low < high) {
            int mid = (low + high) / 2;
            int i = mid;
            while (i > low && a[i] == a[mid])
                i--;
            int j = mid;
            while (j < high && a[j] == a[mid])
                j++;

            if (a[i] <= a[mid]) {
                if (a[j] > a[mid]) {
                    low = j;
                    continue;
                } else {
                    return a[j - 1];
                }
            }

            if (a[j] <= a[mid]) {
                if (a[i] > a[mid]) {
                    high = i;
                    continue;
                } else {
                    return a[i + 1];
                }
            }
        }

        return a[low];
    }
}
