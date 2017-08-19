package tests.utils;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

/**
 * Created by sergey on 19.08.17.
 */
public class Screenshotter implements ITestListener {
  @Override
  public void onTestStart(ITestResult result) {

  }

  @Override
  public void onTestSuccess(ITestResult result) {

  }

  @Override
  public void onTestFailure(ITestResult result) {
    attachScreenshot();
  }

  @Override
  public void onTestSkipped(ITestResult result) {

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

  }

  @Override
  public void onStart(ITestContext context) {

  }

  @Override
  public void onFinish(ITestContext context) {

  }

  @Attachment(value = "Screenshot", type = "image/png")
  public byte[] attachScreenshot() {
    try {
      return Files.toByteArray(Screenshots.takeScreenShotAsFile());
    } catch (IOException e) {
      e.printStackTrace();
      return new byte[0];
    }
  }
}
