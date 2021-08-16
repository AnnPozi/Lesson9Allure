//package junitTests;
//
//
//
//import java.time.Duration;
//
//import static com.google.common.math.LongMath.isPrime;
//
//
//
//public class Junit5Test {
//
//    @RegisterExtension
//    public String sasd = "";
//
//    @BeforeAll
//    public static void beforeClass() {
//        System.out.println("Before class junit");
//    }
//
//    @AfterAll
//    public static void afterClass() {
//        System.out.println("After class junit");
//    }
//
//    @BeforeEach
//    public void before() {
//        System.out.println("Before junit");
//    }
//
//    @AfterEach
//    public void after() {
//        System.out.println("After junit");
//    }
//
//    //@ExtendWith(RandomParams.class)
//    @Test
//    public void test() {
//        System.out.println("test");
//        Assertions.assertTimeout(Duration.ofMillis(1), () -> Thread.sleep(10));
//    }
//
//    @Test
//    public void test2() {
//        System.out.println("test2");
//        Assertions.assertAll(
//                () -> assertTrue(isPrime(2)),
//                () -> assertFalse(isPrime(4))
//        );
////
////        Assertions.assertTrue(isPrime(2));
////        Assertions.assertFalse(isPrime(4));
//    }
//}
