package com.kotov.array.service;

import com.kotov.array.entity.CustomArray;
import com.kotov.array.exception.ArrayException;

public interface ArraySortService {
    void selectionSort(CustomArray array) throws ArrayException;

    void insertionSort(CustomArray array) throws ArrayException;

    void quickSort(CustomArray array) throws ArrayException;

    void streamSort(CustomArray array) throws ArrayException;
}