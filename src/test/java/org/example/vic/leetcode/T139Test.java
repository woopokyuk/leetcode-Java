package org.example.vic.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T139Test {

    @Test
    public void wordBreak() {
        T139 t139 = new T139();
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("dog");
        wordDict.add("s");
        wordDict.add("gs");
        Assert.assertTrue(t139.wordBreak("dogs", wordDict));
    }
}
