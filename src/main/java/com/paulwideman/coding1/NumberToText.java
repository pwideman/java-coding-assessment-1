package com.paulwideman.coding1;

public class NumberToText {
    public static String convertNumberToText(int number) {
        if (number < 1) {
            throw new IllegalArgumentException(String.format("Zero or negative numbers not supported: %s", number));
        }
        var currentNumber = number;
        var result = new StringBuilder();
        var count = 0;
        while(currentNumber > 0) {
            var value = currentNumber % 1000;
            var currentResult = new StringBuilder();
            var valueText = getHundreds(value);
            if (valueText.length() > 0) {
                currentResult.append(" ").append(valueText);
                if (count > 0) {
                    currentResult.append(" ").append(thousandsLookup[count - 1]);
                }
                result.insert(0, currentResult);
            }
            currentNumber = currentNumber / 1000;
            count++;
        }
        return result.toString().trim();
    }

    public static String[] thousandsLookup = new String[] {
            "Thousand",
            "Million",
            "Billion"
    };

    public static String[] onesLookup = new String[] {
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine"
    };

    public static String[] tensLookup = new String[] {
            "Ten",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    public static String[] teensLookup = new String[] {
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen"
    };

    public static String getHundreds(int value) {
        var result = new StringBuilder();
        var hundreds = value / 100;
        if (hundreds > 0) {
            result.append(onesLookup[hundreds - 1]).append(" Hundred");
        }
        var tens = (value % 100) / 10;
        var ones = value % 10;
        if (tens > 0) {
            if (tens == 1 && ones > 0) {
                result.append(" ").append(teensLookup[ones - 1]);
            } else {
                result.append(" ").append(tensLookup[tens - 1]);
            }
        }
        if (tens != 1 && ones > 0) {
            result.append(" ").append(onesLookup[ones - 1]);
        }
        return result.toString().trim();
    }
}
