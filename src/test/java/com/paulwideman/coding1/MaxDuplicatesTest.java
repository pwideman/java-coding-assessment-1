package com.paulwideman.coding1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MaxDuplicatesTest {

    @ParameterizedTest
    @CsvSource({
            "'a', 'a', 1",
            "'ab', 'bbaa', 2",
            "'bca', 'bbbcccaa', 2",
            "'aaa', 'aaccccdaetagad', 1",
            "'abcd', 'ddddbbbbccccaaaa', 4",
            "'aaabbbcccd', 'abcdabcdabcd', 1",
            "'abcdabcd', 'ababcabcddddcbacbaba', 2"
    })
    void calculateMaxDuplicates(String a, String b, int expected) {
        var t1 = System.nanoTime();
        assertEquals(expected, MaxDuplicates.calculateMaxDuplicates(a, b));
        var t2 = System.nanoTime();
        assertEquals(expected, MaxDuplicates.calculateMaxDuplicates2(a, b));
        var t3 = System.nanoTime();
        System.out.println("Elapsed nano time diff: " + ((t2 - t1) - (t3 - t2)));
    }
}