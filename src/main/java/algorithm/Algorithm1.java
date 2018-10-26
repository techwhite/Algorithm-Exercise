package algorithm;

public class Algorithm1 {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 3, 4, 5, 5, 4, 4, 2 };

        System.out.println(execute(a, 0, a.length));
    }

    private static int execute(int[] a, int low, int high) {

        while (low < high) {
            // 特殊情况，及时返回。以免出现死循环
            if (high - low == 1) {
                return a[low];
            }
            if (high - low == 2) {
                return Math.max(a[low], a[low + 1]);
            }

            int mid = (low + high) / 2;
            int i = mid;
            while (i >= low && a[i] == a[mid])
                i--;
            int j = mid;
            while (j < high && a[j] == a[mid])
                j++;

            // 关键逻辑
            if (i >= low && a[i] <= a[mid]) {
                if (j < high && a[j] > a[mid]) {
                    low = j;
                    continue;
                } else {
                    return a[j - 1];
                }
            }

            // 关键逻辑
            if (j < high && a[j] <= a[mid]) {
                if (i >= low && a[i] > a[mid]) {
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
