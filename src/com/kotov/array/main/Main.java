package com.kotov.array.main;

import com.kotov.array.creator.ArrayCreator;
import com.kotov.array.entity.CustomArray;
import com.kotov.array.exception.ArrayException;
import com.kotov.array.parser.DataParser;
import com.kotov.array.reader.DataReader;
import com.kotov.array.service.ArrayCalculateService;
import com.kotov.array.service.ArraySortService;
import com.kotov.array.service.impl.ArrayCalculateServiceImpl;
import com.kotov.array.service.impl.ArraySortServiceImpl;

import java.io.File;

public class Main {
    public static void main(String[] args) throws ArrayException {
        DataReader reader = new DataReader();
        DataParser parser = new DataParser();
        ArrayCreator creator = new ArrayCreator();
        ArrayCalculateService calculateService = new ArrayCalculateServiceImpl();
        ArraySortService sortService = new ArraySortServiceImpl();

        String data = reader.read(String.join(File.separator, "resources", "array.txt"));
        String[] numericStrings = parser.parseIntoIntStrings(data);
        int[] numbers = parser.transformStringArrayIntoIntArray(numericStrings);

        CustomArray array = creator.createCustomArray(numbers);
        CustomArray temp = creator.createCustomArray(array.getArray());

        sortService.insertionSort(array);
        array.setArray(temp.getArray());

        sortService.selectionSort(array);
        array.setArray(temp.getArray());

        sortService.quickSort(array);
        array.setArray(temp.getArray());

        sortService.streamSort(array);
        array.setArray(temp.getArray());

        calculateService.calculateSumOfElements(array);
        calculateService.calculateArithmeticMean(array);
        calculateService.findMinElement(array);
        calculateService.findMaxElement(array);
        calculateService.calculateQuantityOfNegativeElements(array);
        calculateService.calculateQuantityOfPositiveElements(array);
        calculateService.changePrimeNumbersToZero(array);
    }
}