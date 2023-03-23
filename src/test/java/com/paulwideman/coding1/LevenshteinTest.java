package com.paulwideman.coding1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LevenshteinTest {

    @ParameterizedTest
    @CsvSource({
            "'a', 'a', 0",
            "'b', 'a', 1",
            "'a', 'b', 1",
            "'ab', 'ba', 2",
            "'aa', 'ab', 1",
            "'aa', 'ba', 1",
            "'abc', '123', 3",
            "'abc', 'zzc', 2",
            "'abc', 'abd', 1",
            "'abc', 'azz', 2",
            "'abcd', 'abcd', 0",
            "'abcd', 'dddd', 3",
            "'abcd', 'aaaa', 3",
            "'abcd', 'zzzz', 4",
            "'abcd', 'abzd', 1",
            "'abcd', 'zbcz', 2",
            "'abcdefghijklmnop', 'a', 15",
            "'abcdefghijklmnop', 'efghi', 11",
            "'abcdefghijklmnop', 'ponmlkjihgfedcba', 16"
    })
    void calculateLevenshtein(String a, String b, int dist) {
        assertEquals(dist, Levenshtein.calculateLevenshtein(a, b));
    }
}