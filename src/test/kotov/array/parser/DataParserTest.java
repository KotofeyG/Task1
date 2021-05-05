package test.kotov.array.parser;

import com.kotov.array.exception.ArrayException;
import com.kotov.array.parser.DataParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataParserTest {
    DataParser parser;

    @BeforeClass
    public void setUpParser() {
        parser = new DataParser();
    }

    @BeforeGroups(groups = "mainGroup")
    public void setUpGroupParser() {
        parser = new DataParser();
    }

    @Test(priority = 1, groups = "mainGroup")
    public void testParseDataIntoNumericStrings() throws ArrayException {
        String data = "1 2 -10 # $%^& 5 22 83 5% number -10 -6 0 yyyy 5@ 44! 6";
        String[] actual = parser.parseDataIntoNumericStrings(data);
        String[] expected = {"1", "2", "-10", "5", "22", "83", "-10", "-6", "0", "6"};
        assertEquals(actual, expected, "Test failed as logic of parseIntoIntStrings is not built correctly");
    }

    @Test(expectedExceptionsMessageRegExp = "Data is invalid. Argument is null or empty")
    public void testParseDataIntoNumericStringsExceptionWithNull() {
        try {
            parser.parseDataIntoNumericStrings(null);
            fail("Test parseDataIntoNumericStrings method for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Data is invalid. Argument is null or empty", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Data is invalid. Argument is null or empty")
    public void testParseDataIntoNumericStringsExceptionWithEmptyArgument() {
        String empty = "";
        try {
            parser.parseDataIntoNumericStrings(empty);
            fail("Test parseDataIntoNumericStrings method for empty array should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Data is invalid. Argument is null or empty", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Correct data is not found")
    public void testParseDataIntoNumericStringsExceptionWithIncorrectData() {
        String incorrectData = "@1 !2 $-10 # $%^& 5g 2%2 83? 5% number -10^ -/6 0e yyyy 5@ 44! 6<";
        try {
            parser.parseDataIntoNumericStrings(incorrectData);
            fail("Test parseDataIntoNumericStrings method for incorrect data should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Correct data is not found", e.getMessage());
        }
    }

    @Test(priority = 2, groups = "mainGroup")
    public void testTransformNumericStringArrayIntoIntArray() throws ArrayException {
        String[] numericStrings = {"1", "2", "-10", "5", "22", "83", "-10", "-6", "0", "6"};
        int[] actual = parser.transformNumericStringArrayIntoIntArray(numericStrings);
        int[] expected = {1, 2, -10, 5, 22, 83, -10, -6, 0, 6};
        assertEquals(actual, expected, "Test failed as data is incorrectly validated");
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testTransformNumericStringArrayIntoIntArrayExceptionWithNull() throws ArrayException {
        parser.transformNumericStringArrayIntoIntArray(null);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testTransformNumericStringArrayIntoIntArrayExceptionWithEmptyArray() throws ArrayException {
        String[] empty = {};
        parser.transformNumericStringArrayIntoIntArray(empty);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testTransformNumericStringArrayIntoIntArrayExceptionWithIncorrectData() throws ArrayException {
        String[] incorrectData = {"1", "2", "-10$", "5", "22", "83%", "-10", "-6", "0", "6@"};
        parser.transformNumericStringArrayIntoIntArray(incorrectData);
    }
}