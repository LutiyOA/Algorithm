package sort;

public class QuickSort {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int start, int end) {
        int pivot = array[(start + end) / 2];
//        int pivot = array[(start)];
        int left = start;
        int right = end;

        do {
            while (array[left] < pivot)
                left++;
            while (array[right] > pivot)
                right--;
            if (left <= right) {
                if (left < right) {
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                }
                left++;
                right--;
            }
        } while (left <= right);

        if (left < end)
            sort(array, left, end);

        if (start < right)
            sort(array, start, right);
    }
}
