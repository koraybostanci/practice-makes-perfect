package com.practicemakesperfect.crackingthecodinginterview.chapter1_arraysandstrings;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class P13_RecursiveFibonacci {

    private final Map<Integer, Integer> cache = new HashMap();

    public int find(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (!cache.containsKey(n)) {
            int result = find(n - 1) + find(n - 2);
            cache.put(n, result);
        }

        return cache.get(n);
    }

    @Test
    public void testRecursive() {
        int result = find(10);
        Assert.assertEquals(55, result);
    }

}