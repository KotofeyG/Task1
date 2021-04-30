package com.kotov.array.reader;

import com.kotov.array.exception.ArrayException;
import com.kotov.array.validator.FileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {
    public static Logger logger = LogManager.getLogger();

    public String read(String filePath) throws ArrayException {
        if (!FileValidator.isValid(filePath)) {
            logger.log(Level.ERROR, "Wrong argument. Unable to read data from " + filePath);
            throw new ArrayException("Wrong argument. Unable to read data from " + filePath);
        }
        File file = new File(filePath);
        StringBuilder data = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            do {
                line = bufferedReader.readLine();
                if (line != null) {
                    data.append(line).append(' ');
                }
            } while (line != null);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error reading data in " + filePath);
            throw new ArrayException("Error reading data in " + filePath);
        }
        logger.log(Level.INFO, "File reading is successful. Result is " + data);
        return data.toString();
    }
}