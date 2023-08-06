package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {
    int[] array1 = {1, 2, 5, 5, 8, 9, 7, 10};
    int[] array2 = {1, 0, 6, 15, 6, 4, 7, 0};
    int[] array3 = {0,3,-2,4,3,2};
    int[] array4 = {-1, 4, 0, 2, 7, -3};
    @Test
    public void searchCommonElementsInTwoArrays() {
        List<Integer> expected = Arrays.asList(1,7);
        List<Integer> actual = Main.searchCommonElementsInTwoArrays(array1,array2);
        assertEquals(expected, actual);
    }

    @Test
    public void creatingDistinctArray() {
        List<Integer> expected = Arrays.asList(0,3,-2,4,2);
        List<Integer> actual = Main.creatingDistinctArray(array3);
        assertEquals(expected, actual);
    }

    @Test
    public void searchSecondLargestElement() {
        int expected = 4;
        int actual = Main.searchSecondLargestElement(array4);
        assertEquals(expected, actual);
    }

    @Test
    public void searchSecondSmallestElement() {
        int expected = -1;
        int actual = Main.searchSecondSmallestElement(array4);
        assertEquals(expected, actual);
    }
}