package org.example.vic.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class T215Test {

    @Test
    public void test_findKthLargest() {
        T215 t215 = new T215();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        Assert.assertEquals(5, t215.findKthLargest(nums, k));
    }

    @Test
    public void test_findKthLargest_largeArr() {
        T215 t215 = new T215();
        int k = 50000;
        int[] nums = readNumbersFromFile("src/test/java/org/example/vic/leetcode/t215_nums.txt");
        Assert.assertEquals(1, t215.findKthLargest(nums, k));
    }

    private int[] readNumbersFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return Arrays.stream(reader.readLine()
                .trim()
                .split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
