package com.kotov.array.validator;

import com.kotov.array.exception.ArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.regex.Pattern;

public class DataFilter {
    public static Logger logger = LogManager.getLogger();

    public static String[] filterIntStrings(String[] data) throws ArrayException {
        if (!DataValidator.isValid(data)) {
            throw new ArrayException("Data is invalid. Argument is empty or null");
        }
        final String INT_NUMBER = "-?\\d+";
        int quantityOfNumbers = 0;
        for (String unfilteredNumericString : data) {
            if (unfilteredNumericString.matches(INT_NUMBER)) {
                quantityOfNumbers++;
            }
        }
        if (quantityOfNumbers == 0) {
            throw new ArrayException("Correct data is not found");
        }
        String[] numericStrings = new String[quantityOfNumbers];
        int index = 0;
        for (String unfilteredNumericString : data) {
            if (unfilteredNumericString.matches(INT_NUMBER)) {
                numericStrings[index++] = unfilteredNumericString;
            }
        }
        logger.log(Level.INFO, "Data is filtered. Result is " + Arrays.toString(numericStrings));
        return numericStrings;
    }

    public static String[] filterIntStringsWithStream(String[] data) throws ArrayException {
        if (!DataValidator.isValid(data)) {
            throw new ArrayException("Data is invalid. Argument is empty or null");
        }
        final String INT_NUMBER = "-?\\d+";
        String[] numericStrings = Arrays.stream(data)
                .filter(line -> Pattern.matches(INT_NUMBER, line))
                .toArray(String[]::new);
        if (numericStrings.length == 0) {
            throw new ArrayException("Correct data is not found");
        }
        logger.log(Level.INFO, "Data is filtered. Result is " + Arrays.toString(numericStrings));
        return numericStrings;
    }
}