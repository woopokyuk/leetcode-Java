package org.example.vic.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class T451Test {

    @Test
    public void frequencySort() {
        T451 t451 = new T451();
        String s = "tree";
        Assert.assertTrue(t451.frequencySort(s).equals("eert") ||  t451.frequencySort(s).equals("eetr"));
    }
}
