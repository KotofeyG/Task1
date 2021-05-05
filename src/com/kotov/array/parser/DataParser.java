package com.kotov.array.parser;

import com.kotov.array.exception.ArrayException;
import com.kotov.array.validator.DataFilter;
import com.kotov.array.validator.DataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;

public class DataParser {
    public static Logger logger = LogManager.getLogger();
    private final String IMPURE_NUMERIC_STRING = "\\s+";

    public String[] parseDataIntoNumericStrings(String data) throws ArrayException {
        if (data == null || data.length() == 0) {
            throw new ArrayException("Data is invalid. Argument is null or empty");
        }
        String[] unfilteredData = data.split(IMPURE_NUMERIC_STRING);
        Optional<String[]> filteredData = DataFilter.filterIntStrings(unfilteredData);
        if (filteredData.isEmpty()) {
            throw new ArrayException("Correct data is not found");
        }
        String[] numericStrings = filteredData.get();
        logger.log(Level.INFO, "Data is parsed into numeric strings. Result is " + Arrays.toString(numericStrings));
        return numericStrings;
    }

    public int[] transformNumericStringArrayIntoIntArray(String[] numericStrings) throws ArrayException {
        if (!DataValidator.isNumericStringArrayValid(numericStrings)) {
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