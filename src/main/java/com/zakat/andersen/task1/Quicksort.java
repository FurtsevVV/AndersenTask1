package com.zakat.andersen.task1;

import java.util.Arrays;

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


//
//        int[] result = new int[partitonArray.length];
//        int counterPositionResult = 0;
//        int opora = (from+(to-from))/2;
//        int initCounterLess=0;
//        int initCounterMore=0;
//        for(int el: partitonArray){
//            if(el<partitonArray[opora])
//                initCounterLess++;
//            if(el>=partitonArray[opora])
//                initCounterMore++;
//        }
//        int [] divideArrayLess = new int[initCounterLess];
//        int [] divideArrayMore = new int[initCounterMore];
//        int counterDivideLess=0;
//        int counterDivideMore=0;
//        for (int i = from; i<partitonArray.length; i++){
//            if(partitonArray[i]<partitonArray[opora]){
//                divideArrayLess[counterDivideLess] = partitonArray[i];
//                counterDivideLess++;
//            }
//            if(partitonArray[i]>=partitonArray[opora]){
//                divideArrayMore[counterDivideMore] = partitonArray[i];
//counterDivideMore++;
//            }
//        }
//
//        System.out.println(Arrays.toString(divideArrayLess));
//
//        System.out.println(Arrays.toString(divideArrayMore));
//        if(divideArrayLess.length>2)
//            movingLess(divideArrayLess, 0, divideArrayLess.length-1);
//if(divideArrayLess.length==2){
//    if (divideArrayLess[0]>= divideArrayLess[1]){
//        int temp = divideArrayLess[0];
//        divideArrayLess[0]=divideArrayLess[1];
//        result[counterPositionResult]= divideArrayLess[0];
//        counterPositionResult++;
//        result[counterPositionResult] = divideArrayLess[1];
//        counterPositionResult++;
//    } else {
//        result[counterPositionResult]= divideArrayLess[0];
//        counterPositionResult++;
//        result[counterPositionResult] = divideArrayLess[1];
//        counterPositionResult++;
//    }}
//    if (divideArrayLess.length==1) {
//        result[counterPositionResult] = divideArrayLess[0];
//        counterPositionResult++;
//    }
//        if(divideArrayLess.length==0){
//        }
//
//
//        System.out.println("Result is " + Arrays.toString(result));
}






