package test.kotov.array.service;

import com.kotov.array.entity.CustomArray;
import com.kotov.array.exception.ArrayException;
import com.kotov.array.service.ArrayCalculateService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCalculateServiceTest {
    private CustomArray array;

    @BeforeClass
    public void setUpArray() {
        array = new CustomArray();
    }

    @BeforeGroups(groups = "mainGroup")
    public void setUpGroupArray() {
        array = new CustomArray();
    }

    @Test(priority = 4, groups = "mainGroup", dataProvider = "positiveScript"
            , dataProviderClass = ArrayCalculateServiceProvider.class)
    public void testChangePrimeNumbersToZero(ArrayCalculateService service, int[] testNumbers) throws ArrayException {
        array.setArray(testNumbers);
        service.changePrimeNumbersToZero(array);
        int[] actual = array.getArray();
        int[] expected = {1, 0, -10, 0, 22, 0, -10, -6, 0, 6};
        assertEquals(actual, expected, "Test failed as logic of changePrimeNumbersToZero is not built correctly");
    }

    @Test(dataProvider = "emptyArrayScript", dataProviderClass = ArrayCalculateServiceProvider.class)
    public void testChangePrimeNumbersToZeroWithEmptyArray(ArrayCalculateService service, int[] emptyArray)
            throws ArrayException {
        array.setArray(emptyArray);
        service.changePrimeNumbersToZero(array);
        int[] actual = array.getArray();
        int[] expected = {};
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "nullScript", dataProviderClass = ArrayCalculateServiceProvider.class
            , expectedExceptionsMessageRegExp = "Argument contains null")
    public void testChangePrimeNumbersToZeroException(ArrayCalculateService service, CustomArray nullArray) {
        try {
            service.changePrimeNumbersToZero(nullArray);
            fail("Test changePrimeNumbersToZero for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument contains null", e.getMessage());
        }
    }

    @Test(priority = 4, groups = "mainGroup", dataProvider = "positiveScript"
            , dataProviderClass = ArrayCalculateServiceProvider.class)
    public void testCalculateArithmeticMean(ArrayCalculateService service, int[] testNumbers) throws ArrayException {
        array.setArray(testNumbers);
        double actual = service.calculateArithmeticMean(array);
        double expected = 9.3;
        assertEquals(actual, expected, 0.001, "Test failed as logic of calculateArithmeticMean is not built correctly");
    }

    @Test(dataProvider = "emptyArrayScript", dataProviderClass = ArrayCalculateServiceProvider.class
            , expectedExceptionsMessageRegExp = "Argument is empty or null")
    public void testCalculateArithmeticMeanExceptionWithEmptyArray(ArrayCalculateService service, int[] emptyArray) {
        try {
            array.setArray(emptyArray);
            service.calculateArithmeticMean(array);
            fail("Test calculateArithmeticMean for empty array should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument is empty or null", e.getMessage());
        }
    }

    @Test(dataProvider = "nullScript", dataProviderClass = ArrayCalculateServiceProvider.class
            , expectedExceptionsMessageRegExp = "Argument is empty or null")
    public void testCalculateArithmeticMeanExceptionWithNull(ArrayCalculateService service, CustomArray nullArray) {
        try {
            service.calculateArithmeticMean(nullArray);
            fail("Test calculateArithmeticMean for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument is empty or null", e.getMessage());
        }
    }

    @Test(priority = 4, groups = "mainGroup", dataProvider = "positiveScript"
            , dataProviderClass = ArrayCalculateServiceProvider.class)
    public void testCalculateSumOfElements(ArrayCalculateService service, int[] testNumbers) throws ArrayException {
        array.setArray(testNumbers);
        int actual = service.calculateSumOfElements(array);
        int expected = 93;
        assertEquals(actual, expected, "Test failed as logic of calculateSumOfElements is not built correctly");
    }

    @Test(dataProvider = "emptyArrayScript", dataProviderClass = ArrayCalculateServiceProvider.class
            , expectedExceptionsMessageRegExp = "Argument is empty or null")
    public void testCalculateSumOfElementsWithEmptyArray(ArrayCalculateService service, int[] emptyArray) {
        try {
            array.setArray(emptyArray);
            service.calculateSumOfElements(array);
            fail("Test calculateSumOfElements for empty array should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument is empty or null", e.getMessage());
        }
    }

    @Test(dataProvider = "nullScript", dataProviderClass = ArrayCalculateServiceProvider.class
            , expectedExceptionsMessageRegExp = "Argument is empty or null")
    public void testCalculateSumOfElementsExceptionWithNull(ArrayCalculateService service, CustomArray nullArray) {
        try {
            service.calculateSumOfElements(nullArray);
            fail("Test calculateSumOfElements for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument is empty or null", e.getMessage());
        }
    }

    @Test(priority = 4, groups = "mainGroup", dataProvider = "positiveScript"
            , dataProviderClass = ArrayCalculateServiceProvider.class)
    public void testFindMinElement(ArrayCalculateService service, int[] testNumbers) throws ArrayException {
        array.setArray(testNumbers);
        int actual = service.findMinElement(array);
        int expected = -10;
        assertEquals(actual, expected, "Test failed as logic of findMinElement is not built correctly");
    }

    @Test(dataProvider = "emptyArrayScript", dataProviderClass = ArrayCalculateServiceProvider.class
            , expectedExceptionsMessageRegExp = "Argument is empty or null")
    public void testFindMinElementExceptionWithEmptyArray(ArrayCalculateService service, int[] emptyArray) {
        try {
            array.setArray(emptyArray);
            service.findMinElement(array);
            fail("Test findMinElement for empty array should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument is empty or null", e.getMessage());
        }
    }

    @Test(dataProvider = "nullScript", dataProviderClass = ArrayCalculateServiceProvider.class
            , expectedExceptionsMessageRegExp = "Argument is empty or null")
    public void testFindMinElementExceptionWithNull(ArrayCalculateService service, CustomArray nullArray) {
        try {
            service.findMinElement(nullArray);
            fail("Test findMinElement for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument is empty or null", e.getMessage());
        }
    }

    @Test(priority = 4, groups = "mainGroup", dataProvider = "positiveScript"
            , dataProviderClass = ArrayCalculateServiceProvider.class)
    public void testFindMaxElement(ArrayCalculateService service, int[] testNumbers) throws ArrayException {
        array.setArray(testNumbers);
        int actual = service.findMaxElement(array);
        int expected = 83;
        assertEquals(actual, expected, "Test failed as logic of findMaxElement is not built correctly");
    }

    @Test(dataProvider = "emptyArrayScript", dataProviderClass = ArrayCalculateServiceProvider.class
            , expectedExceptionsMessageRegExp = "Argument is empty or null")
    public void testFindMaxElementExceptionWithEmptyArray(ArrayCalculateService service, int[] emptyArray) {
        try {
            array.setArray(emptyArray);
            service.findMaxElement(array);
            fail("Test findMaxElement for empty array should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument is empty or null", e.getMessage());
        }

    }

    @Test(dataProvider = "nullScript", dataProviderClass = ArrayCalculateServiceProvider.class
            , expectedExceptionsMessageRegExp = "Argument is empty or null")
    public void testFindMaxElementExceptionWithNull(ArrayCalculateService service, CustomArray nullArray) {
        try {
            service.findMaxElement(nullArray);
            fail("Test findMaxElement for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument is empty or null", e.getMessage());
        }
    }

    @Test(priority = 4, groups = "mainGroup", dataProvider = "positiveScript"
            , dataProviderClass = ArrayCalculateServiceProvider.class)
    public void testCalculateQuantityOfPositiveElements(ArrayCalculateService service, int[] testNumbers)
            throws ArrayException {
        array.setArray(testNumbers);
        int actual = service.calculateQuantityOfPositiveElements(array);
        int expected = 6;
        assertEquals(actual, expected
                , "Test failed as logic of calculateQuantityOfPositiveElements is not built correctly");
    }

    @Test(dataProvider = "emptyArrayScript", dataProviderClass = ArrayCalculateServiceProvider.class)
    public void testCalculateQuantityOfPositiveElementsWithEmptyArray(ArrayCalculateService service, int[] emptyArray)
            throws ArrayException {
        array.setArray(emptyArray);
        int actual = service.calculateQuantityOfPositiveElements(array);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "nullScript", dataProviderClass = ArrayCalculateServiceProvider.class
            , expectedExceptionsMessageRegExp = "Argument contains null")
    public void testCalculateQuantityOfPositiveElementsExceptionWithNull(ArrayCalculateService service
            , CustomArray nullArray) {
        try {
            service.calculateQuantityOfPositiveElements(nullArray);
            fail("Test calculateQuantityOfPositiveElements for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument contains null", e.getMessage());
        }
    }

    @Test(priority = 4, groups = "mainGroup", dataProvider = "positiveScript"
            , dataProviderClass = ArrayCalculateServiceProvider.class)
    public void testCalculateQuantityOfNegativeElements(ArrayCalculateService service, int[] testNumbers)
            throws ArrayException {
        array.setArray(testNumbers);
        int actual = service.calculateQuantityOfNegativeElements(array);
        int expected = 3;
        assertEquals(actual, expected
                , "Test failed as logic of calculateQuantityOfNegativeElements is not built correctly");
    }

    @Test(dataProvider = "emptyArrayScript", dataProviderClass = ArrayCalculateServiceProvider.class)
    public void testCalculateQuantityOfNegativeElementsWithEmptyArray(ArrayCalculateService service, int[] emptyArray)
            throws ArrayException {
        array.setArray(emptyArray);
        int actual = service.calculateQuantityOfNegativeElements(array);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "nullScript", dataProviderClass = ArrayCalculateServiceProvider.class
            , expectedExceptionsMessageRegExp = "Argument contains null")
    public void testCalculateQuantityOfNegativeElementsExceptionWithNull(ArrayCalculateService service
            , CustomArray nullArray) {
        try {
            service.calculateQuantityOfNegativeElements(nullArray);
            fail("Test calculateQuantityOfNegativeElements for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument contains null", e.getMessage());
        }
    }
}