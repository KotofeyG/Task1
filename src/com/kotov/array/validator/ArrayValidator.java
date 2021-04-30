package com.kotov.array.validator;

import com.kotov.array.entity.CustomArray;

public class ArrayValidator {
    public static boolean isValid(CustomArray array) {
        boolean result = (array != null && array.length() != 0);
        return result;
    }
}