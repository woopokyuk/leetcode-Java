
package org.example.vic.algo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortAlgoTest {
    @Test
    public void test_quickSort() {
        SortAlgo sortAlgo = new SortAlgo();
        int[] temp = new int[]{1, 3, 2, 4, 5, 4, 2, 5};
        List<Integer> arr = Arrays.stream(temp).boxed().collect(Collectors.toList());
        sortAlgo.quickSort((ArrayList<Integer>) arr, 0, arr.size());
        Assert.assertEquals(Arrays.toString(new int[]{1, 2, 2, 3, 4, 4, 5, 5}), arr.toString());
    }
}