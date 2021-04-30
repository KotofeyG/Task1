package com.kotov.array.service.impl;

import com.kotov.array.entity.CustomArray;
import com.kotov.array.exception.ArrayException;
import com.kotov.array.service.ArraySortService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArraySortServiceImpl implements ArraySortService {
    public static Logger logger = LogManager.getLogger();

    @Override
    public void streamSort(CustomArray array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Argument contains null");
        }
        if (array.length() < 2) {
            logger.log(Level.INFO, "Array length is " + array.length() + ". It cannot be sorted");
            return;
        }
        array.setArray(Arrays.stream(array.getArray()).sorted().toArray());
        logger.log(Level.INFO, "Array is sorted. Result is " + array);
    }

    @Override
    public void selectionSort(CustomArray array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Argument contains null");
        }
        if (array.length() < 2) {
            logger.log(Level.INFO, "Array length is " + array.length() + ". It cannot be sorted");
            return;
        }
        logger.log(Level.DEBUG, "Argument is " + array);
        for (int i = 0; i < array.length() - 1; i++) {
            int least = i;
            for (int j = i + 1; j < array.length(); j++) {
                if (array.receiveElementValue(j) < array.receiveElementValue(least)) {
                    least = j;
                }
            }
            int temp = array.receiveElementValue(i);
            array.changeElementValue(i, array.receiveElementValue(least));
            array.changeElementValue(least, temp);
        }
        logger.log(Level.INFO, "Array is sorted. Result is " + array);
    }

    @Override
    public void insertionSort(CustomArray array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Argument contains null");
        }
        if (array.length() < 2) {
            logger.log(Level.INFO, "Array length is " + array.length() + ". It cannot be sorted");
            return;
        }
        logger.log(Level.DEBUG, "Argument is " + array);
        for (int i = 1; i < array.length(); i++) {
            int currentElement = array.receiveElementValue(i);
            int j = i - 1;
            while (j >= 0 && array.receiveElementValue(j) > currentElement) {
                array.changeElementValue((j + 1), array.receiveElementValue(j));
                j--;
            }
            array.changeElementValue((j + 1), currentElement);
        }
        logger.log(Level.INFO, "Array is sorted. Result is " + array);
    }

    @Override
    public void quickSort(CustomArray array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Argument contains null");
        }
        if (array.length() < 2) {
            logger.log(Level.INFO, "Array length is " + array.length() + ". It cannot be sorted");
            return;
        }
        logger.log(Level.DEBUG, "Argument is " + array);
        final int FIRST_INDEX = 0;
        final int LAST_INDEX = array.length() - 1;
        sortRecursivelyInInstalments(array, FIRST_INDEX, LAST_INDEX);
        logger.log(Level.INFO, "Array is sorted. Result is " + array);
    }

    private void sortRecursivelyInInstalments(CustomArray array, int left, int right) throws ArrayException {
        int middle = (left + right) / 2;
        int pivot = array.receiveElementValue(middle);
        int i = left;
        int j = right;
        while (i <= j) {
            while (array.receiveElementValue(i) < pivot) {
                i++;
            }
            while (array.receiveElementValue(j) > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array.receiveElementValue(i);
                array.changeElementValue(i, array.receiveElementValue(j));
                array.changeElementValue(j, temp);
                i++;
                j--;
            }
        }
        if (left < j) {
            sortRecursivelyInInstalments(array, left, j);
        }
        if (right > i) {
            sortRecursivelyInInstalments(array, i, right);
        }
    }
}