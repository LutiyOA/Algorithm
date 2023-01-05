import search.BinarySearch;
import sort.InsertionSort;
import sort.PiramidaSort;
import sort.QuickSort;
import print.PrintArray;
import list.List;
import list.LinkedList;

import java.util.Date;
import java.util.Scanner;

public class algorithm {
    public static void main(String[] args) {
//        TestSort();
//        TestList();
        TestLinkedList();
    }

    public static void TestLinkedList() {
        LinkedList list=new LinkedList();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(7);
        list.addFirst(8);
        list.addFirst(9);
        list.addFirst(10);

        list.print();
        list.revert();
        list.print();

    }

    public static void TestList() {
        List list=new List();

        list.addFirst(1);
        list.print();
        list.removeFirst();
        list.print();
        list.addFirst(2);
        list.addFirst(1);
        list.print();

        list.removeFirst();
        list.removeFirst();
        list.print();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(7);
        list.addFirst(8);
        list.addFirst(9);
        list.addFirst(10);

        list.print();
        list.revert();
        list.print();



    }

    public static void TestSort() {
        InsertionSort insertionSort = new InsertionSort();
        QuickSort quickSort = new QuickSort();
        PrintArray printArray = new PrintArray();
        PiramidaSort piramidaSort = new PiramidaSort();

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
        System.out.println("Индекс искомого значения:" + binarySearch.search(array2, searchValue));
    }
}
