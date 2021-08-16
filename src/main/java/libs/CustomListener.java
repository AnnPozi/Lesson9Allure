package libs;


import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter {

    public CustomListener() {
    }

    public void onTestStart(ITestListener result) {
        /*code*/
    }

    public void onTestSuccess(ITestListener result) {
        /*code*/
    }

    public void onTestFailure(ITestListener result) {
        /*code*/
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] screenshot() {
        /*code*/
        return new byte[0];
    }
}
