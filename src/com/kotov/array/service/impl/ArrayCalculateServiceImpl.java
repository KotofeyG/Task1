package com.kotov.array.service.impl;

import com.kotov.array.entity.CustomArray;
import com.kotov.array.exception.ArrayException;
import com.kotov.array.service.ArrayCalculateService;
import com.kotov.array.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCalculateServiceImpl implements ArrayCalculateService {
    public static Logger logger = LogManager.getLogger();

    @Override
    public void changePrimeNumbersToZero(CustomArray array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Argument contains null");
        }
        if (array.length() == 0) {
            logger.log(Level.INFO, "Array length is 0. It cannot be performed");
            return;
        }
        logger.log(Level.DEBUG, "Argument is " + array);
        final int REPLACEMENT = 0;
        for (int i = 0; i < array.length(); i++) {
            if (isPrimeNumber(array.receiveElementValue(i))) {
                array.changeElementValue(i, REPLACEMENT);
            }
        }
        logger.log(Level.INFO, "Replacing prime numbers to zero is successful. Result is " + array);
    }

    public boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        logger.log(Level.TRACE, "Argument is " + number);
        final int MIN_DENOMINATOR = 2;
        final int HALF_THE_NUMBER = number / 2;
        int denominator = MIN_DENOMINATOR;
        boolean isPrime = true;
        while (denominator <= HALF_THE_NUMBER) {
            if (number % denominator == 0) {
                isPrime = false;
                break;
            }
            denominator++;
        }
        logger.log(Level.TRACE, "Result is " + isPrime);
        return isPrime;
    }

    @Override
    public double calculateArithmeticMean(CustomArray array) throws ArrayException {
        double sum = calculateSumOfElements(array);
        double result = sum / array.length();
        logger.log(Level.INFO, "Calculation of arithmetic mean is successful. Result is " + result);
        return result;
    }

    @Override
    public int calculateSumOfElements(CustomArray array) throws ArrayException {
        if (!ArrayValidator.isValid(array)) {
            throw new ArrayException("Argument is empty or null");
        }
        logger.log(Level.DEBUG, "Argument is " + array);
        int sum = 0;
        for (int i = 0; i < array.length(); i++) {
            sum += array.receiveElementValue(i);
        }
        logger.log(Level.INFO, "Calculation of sum of array elements is successful. Result is " + sum);
        return sum;
    }

    @Override
    public int findMinElement(CustomArray array) throws ArrayException {
        if (!ArrayValidator.isValid(array)) {
            throw new ArrayException("Argument is empty or null");
        }
        logger.log(Level.DEBUG, "Argument is " + array);
        final int FIRST_INDEX = 0;
        int min = array.receiveElementValue(FIRST_INDEX);
        for (int i = 1; i < array.length(); i++) {
            if (min > array.receiveElementValue(i)) {
                min = array.receiveElementValue(i);
            }
        }
        logger.log(Level.INFO, "Search for minimum value in array is successful. Result is " + min);
        return min;
    }

    @Override
    public int findMaxElement(CustomArray array) throws ArrayException {
        if (!ArrayValidator.isValid(array)) {
            throw new ArrayException("Argument is empty or null");
        }
        logger.log(Level.DEBUG, "Argument is " + array);
        final int FIRST_INDEX = 0;
        int max = array.receiveElementValue(FIRST_INDEX);
        for (int i = 1; i < array.length(); i++) {
            if (max < array.receiveElementValue(i)) {
                max = array.receiveElementValue(i);
            }
        }
        logger.log(Level.INFO, "Search for maximum value in array is successful. Result is " + max);
        return max;
    }

    @Override
    public int calculateQuantityOfPositiveElements(CustomArray array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Argument contains null");
        }
        if (array.length() == 0) {
            logger.log(Level.INFO, "Array is empty. Result is 0");
            return 0;
        }
        logger.log(Level.DEBUG, "Argument is " + array);
        int result = 0;
        for (int i = 0; i < array.length(); i++) {
            if (array.receiveElementValue(i) > 0) {
                result++;
            }
        }
        logger.log(Level.INFO, "Search for quantity of positive elements is successful. Result is " + result);
        return result;
    }

    @Override
    public int calculateQuantityOfNegativeElements(CustomArray array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Argument contains null");
        }
        if (array.length() == 0) {
            logger.log(Level.INFO, "Array is empty. Result is 0");
            return 0;
        }
        logger.log(Level.DEBUG, "Argument is " + array);
        int result = 0;
        for (int i = 0; i < array.length(); i++) {
            if (array.receiveElementValue(i) < 0) {
                result++;
            }
        }
        logger.log(Level.INFO, "Search for quantity of elements numbers is successful. Result is " + result);
        return result;
    }
}