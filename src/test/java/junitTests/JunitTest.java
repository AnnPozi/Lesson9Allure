package junitTests;

import org.junit.*;

public class JunitTest {

    @Rule
    public final String txs = "";

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class junit");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class junit");
    }

    @Before
    public void before() {
        System.out.println("Before junit");
    }

    @After
    public void after() {
        System.out.println("After junit");
    }

    @Test
    public void test() {
        System.out.println("test");
        Assert.assertEquals("Text", "text", "text");
    }

        @Test(timeout = 1000)
//    @Test(expected = NoSuchElementException.class)
//    @Ignore
    public void test2() {
        System.out.println("test2");
        Assert.assertEquals("text", "text", "text");
    }
}
