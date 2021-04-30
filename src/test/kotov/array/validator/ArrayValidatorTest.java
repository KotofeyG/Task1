package test.kotov.array.validator;

import com.kotov.array.entity.CustomArray;
import com.kotov.array.exception.ArrayException;
import com.kotov.array.validator.ArrayValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class ArrayValidatorTest {
    @Test
    public void testIsValidForCustomArrayWithNull() {
        boolean condition = ArrayValidator.isValid(null);
        assertFalse(condition);
    }

    @Test
    public void testIsValidForCustomArrayWithEmptyArray() throws ArrayException {
        int[] empty = {};
        CustomArray array = new CustomArray(empty);
        boolean condition = ArrayValidator.isValid(array);
        assertFalse(condition);
    }
}