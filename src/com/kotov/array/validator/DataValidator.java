package com.kotov.array.validator;

public class DataValidator {
    public static final String INT_NUMBER = "-?\\d+";

    public static boolean isNumericStringArrayValid(String[] numericStrings) {
        if (numericStrings == null || numericStrings.length == 0) {
            return false;
        }
        boolean result = true;
        int counter = 0;
        while (counter < numericStrings.length) {
            if (!numericStrings[counter].matches(INT_NUMBER)) {
                result = false;
                break;
            }
            counter++;
        }
        return result;
    }
}