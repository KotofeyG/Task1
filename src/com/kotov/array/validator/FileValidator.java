package com.kotov.array.validator;

import java.io.File;

public class FileValidator {
    public static boolean isValid(String pathToFile) {
        boolean result = false;
        if (pathToFile != null) {
            File file = new File(pathToFile);
            if (file.exists() && !file.isDirectory() && file.canRead() && file.length() != 0) {
                result = true;
            }
        }
        return result;
    }
}