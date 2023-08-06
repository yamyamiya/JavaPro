package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
    }
//1. Напишите программу на Java для поиска общих элементов между двумя массивами целых чисел
//example input:
//Array1: [1, 2, 5, 5, 8, 9, 7, 10]
//
//Array2: [1, 0, 6, 15, 6, 4, 7, 0]
//
//example expected:
//[1,7]

    public static List<Integer> searchCommonElementsInTwoArrays(int[] array1, int[] array2) {
        List<Integer> array2List = Arrays.stream(array2).boxed().toList();
        List<Integer> commonElements = new ArrayList<>();
        for (int j : array1) {
            if (array2List.contains(j)) {
                commonElements.add(j);
            }

        }
        return commonElements;
    }


//   2. Напишите программу на Java для удаления повторяющихся элементов из массива.
//    example input:
//            [0,3,-2,4,3,2]
//
//    example expected:
//            [0,3,-2,4,2]

    public static List<Integer> creatingDistinctArray(int[] array){
        List<Integer> newList = new ArrayList<>();
        for (int j : array) {
            if (!newList.contains(j)) {
                newList.add(j);
            }

        }
        return newList;
    }


//   3. Напишите программу на Java для поиска второго по величине элемента в массиве.
//example input:
//[-1, 4, 0, 2, 7, -3]
//
//
//
//example expected:
//4

    public static int searchSecondLargestElement(int[] array){
        Arrays.sort(array);
        return array[array.length-2];
    }


//   4. Напишите программу Java для поиска второго наименьшего элемента в массиве.
//    example input:
//            [-1, 4, 0, 2, 7, -3]
//
//    example expected
//-1
    public static int searchSecondSmallestElement(int[] array){
        Arrays.sort(array);
        return array[1];
    }

}