package org.example.vic.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class T547Test {

    @Test
    public void test_findCircleNum() {
        T547 t547 = new T547();
        int[][] arr = {
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };
        Assert.assertEquals(2, t547.findCircleNum(arr));
    }
}
