package com.kotov.array.service.impl;

import com.kotov.array.entity.CustomArray;
import com.kotov.array.exception.ArrayException;
import com.kotov.array.service.ArrayCalculateService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayStreamCalculateServiceImpl implements ArrayCalculateService {
    public static Logger logger = LogManager.getLogger();

    @Override
    public void changePrimeNumbersToZero(CustomArray array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Argument contains null");
        }
        if (Arrays.stream(array.getArray()).findAny().isEmpty()) {
            logger.log(Level.INFO, "Array length is 0. It cannot be performed");
            return;
        }
        ArrayCalculateServiceImpl service = new ArrayCalculateServiceImpl();
        array.setArray(Arrays.stream(array.getArray())
                .map(element -> (service.isPrimeNumber(element)) ? 0 : element)
                .toArray());
        logger.log(Level.INFO, "Replacing prime numbers to zero is successful. Result is " + array);
    }

    @Override
    public double calculateArithmeticMean(CustomArray array) throws ArrayException {
        if (array == null || Arrays.stream(array.getArray()).average().isEmpty()) {
            throw new ArrayException("Argument is empty or null");
        }
        double result = Arrays.stream(array.getArray()).average().getAsDouble();
        logger.log(Level.INFO, "Calculation of arithmetic mean is successful. Result is " + result);
        return result;
    }

    @Override
    public int calculateSumOfElements(CustomArray array) throws ArrayException {
        if (array == null || Arrays.stream(array.getArray()).findAny().isEmpty()) {
            throw new ArrayException("Argument is empty or null");
        }
        int sum = Arrays.stream(array.getArray()).sum();
        logger.log(Level.INFO, "Calculation of sum of array elements is successful. Result is " + sum);
        return sum;
    }

    @Override
    public int findMinElement(CustomArray array) throws ArrayException {
        if (array == null || Arrays.stream(array.getArray()).min().isEmpty()) {
            throw new ArrayException("Argument is empty or null");
        }
        int min = Arrays.stream(array.getArray()).min().getAsInt();
        logger.log(Level.INFO, "Search for minimum value in array is successful. Result is " + min);
        return min;
    }

    @Override
    public int findMaxElement(CustomArray array) throws ArrayException {
        if (array == null || Arrays.stream(array.getArray()).max().isEmpty()) {
            throw new ArrayException("Argument is empty or null");
        }
        int max = Arrays.stream(array.getArray()).max().getAsInt();
        logger.log(Level.INFO, "Search for minimum value in array is successful. Result is " + max);
        return max;
    }

    @Override
    public int calculateQuantityOfPositiveElements(CustomArray array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Argument contains null");
        }
        if (Arrays.stream(array.getArray()).findAny().isEmpty()) {
            logger.log(Level.INFO, "Array is empty. Result is 0");
            return 0;
        }
        int result = (int) Arrays.stream(array.getArray()).filter(element -> element > 0).count();
        logger.log(Level.INFO, "Search for quantity of positive elements is successful. Result is " + result);
        return result;
    }

    @Override
    public int calculateQuantityOfNegativeElements(CustomArray array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Argument contains null");
        }
        if (Arrays.stream(array.getArray()).findAny().isEmpty()) {
            logger.log(Level.INFO, "Array is empty. Result is 0");
            return 0;
        }
        int result = (int) Arrays.stream(array.getArray()).filter(element -> element < 0).count();
        logger.log(Level.INFO, "Search for quantity of positive elements is successful. Result is " + result);
        return result;
    }
}