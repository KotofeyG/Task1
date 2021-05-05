package test.kotov.array.service;

import com.kotov.array.entity.CustomArray;
import com.kotov.array.exception.ArrayException;
import com.kotov.array.service.ArraySortService;
import com.kotov.array.service.impl.ArraySortServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ArraySortServiceTest {
    private CustomArray array;
    private ArraySortService service;

    @BeforeClass
    public void setUpArrayAndSortService() {
        array = new CustomArray();
        service = new ArraySortServiceImpl();
    }

    @BeforeGroups(groups = "mainGroup")
    public void setUpGroupArrayAndSortService() {
        array = new CustomArray();
        service = new ArraySortServiceImpl();
    }

    @Test(priority = 5, groups = "mainGroup")
    public void testStreamSort() throws ArrayException {
        int[] testNumbers = {1, 2, -10, 5, 22, 83, -10, -6, 0, 6};
        array.setArray(testNumbers);
        service.streamSort(array);
        int[] actual = array.getArray();
        int[] expected = {-10, -10, -6, 0, 1, 2, 5, 6, 22, 83};
        assertEquals(actual, expected, "Test failed as logic of quick sort is not built correctly");
    }

    @Test
    public void testStreamSortWithArrayLengthLessThanTwo() throws ArrayException {
        int[] empty = {};
        array.setArray(empty);
        service.streamSort(array);
        int[] actual = array.getArray();
        int[] expected = {};
        assertEquals(actual, expected);
    }

    @Test(expectedExceptionsMessageRegExp = "Argument contains null")
    public void testStreamSortException() {
        try {
            service.streamSort(null);
            fail("Test streamSort method for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument contains null", e.getMessage());
        }
    }

    @Test(priority = 5, groups = "mainGroup")
    public void testSelectionSort() throws ArrayException {
        int[] testNumbers = {1, 2, -10, 5, 22, 83, -10, -6, 0, 6};
        array.setArray(testNumbers);
        service.selectionSort(array);
        int[] actual = array.getArray();
        int[] expected = {-10, -10, -6, 0, 1, 2, 5, 6, 22, 83};
        assertEquals(actual, expected, "Test failed as logic of selection sort is not built correctly");
    }

    @Test
    public void testSelectionSortWithArrayLengthLessThanTwo() throws ArrayException {
        int[] empty = {};
        array.setArray(empty);
        service.selectionSort(array);
        int[] actual = array.getArray();
        int[] expected = {};
        assertEquals(actual, expected);
    }

    @Test(expectedExceptionsMessageRegExp = "Argument contains null")
    public void testSelectionSortException() {
        try {
            service.selectionSort(null);
            fail("Test selectionSort method for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument contains null", e.getMessage());
        }
    }

    @Test(priority = 5, groups = "mainGroup")
    public void testInsertionSort() throws ArrayException {
        int[] testNumbers = {1, 2, -10, 5, 22, 83, -10, -6, 0, 6};
        array.setArray(testNumbers);
        service.insertionSort(array);
        int[] actual = array.getArray();
        int[] expected = {-10, -10, -6, 0, 1, 2, 5, 6, 22, 83};
        assertEquals(actual, expected, "Test failed as logic of insertion sort is not built correctly");
    }

    @Test
    public void testInsertionSortWithArrayLengthLessThanTwo() throws ArrayException {
        int[] empty = {};
        array.setArray(empty);
        service.insertionSort(array);
        int[] actual = array.getArray();
        int[] expected = {};
        assertEquals(actual, expected);
    }

    @Test(expectedExceptionsMessageRegExp = "Argument contains null")
    public void testInsertionSortException() {
        try {
            service.insertionSort(null);
            fail("Test insertionSort method for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument contains null", e.getMessage());
        }
    }

    @Test(priority = 5, groups = "mainGroup")
    public void testQuickSort() throws ArrayException {
        int[] testNumbers = {1, 2, -10, 5, 22, 83, -10, -6, 0, 6};
        array.setArray(testNumbers);
        service.quickSort(array);
        int[] actual = array.getArray();
        int[] expected = {-10, -10, -6, 0, 1, 2, 5, 6, 22, 83};
        assertEquals(actual, expected, "Test failed as logic of quick sort is not built correctly");
    }

    @Test
    public void testQuickSortWithArrayLengthLessThanTwo() throws ArrayException {
        int[] empty = {};
        array.setArray(empty);
        service.quickSort(array);
        int[] actual = array.getArray();
        int[] expected = {};
        assertEquals(actual, expected);
    }

    @Test(expectedExceptionsMessageRegExp = "Argument contains null")
    public void testQuickSortException() {
        try {
            service.quickSort(null);
            fail("Test quickSort method for null should have thrown ArrayException");
        } catch (ArrayException e) {
            assertEquals("Argument contains null", e.getMessage());
        }
    }
}