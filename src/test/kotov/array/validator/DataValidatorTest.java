package test.kotov.array.validator;

import com.kotov.array.validator.DataValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class DataValidatorTest {
    @Test
    public void testIsValidForStringWithNull() {
        boolean condition = DataValidator.isValid((String) null);
        assertFalse(condition);
    }

    @Test
    public void testIsValidForStringWithEmptyString() {
        String empty = "";
        boolean condition = DataValidator.isValid(empty);
        assertFalse(condition);
    }

    @Test
    public void testIsValidForStringArrayWithNull() {
        boolean condition = DataValidator.isValid((String[]) null);
        assertFalse(condition);
    }

    @Test
    public void testIsValidForStringArrayWithEmptyStringArray() {
        String[] empty = {};
        boolean condition = DataValidator.isValid(empty);
        assertFalse(condition);
    }

    @Test
    public void testIsNumericStringsValidWithNull() {
        boolean condition = DataValidator.isNumericStringsValid(null);
        assertFalse(condition);
    }

    @Test
    public void testIsNumericStringsValidWithEmptyStringArray() {
        String[] empty = {};
        boolean condition = DataValidator.isNumericStringsValid(empty);
        assertFalse(condition);
    }

    @Test
    public void testIsNumericStringsValidWithIncorrectData() {
        String[] incorrectData = {"5", "-1", "22", "0", "--99"};
        boolean condition = DataValidator.isNumericStringsValid(incorrectData);
        assertFalse(condition);
    }
}