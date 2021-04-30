package com.kotov.array.service;

import com.kotov.array.entity.CustomArray;
import com.kotov.array.exception.ArrayException;

public interface ArrayCalculateService {
    void changePrimeNumbersToZero(CustomArray array) throws ArrayException;

    double calculateArithmeticMean(CustomArray array) throws ArrayException;

    int calculateSumOfElements(CustomArray array) throws ArrayException;

    int findMinElement(CustomArray array) throws ArrayException;

    int findMaxElement(CustomArray array) throws ArrayException;

    int calculateQuantityOfPositiveElements(CustomArray array) throws ArrayException;

    int calculateQuantityOfNegativeElements(CustomArray array) throws ArrayException;
}