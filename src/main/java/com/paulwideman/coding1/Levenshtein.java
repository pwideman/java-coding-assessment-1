package com.paulwideman.coding1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Levenshtein {
    public static Map<String, Integer> cache = new HashMap<>();

    // Find the Levenshtein distance between two strings
    public static int calculateLevenshtein(String a, String b) {
        if (Math.min(a.length(), b.length()) == 0) {
            var result = Math.max(a.length(), b.length());
            return result;
        }

        var cacheKey = a + ":" + b;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        var aInsertDistance = 1 + calculateLevenshtein(a.substring(1), b);
        var bInsertDistance = 1 + calculateLevenshtein(a, b.substring(1));
        var replaceDistance = (a.charAt(0) == b.charAt(0) ? 0 : 1) + calculateLevenshtein(a.substring(1), b.substring(1));
        var result = IntStream.of(aInsertDistance, bInsertDistance, replaceDistance).min().getAsInt();
        cache.put(cacheKey, result);
        return result;
    }
}
