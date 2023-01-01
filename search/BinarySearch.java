package search;

public class BinarySearch {
    public int search(int[] array,int value) {
        return search(array, value, 0,array.length-1);
    }

    public int search(final int[] array, final int value, final int start, final int end) {
        if (start>end)
            return -1;

        int index=(end+start)/2;

        if (value<array[index])
            return search(array,value,start,index-1);

        if (value>array[index])
            return search(array,value,index+1,end);

        return index;
    }
}
