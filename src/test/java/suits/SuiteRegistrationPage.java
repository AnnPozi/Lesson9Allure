package suits;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import registrationTests.RegistrationTest;

@RunWith(Suite.class)

@Suite.SuiteClasses(
        {
                RegistrationTest.class,
                RegistrationTest.class
        }
)

public class SuiteRegistrationPage {
}
