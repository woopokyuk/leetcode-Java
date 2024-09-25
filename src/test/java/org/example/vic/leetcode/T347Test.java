package org.example.vic.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class T347Test {

    @Test
    public void test_topKFrequent() {
        T347 t347 = new T347();
        int[] nums = new int[]{1,1,1,1,2,2,3};
        int k = 2;
        Assert.assertArrayEquals(new int[]{1, 2}, t347.topKFrequent(nums, k));
    }

    @Test
    public void test_topKFrequent1() {
        T347 t347 = new T347();
        int[] nums = new int[]{1,2};
        int k = 2;
        Assert.assertArrayEquals(new int[]{1, 2}, t347.topKFrequent(nums, k));
    }
}
