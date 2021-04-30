package test.kotov.array.reader;

import com.kotov.array.exception.ArrayException;
import com.kotov.array.reader.DataReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

public class DataReaderTest {
    DataReader reader;

    @BeforeClass
    public void setUpReader() {
        reader = new DataReader();
    }

    @BeforeGroups(groups = "mainGroup")
    public void setUpGroupReader() {
        reader = new DataReader();
    }

    @Test(groups = "mainGroup")
    public void testRead() throws ArrayException {
        String actual = reader.read(String.join(File.separator, "test_resources", "testArray.txt"));
        String expected = "1 2 -10 # $%^& 5 22 83 5% number -10 -6 0 yyyy 5@ 44! 6 ";
        assertEquals(actual, expected, "Test failed as file reading algorithm is not correct");
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testReadExceptionWithNull() throws ArrayException {
        reader.read(null);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testReadExceptionWithInvalidFilePath() throws ArrayException {
        String invalidPathToFile = reader.read(String.join(File.separator, "test_resources", "nonexistentFile.txt"));
        reader.read(invalidPathToFile);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testReadExceptionWithEmptyFile() throws ArrayException {
        String pathToEmptyFile = reader.read(String.join(File.separator, "test_resources", "emptyFile.txt"));
        reader.read(pathToEmptyFile);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testReadExceptionWithDirectory() throws ArrayException {
        String pathToDirectory = reader.read(String.join(File.separator, "test_resources", "testDirectory"));
        reader.read(pathToDirectory);
    }
}