package sort;

public class BubbleSort {
    public void sort(int[] array) {
//        НЕ ДОДЕЛАНА !!!
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i+1] = temp;
            }
        }

    }
}
