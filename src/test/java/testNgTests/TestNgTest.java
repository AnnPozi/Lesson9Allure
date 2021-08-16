package testNgTests;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class testNG");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class testNG");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod testNG");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod testNG");
    }

    //    @DataProvider
//    @Test(expectedExceptions = ArithmeticException.class)
    @Test(groups = "method 1")
    public void testNG() {
        System.out.println("test");
        Assert.assertEquals("res", "res");
    }
}
