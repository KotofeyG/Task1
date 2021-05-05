package test.kotov.array.validator;

import com.kotov.array.validator.DataValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DataValidatorTest {
    @Test
    public void testIsNumericStringsValid() {
        String[] incorrectData = {"5", "-1", "22", "0", "-99"};
        boolean condition = DataValidator.isNumericStringArrayValid(incorrectData);
        assertTrue(condition);
    }

    @Test
    public void testIsNumericStringsValidWithNull() {
        boolean condition = DataValidator.isNumericStringArrayValid(null);
        assertFalse(condition);
    }

    @Test
    public void testIsNumericStringsValidWithEmptyStringArray() {
        String[] empty = {};
        boolean condition = DataValidator.isNumericStringArrayValid(empty);
        assertFalse(condition);
    }

    @Test
    public void testIsNumericStringsValidWithIncorrectData() {
        String[] incorrectData = {"5", "-1", "22", "0", "--99"};
        boolean condition = DataValidator.isNumericStringArrayValid(incorrectData);
        assertFalse(condition);
    }
}