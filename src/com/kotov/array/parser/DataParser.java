package com.kotov.array.parser;

import com.kotov.array.exception.ArrayException;
import com.kotov.array.validator.DataFilter;
import com.kotov.array.validator.DataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class DataParser {
    public static Logger logger = LogManager.getLogger();

    public String[] parseIntoIntStrings(String data) throws ArrayException {
        if (!DataValidator.isValid(data)) {
            throw new ArrayException("Data is invalid. Argument is null or empty");
        }
        final String UNFILTERED_NUMERIC_STRING = "\\s+";
        String[] unfilteredData = data.split(UNFILTERED_NUMERIC_STRING);
        String[] numericStrings = DataFilter.filterIntStrings(unfilteredData);
        logger.log(Level.INFO, "Data is parsed into numeric strings. Result is " + Arrays.toString(numericStrings));
        return numericStrings;
    }

    public int[] transformStringArrayIntoIntArray(String[] numericStrings) throws ArrayException {
        if (!DataValidator.isNumericStringsValid(numericStrings)) {
            throw new ArrayException("Invalid data is received: " + Arrays.toString(numericStrings));
        }
        int[] numbers = new int[numericStrings.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numericStrings[i]);
        }
        logger.log(Level.INFO, "Int array is created. Result is " + Arrays.toString(numbers));
        return numbers;
    }
}