package com.kotov.array.validator;

public class DataValidator {
    public static boolean isValid(String data) {
        boolean result = (data != null && data.length() != 0);
        return result;
    }

    public static boolean isValid(String[] data) {
        boolean result = (data != null && data.length != 0);
        return result;
    }

    public static boolean isNumericStringsValid(String[] numericStrings) {
        if (numericStrings == null || numericStrings.length == 0) {
            return false;
        }
        final String INT_NUMBER = "-?\\d+";
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