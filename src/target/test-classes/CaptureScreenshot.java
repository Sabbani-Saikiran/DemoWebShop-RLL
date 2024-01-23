package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {
    private WebDriver driver;

    public CaptureScreenshot(WebDriver driver) {
        this.driver = driver;
    }

    public String takeScreenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = "C:\\Users\\91630\\selenium_s2\\Registration\\target\\screenshots_" + System.currentTimeMillis() + ".png";
        File target = new File(path);
        FileUtils.copyFile(source, target);
        String targetPath = target.getAbsolutePath();
        return targetPath;
    }
}
