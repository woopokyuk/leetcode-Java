package org.example.vic.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class T77Test {

    @Test
    public void test_combine() {
        T77 t77 = new T77();
        int n = 4;
        int k = 2;
        int[][] res = new int[][]{{2,4},
            {3,4},
            {2,3},
            {1,2},
            {1,3},
            {1,4}
        };
        List<List<Integer>> resList = new ArrayList<>();
        for (int[] row : res) {
            resList.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
        }
        resList.sort((o1, o2) -> {
            if (o1.get(0).compareTo(o2.get(0)) == 0) {
                return o1.get(1).compareTo(o2.get(1));
            } else {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        Assert.assertEquals(resList.toString(), t77.combine(n, k).toString());
    }
}
