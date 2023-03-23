package com.paulwideman.coding1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberToTextTest {

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            "1, 'One'",
            "10, 'Ten'",
            "15, 'Fifteen'",
            "95, 'Ninety Five'",
            "100, 'One Hundred'",
            "101, 'One Hundred One'",
            "110, 'One Hundred Ten'",
            "111, 'One Hundred Eleven'",
            "155, 'One Hundred Fifty Five'",
            "1000, 'One Thousand'",
            "1002, 'One Thousand Two'",
            "1020, 'One Thousand Twenty'",
            "1015, 'One Thousand Fifteen'",
            "1230, 'One Thousand Two Hundred Thirty'",
            "12345, 'Twelve Thousand Three Hundred Forty Five'",
            "36013, 'Thirty Six Thousand Thirteen'",
            "456200, 'Four Hundred Fifty Six Thousand Two Hundred'",
            "1000000, 'One Million'",
            "1000234, 'One Million Two Hundred Thirty Four'",
            "1345000, 'One Million Three Hundred Forty Five Thousand'",
            "1000399, 'One Million Three Hundred Ninety Nine'",
            "15000001, 'Fifteen Million One'",
            "26004555, 'Twenty Six Million Four Thousand Five Hundred Fifty Five'",
            "876321045, 'Eight Hundred Seventy Six Million Three Hundred Twenty One Thousand Forty Five'",
            "1000000000, 'One Billion'",
            "1111111111, 'One Billion One Hundred Eleven Million One Hundred Eleven Thousand One Hundred Eleven'",
            "1002003004, 'One Billion Two Million Three Thousand Four'",
            "1234567899, 'One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety Nine'",
            "2000000000, 'Two Billion'",
            "2000000001, 'Two Billion One'"
    })
    void canConvertNumbersToText(int number, String text) {
        assertEquals(text, NumberToText.convertNumberToText(number));
    }
}