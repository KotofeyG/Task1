package com.kotov.array.creator;

import com.kotov.array.entity.CustomArray;
import com.kotov.array.exception.ArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCreator {
    public static Logger logger = LogManager.getLogger();

    public CustomArray createCustomArray(int[] numbers) throws ArrayException {
        CustomArray customArray = new CustomArray(numbers);
        logger.log(Level.INFO, "Object of " + customArray.getClass().getSimpleName() + " is created");
        return customArray;
    }
}