package test.kotov.array.validator;

import com.kotov.array.validator.FileValidator;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class FileValidatorTest {
    @Test
    public void testIsFileValid() {
        String invalidPathToFile = String.join(File.separator, "test_resources", "testArray.txt");
        boolean condition = FileValidator.isFileValid(invalidPathToFile);
        assertTrue(condition);
    }

    @Test
    public void testIsFileValidWithNull() {
        boolean condition = FileValidator.isFileValid(null);
        assertFalse(condition);
    }

    @Test
    public void testIsFileValidWithInvalidPathToFile() {
        String invalidPathToFile = String.join(File.separator, "test_resources", "nonexistentFile.txt");
        boolean condition = FileValidator.isFileValid(invalidPathToFile);
        assertFalse(condition);
    }

    @Test
    public void testIsFileValidWithEmptyFile() {
        String pathToEmptyFile = String.join(File.separator, "test_resources", "emptyFile.txt");
        boolean condition = FileValidator.isFileValid(pathToEmptyFile);
        assertFalse(condition);
    }

    @Test
    public void testIsFileValidWithDirectory() {
        String pathToDirectory = String.join(File.separator, "test_resources", "testDirectory");
        boolean condition = FileValidator.isFileValid(pathToDirectory);
        assertFalse(condition);
    }
}