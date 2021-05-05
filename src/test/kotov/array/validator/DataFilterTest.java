package test.kotov.array.validator;

import com.kotov.array.validator.DataFilter;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;

public class DataFilterTest {
    @Test
    public void testFilterIntStrings() {
        String[] data = {"1", "2", "-10", "#", "$%^&", "5", "22", "5%", "number", "-10", "-6", "0", "5@", "44!", "6"};
        String[] actual = DataFilter.filterIntStrings(data).get();
        String[] expected = {"1", "2", "-10", "5", "22", "-10", "-6", "0", "6"};
        assertEquals(actual, expected, "Test failed as logic of DataFilter is not built correctly");
    }

    @Test
    public void testFilterIntStringsExceptionWithNull() {
        Optional<String[]> actual = DataFilter.filterIntStrings(null);
        Optional<String[]> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testFilterIntStringsExceptionWithEmptyArray() {
        String[] emptyArray = {};
        Optional<String[]> actual = DataFilter.filterIntStrings(emptyArray);
        Optional<String[]> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testFilterIntStringsExceptionWithIncorrectData() {
        String[] incorrectData = {"#", "$%^&", "5%", "number", "5@", "44!"};
        Optional<String[]> actual = DataFilter.filterIntStrings(incorrectData);
        Optional<String[]> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testFilterIntStringsWithStream() {
        String[] data = {"1", "2", "-10", "#", "$%^&", "5", "22", "5%", "number", "-10", "-6", "0", "5@", "44!", "6"};
        String[] actual = DataFilter.filterIntStrings(data).get();
        String[] expected = {"1", "2", "-10", "5", "22", "-10", "-6", "0", "6"};
        assertEquals(actual, expected, "Test failed as logic of DataFilter is not built correctly");
    }

    @Test
    public void testFilterIntStringsWithStreamWithNull() {
        Optional<String[]> actual = DataFilter.filterIntStrings(null);
        Optional<String[]> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testFilterIntStringsWithStreamExceptionWithEmptyArray() {
        String[] emptyArray = {};
        Optional<String[]> actual = DataFilter.filterIntStrings(emptyArray);
        Optional<String[]> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void testFilterIntStringsWithStreamExceptionWithIncorrectData() {
        String[] incorrectData = {"#", "$%^&", "5%", "number", "5@", "44!"};
        Optional<String[]> actual = DataFilter.filterIntStrings(incorrectData);
        Optional<String[]> expected = Optional.empty();
        assertEquals(actual, expected);
    }
}