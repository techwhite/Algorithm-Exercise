package algorithm;

import java.util.Arrays;

public class Algorithm9 {
    public static void main(String[] args) {
        int[] numbers = new int[] { -1, 2, 5, 6, 4, 15, 9, 1, 8, 9, 20, 12, 13, 6, 7 };

        findheap(numbers, 6);
    }

    private static void findheap(int[] numbers, int N) {
        if (N > numbers.length) return;

        System.out.println(Arrays.toString(numbers));

        int[] heap = new int[N];

        // 初始化堆
        for (int i = 0; i < N; i++)
            heap[i] = numbers[i];
        System.out.println(Arrays.toString(heap));

        // 调整到最大堆
        createHeap(heap);
        System.out.println(Arrays.toString(heap));

        // 遍历插入最大堆
        for (int i = N; i < numbers.length; i++) {
            ajustHead(heap, numbers[i]);
        }
        System.out.println(Arrays.toString(heap));
    }

    private static void ajustHead(int[] heap, int num) {
        if (heap.length <= 0 || num > heap[0])
            return;

        heap[0] = num;
        int i = 0;
        while (i < heap.length) {
            int leftIndex = 2 * i + 1;
            int rightIndex = leftIndex + 1;

            if (leftIndex >= heap.length)
                break;

            if (rightIndex >= heap.length) {
                if (heap[i] < heap[leftIndex]) {
                    swap(heap, i, leftIndex);
                }

                break;
            }

            if (heap[leftIndex] > heap[rightIndex] && heap[i] < heap[leftIndex]) {
                swap(heap, i, leftIndex);
            }

            if (heap[rightIndex] > heap[leftIndex] && heap[i] < heap[rightIndex]) {
                swap(heap, i, rightIndex);
            }

            i++;
        }
    }

    // 初始化堆，注意从0开始，左子节点是2*n+1, 右子节点是2*n+2。可以从下往上调整（不需要遍历到0节点），也可以从上往下调整
    private static void createHeap(int[] heap) {
        if (heap.length <= 0)
            return;

        while (true) {
            int shift = 0;
            // 开始调整堆
            for (int i = heap.length - 1; i > 0; i--) {
                int parentIndex = (i - 1) / 2;
                if (parentIndex < 0)
                    parentIndex = 0;
                int leftIndex = 2 * parentIndex + 1;
                int rightIndex = leftIndex + 1;

                if (leftIndex >= heap.length) {
                    continue;
                }

                if (rightIndex >= heap.length) {
                    if (heap[leftIndex] > heap[parentIndex]) {
                        swap(heap, leftIndex, parentIndex);
                        shift++;
                    }
                    continue;
                }

                int max = Math.max(heap[parentIndex], Math.max(heap[leftIndex], heap[rightIndex]));
                if (max == heap[parentIndex]) {
                    i = leftIndex;
                    continue;
                }

                int tmp = heap[parentIndex];
                heap[parentIndex] = max;

                if (max == heap[leftIndex]) {
                    heap[leftIndex] = tmp;
                }

                if (max == heap[rightIndex]) {
                    heap[rightIndex] = tmp;
                }

                shift++;
                i = leftIndex;
            }

            if (shift == 0) {
                break;
            }
        }

    }

    private static void swap(int[] a, int i, int j) {
        if (i < 0 || i >= a.length || j < 0 || j >= a.length) {
            return;
        }

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
