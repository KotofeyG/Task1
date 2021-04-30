package test.kotov.array.creator;

import com.kotov.array.creator.ArrayCreator;
import com.kotov.array.entity.CustomArray;
import com.kotov.array.exception.ArrayException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCreatorTest {
    @Test(priority = 3, groups = "mainGroup")
    public void testCreateCustomArray() throws ArrayException {
        ArrayCreator creator = new ArrayCreator();
        int[] numbers = {1, 2, -10, 5, 22, 83, -10, -6, 0, 6};
        CustomArray actual = creator.createCustomArray(numbers);
        CustomArray expected = new CustomArray(numbers);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptionsMessageRegExp = "CustomArray cannot be created. Argument contains null")
    public void testCreateCustomArrayException() {
        ArrayCreator creator = new ArrayCreator();
        try {
            creator.createCustomArray(null);
            fail("Test createCustomArray for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("CustomArray cannot be created. Argument contains null", e.getMessage());
        }
    }
}