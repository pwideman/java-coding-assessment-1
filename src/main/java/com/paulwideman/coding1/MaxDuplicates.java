package com.paulwideman.coding1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxDuplicates {
    // Calculate the max number of times you can recreate string a from the letters in string b
    public static int calculateMaxDuplicates(String a, String b) {
        var aArray = a.toCharArray();
        Arrays.sort(aArray);
        var bArray = b.toCharArray();
        Arrays.sort(bArray);
        char aChar;
        int aIndex = 0;
        char bChar;
        int bIndex = 0;
        var max = Integer.MAX_VALUE;
        while (bIndex < bArray.length && aIndex < aArray.length) {
            aChar = aArray[aIndex];
            var i = aIndex;
            // Count the number of this char in A
            for(; i < aArray.length && aChar == aArray[i]; i++);
            var numAChars = i - aIndex;
            aIndex = i;
            bChar = bArray[bIndex];
            if (aChar != bChar) {
                // B doesn't have this character in A, so return zero
                return 0;
            } else {
                i = bIndex;
                // Count the number of this char in B
                for(; i < bArray.length && bChar == bArray[i]; i++);
                var numBChars = i - bIndex;
                if (numBChars < numAChars) {
                    // B doesn't have enough of this character to duplicate A, so return zero
                    return 0;
                }
                max = Math.min(max, numBChars / numAChars);
                bIndex = i;
            }
        }
        return max;
    }

    public static Map<Character, Integer> countChars(String s) {
        var map = new HashMap<Character, Integer>();
        s.chars().forEach((c) -> {
            var ch = (char)c;
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        });
        return map;
    }

    public static int calculateMaxDuplicates2(String a, String b) {
        var aMap = countChars(a);
        var bMap = countChars(b);
        var max = Integer.MAX_VALUE;
        for(var c : aMap.keySet()) {
            if (!bMap.containsKey(c)) {
                // character in A, not in B, return zero
                return 0;
            }
            var aChars = aMap.get(c);
            var bChars = bMap.get(c);
            if (aChars > bChars) {
                // not enough of this char in B to make A, return zero
                return 0;
            }
            max = Math.min(max, bChars / aChars);
        }
        return max;
    }
}
