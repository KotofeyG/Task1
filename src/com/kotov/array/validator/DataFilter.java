package com.kotov.array.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

public class DataFilter {
    public static Logger logger = LogManager.getLogger();
    public static final String INT_NUMBER = "-?\\d+";

    public static Optional<String[]> filterIntStrings(String[] data) {
        if (data == null || data.length == 0) {
            return Optional.empty();
        }
        int quantityOfNumbers = 0;
        for (String impureNumericString : data) {
            if (impureNumericString.matches(INT_NUMBER)) {
                quantityOfNumbers++;
            }
        }
        if (quantityOfNumbers == 0) {
            return Optional.empty();
        }
        String[] numericStrings = new String[quantityOfNumbers];
        int index = 0;
        for (String impureNumericString : data) {
            if (impureNumericString.matches(INT_NUMBER)) {
                numericStrings[index++] = impureNumericString;
            }
        }
        logger.log(Level.INFO, "Data is filtered. Result is " + Arrays.toString(numericStrings));
        return Optional.of(numericStrings);
    }

    public static Optional<String[]> filterIntStringsWithStream(String[] data) {
        if (data == null || data.length == 0) {
            return Optional.empty();
        }
        String[] numericStrings = Arrays.stream(data)
                .filter(impureNumericString -> Pattern.matches(INT_NUMBER, impureNumericString))
                .toArray(String[]::new);
        if (numericStrings.length == 0) {
            return Optional.empty();
        }
        logger.log(Level.INFO, "Data is filtered. Result is " + Arrays.toString(numericStrings));
        return Optional.of(numericStrings);
    }
}