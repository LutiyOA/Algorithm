import search.BinarySearch;
import sort.InsertionSort;
import sort.PiramidaSort;
import sort.QuickSort;
import print.PrintArray;

import java.util.Date;
import java.util.Scanner;

public class algorithm {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        QuickSort quickSort = new QuickSort();
        PrintArray printArray = new PrintArray();
        PiramidaSort piramidaSort=new PiramidaSort();

        int max = 10000;
        int[] array = new int[max];
        int[] array2 = new int[max];

        for (int i = 0; i < max; i++) {
            array[i] = (int) (Math.random() * 10000);
            array2[i] = array[i];
        }

//        printArray.print(array);
//        printArray.print(array2);

        Date start = new Date();
        piramidaSort.sort(array);
        Date end = new Date();
        long durationSort1 = end.getTime() - start.getTime();

        start = new Date();
        quickSort.sort(array2);
        end = new Date();
        long durationSort2 = end.getTime() - start.getTime();

//        printArray.print(array);
//        printArray.print(array2);

        System.out.println("Duration Sort 1: " + durationSort1);
        System.out.println("Duration Insertion Quick Sort: " + durationSort2);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Искомое значение: ");

        int searchValue = scanner.nextInt();

        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Индекс искомого значения:" + binarySearch.search(array2,searchValue));
    }
}
