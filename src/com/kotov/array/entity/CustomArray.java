package com.kotov.array.entity;

import com.kotov.array.exception.ArrayException;

import java.util.Arrays;

public class CustomArray {
    private int[] array;

    public CustomArray() {
        array = new int[0];
    }

    public CustomArray(int... array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("CustomArray cannot be created. Argument contains null");
        }
        this.array = array;
    }

    public void changeElementValue(int index, int number) throws ArrayException {
        if (index < 0 || index >= array.length) {
            throw new ArrayException("Index " + index + " out of bounds for length " + array.length);
        }
        array[index] = number;
    }

    public int receiveElementValue(int index) throws ArrayException {
        if (index < 0 || index >= array.length) {
            throw new ArrayException("Index " + index + " out of bounds for length " + array.length);
        }
        return array[index];
    }

    public int length() {
        return array.length;
    }

    public void setArray(int[] array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Array cannot be changed. Argument contains null");
        }
        this.array = Arrays.copyOf(array, array.length);
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        CustomArray other = (CustomArray) otherObject;
        if (length() != other.length()) {
            return false;
        }
        int index = 0;
        while (index < array.length) {
            if (array[index] != other.array[index]) {
                return false;
            }
            index++;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (int element : array) {
            result = prime * result + element;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getSimpleName());
        result.append("[ array = ");
        for (int number : array) {
            result.append(number).append(", ");
        }
        result.replace(result.length() - 2, result.length(), " ]");
        return result.toString();
    }
}