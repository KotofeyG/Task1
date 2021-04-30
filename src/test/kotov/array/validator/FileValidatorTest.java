package test.kotov.array.validator;

import com.kotov.array.validator.FileValidator;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertFalse;

public class FileValidatorTest {

    @Test
    public void testIsValidWithNull() {
        boolean condition = FileValidator.isValid(null);
        assertFalse(condition);
    }

    @Test
    public void testIsValidWithInvalidFilePath() {
        String invalidPathToFile = String.join(File.separator, "test_resources", "nonexistentFile.txt");
        boolean condition = FileValidator.isValid(invalidPathToFile);
        assertFalse(condition);
    }

    @Test
    public void testIsValidWithEmptyFile() {
        String pathToEmptyFile = String.join(File.separator, "test_resources", "emptyFile.txt");
        boolean condition = FileValidator.isValid(pathToEmptyFile);
        assertFalse(condition);
    }

    @Test
    public void testIsValidWithDirectory() {
        String pathToDirectory = String.join(File.separator, "test_resources", "testDirectory");
        boolean condition = FileValidator.isValid(pathToDirectory);
        assertFalse(condition);
    }
}