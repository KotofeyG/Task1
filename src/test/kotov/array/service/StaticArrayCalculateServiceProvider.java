package test.kotov.array.service;

import com.kotov.array.entity.CustomArray;
import com.kotov.array.service.impl.ArrayCalculateServiceImpl;
import com.kotov.array.service.impl.ArrayStreamCalculateServiceImpl;
import org.testng.annotations.DataProvider;

public class StaticArrayCalculateServiceProvider {
    @DataProvider(name = "positiveScript")
    public static Object[][] createService() {
        ArrayCalculateServiceImpl calculateService = new ArrayCalculateServiceImpl();
        ArrayStreamCalculateServiceImpl streamCalculateService = new ArrayStreamCalculateServiceImpl();
        int[] testNumbers = {1, 2, -10, 5, 22, 83, -10, -6, 0, 6};
        return new Object[][]{
                {calculateService, testNumbers},
                {streamCalculateService, testNumbers}
        };
    }

    @DataProvider(name = "nullScript")
    public static Object[][] createServiceWithNull() {
        ArrayCalculateServiceImpl calculateService = new ArrayCalculateServiceImpl();
        ArrayStreamCalculateServiceImpl streamCalculateService = new ArrayStreamCalculateServiceImpl();
        CustomArray nullArray = null;
        return new Object[][]{
                {calculateService, nullArray},
                {streamCalculateService, nullArray}
        };
    }

    @DataProvider(name = "emptyArrayScript")
    public static Object[][] createServiceWithEmptyArray() {
        ArrayCalculateServiceImpl calculateService = new ArrayCalculateServiceImpl();
        ArrayStreamCalculateServiceImpl streamCalculateService = new ArrayStreamCalculateServiceImpl();
        int[] emptyArray = {};
        return new Object[][]{
                {calculateService, emptyArray},
                {streamCalculateService, emptyArray}
        };
    }
}