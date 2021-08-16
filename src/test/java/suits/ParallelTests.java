package suits;


import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.testng.annotations.Test;
import registrationTests.RegistrationTest;

public class ParallelTests {

    @Test
    public void runAllTests() {
        Class<?>[] classes =
                {
                        RegistrationTest.class
                };
        // ParallelComputer(true,true) will run all classes and methods
        // in parallel.  (First arg for classes, second arg for methods)
        JUnitCore.runClasses(new ParallelComputer(true, true), classes);
    }
}
