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
    public void testParseIntoIntStrings() throws ArrayException {
        String data = "1 2 -10 # $%^& 5 22 83 5% number -10 -6 0 yyyy 5@ 44! 6";
        String[] actual = parser.parseIntoIntStrings(data);
        String[] expected = {"1", "2", "-10", "5", "22", "83", "-10", "-6", "0", "6"};
        assertEquals(actual, expected, "Test failed as logic of parseIntoIntStrings is not built correctly");
    }

    @Test(expectedExceptionsMessageRegExp = "Data is invalid. Argument is null or empty")
    public void testParseIntoIntStringsExceptionWithNull() {
        try {
            parser.parseIntoIntStrings(null);
            fail("Test parseIntoIntStrings for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Data is invalid. Argument is null or empty", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Data is invalid. Argument is null or empty")
    public void testParseIntoIntStringsExceptionWithEmptyArgument() {
        String empty = "";
        try {
            parser.parseIntoIntStrings(empty);
            fail("Test parseIntoIntStrings for empty array should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Data is invalid. Argument is null or empty", e.getMessage());
        }
    }

    @Test(expectedExceptionsMessageRegExp = "Correct data is not found")
    public void testParseIntoIntStringsExceptionWithIncorrectData() {
        String incorrectData = "@1 !2 $-10 # $%^& 5g 2%2 83? 5% number -10^ -/6 0e yyyy 5@ 44! 6<";
        try {
            parser.parseIntoIntStrings(incorrectData);
            fail("Test parseIntoIntStrings for incorrect data should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Correct data is not found", e.getMessage());
        }
    }

    @Test(priority = 2, groups = "mainGroup")
    public void testTransformStringArrayIntoIntArray() throws ArrayException {
        String[] numericStrings = {"1", "2", "-10", "5", "22", "83", "-10", "-6", "0", "6"};
        int[] actual = parser.transformStringArrayIntoIntArray(numericStrings);
        int[] expected = {1, 2, -10, 5, 22, 83, -10, -6, 0, 6};
        assertEquals(actual, expected, "Test failed as data is incorrectly validated");
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testTransformStringArrayIntoIntArrayExceptionWithNull() throws ArrayException {
        parser.transformStringArrayIntoIntArray(null);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testTransformStringArrayIntoIntArrayExceptionWithEmptyArray() throws ArrayException {
        String[] empty = {};
        parser.transformStringArrayIntoIntArray(empty);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testTransformStringArrayIntoIntArrayExceptionWithIncorrectData() throws ArrayException {
        String[] incorrectData = {"1", "2", "-10$", "5", "22", "83%", "-10", "-6", "0", "6@"};
        parser.transformStringArrayIntoIntArray(incorrectData);
    }
}