package utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Listener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(Listener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test failed.");
        saveScreenshot(Selenide.screenshot(OutputType.BYTES));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test succeed.");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
