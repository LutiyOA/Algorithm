package sort;

public class PiramidaSort {
    public void sort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            piramidaSort(array, array.length, i);

        for (int i = array.length-1; i >=0; i--) {
            int temp=array[0];
            array[0]=array[i];
            array[i]=temp;
            piramidaSort(array,i,0);
        }
    }

    public void piramidaSort(int[] array, int razmerPiramida, int root) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        boolean isSwap = false;
        int large = root;

        if (left < razmerPiramida && array[large] < array[left]) {
//            int temp = array[left];
//            array[left] = array[root];
//            array[root] = temp;
            isSwap = true;
            large = left;

        }

        if (right < razmerPiramida && array[large] < array[right]) {
//            int temp = array[right];
//            array[right] = array[root];
//            array[root] = temp;
            isSwap = true;
            large = right;

        }

        if (isSwap) {
            int temp = array[large];
            array[large] = array[root];
            array[root] = temp;
            piramidaSort(array, razmerPiramida, large);
        }
    }
}
