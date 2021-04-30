package test.kotov.array.validator;

import com.kotov.array.exception.ArrayException;
import com.kotov.array.validator.DataFilter;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataFilterTest {
    @Test
    public void testFilterIntStrings() throws ArrayException {
        String[] data = {"1", "2", "-10", "#", "$%^&", "5", "22", "5%", "number", "-10", "-6", "0", "5@", "44!", "6"};
        String[] actual = DataFilter.filterIntStrings(data);
        String[] expected = {"1", "2", "-10", "5", "22", "-10", "-6", "0", "6"};
        assertEquals(actual, expected, "Test failed as logic of DataFilter is not built correctly");
    }

    @Test(expectedExceptionsMessageRegExp = "Data is invalid. Argument is empty or null")
    public void testFilterIntStringsExceptionWithNull() {
        try {
            DataFilter.filterIntStrings(null);
            fail("Test filterIntStrings for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Data is invalid. Argument is empty or null", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Data is invalid. Argument is empty or null")
    public void testFilterIntStringsExceptionWithEmptyArray() {
        String[] empty = {};
        try {
            DataFilter.filterIntStrings(empty);
            fail("Test filterIntStrings for empty array should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Data is invalid. Argument is empty or null", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Correct data is not found")
    public void testFilterIntStringsExceptionWithIncorrectData() {
        String[] incorrectData = {"#", "$%^&", "5%", "number", "5@", "44!"};
        try {
            DataFilter.filterIntStrings(incorrectData);
            fail("Test filterIntStrings for incorrect data should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Correct data is not found", e.getMessage());
        }
    }

    @Test
    public void testFilterIntStringsWithStream() throws ArrayException {
        String[] data = {"1", "2", "-10", "#", "$%^&", "5", "22", "5%", "number", "-10", "-6", "0", "5@", "44!", "6"};
        String[] actual = DataFilter.filterIntStringsWithStream(data);
        String[] expected = {"1", "2", "-10", "5", "22", "-10", "-6", "0", "6"};
        assertEquals(actual, expected, "Test failed as logic of DataFilter is not built correctly");
    }

    @Test(expectedExceptionsMessageRegExp = "Data is invalid. Argument is empty or null")
    public void testFilterIntStringsWithStreamWithNull() {
        try {
            DataFilter.filterIntStringsWithStream(null);
            fail("Test filterIntStringsWithStream for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Data is invalid. Argument is empty or null", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Data is invalid. Argument is empty or null")
    public void testFilterIntStringsWithStreamExceptionWithEmptyArray() {
        String[] empty = {};
        try {
            DataFilter.filterIntStringsWithStream(empty);
            fail("Test filterIntStringsWithStream for empty array should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Data is invalid. Argument is empty or null", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Correct data is not found")
    public void testFilterIntStringsWithStreamExceptionWithIncorrectData() {
        String[] incorrectData = {"#", "$%^&", "5%", "number", "5@", "44!"};
        try {
            DataFilter.filterIntStringsWithStream(incorrectData);
            fail("Test filterIntStringsWithStream for incorrect data should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Correct data is not found", e.getMessage());
        }
    }
}