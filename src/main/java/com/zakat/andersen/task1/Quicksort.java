package com.zakat.andersen.task1;

import java.util.Comparator;

/**
 * Class quicksort give realization static method quicksort
 */

public class Quicksort {
    public static void main(String[] args) {

    }

    /**
     * Quicksort recursive
     *
     * @param array sorted array
     * @param from  first index of sorted array
     * @param to    last index of sorted array
     */
    public static void quicksort(int[] array, int from, int to) {
        if (from < to) {
            int opIndex = divideArray(array, from, to);
            quicksort(array, from, opIndex - 1);
            quicksort(array, opIndex, to);

        }
    }

    /**
     * Divide arrey to 2 arrays where each array have elements more of less based element "opora"
     *
     * @param partitonArray
     * @param from
     * @param to
     * @return first index for divide next arrays
     */
    private static int divideArray(int[] partitonArray, int from, int to) {

        int indexStart = from;
        int indexEnd = to;
        int opIndex = from + (to - from) / 2;
        int opora = partitonArray[opIndex];

        while (indexStart <= indexEnd) {
            while (partitonArray[indexStart] < opora) {
                indexStart++;
            }
            while (partitonArray[indexEnd] > opora) {
                indexEnd--;
            }
            if (indexStart <= indexEnd) {
                changeElement(partitonArray, indexStart, indexEnd);
                indexStart++;
                indexEnd--;
            }
        }
        return indexStart;
    }

        /**
     * Support method change elements to base subarray
     *
     * @param array
     * @param indexLeft
     * @param indexRight
     */
    private static void changeElement(int[] array, int indexLeft, int indexRight) {
        int temp = array[indexLeft];
        array[indexLeft] = array[indexRight];
        array[indexRight] = temp;
    }


    public static void quicksortWithComparator(DynamicList list, int from, int to, Comparator comparator){
        if (from < to) {
            int opIndex = divideArrayList(list, from, to, comparator);
            quicksortWithComparator(list, from, opIndex - 1, comparator);
            quicksortWithComparator(list, opIndex, to,comparator);

        }
    }

    private static int divideArrayList(DynamicList list, int from, int to, Comparator comparator) {

        int indexStart = from;
        int indexEnd = to;
        int opIndex = from + (to - from) / 2;

        while (indexStart <= indexEnd) {
            while (comparator.compare(list.getElementToIndex(indexStart), list.getElementToIndex(opIndex))<0) {
                indexStart++;
            }
            while (comparator.compare(list.getElementToIndex(indexEnd),  list.getElementToIndex(opIndex)) >0) {
                indexEnd--;
            }
            if (indexStart <= indexEnd) {
                changeElementToList(list, indexStart, indexEnd);
                indexStart++;
                indexEnd--;
            }
        }
        return indexStart;
    }

    private static void changeElementToList(DynamicList dynamicList, int indexLeft, int indexRight) {
        DynamicList<Object> temp  = new DynamicList<>();
        temp.add(dynamicList.getElementToIndex(indexLeft));

        dynamicList.setElement(indexLeft, dynamicList.getElementToIndex(indexRight));
        dynamicList.setElement(indexRight, temp.getElementToIndex(0));
    }



}






