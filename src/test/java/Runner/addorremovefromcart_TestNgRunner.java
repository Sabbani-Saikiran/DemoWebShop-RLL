package Runner;

import org.testng.annotations.Listeners;

import TestNGListeners.CucumberExtentReportListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import utilities.ITestListenerClass;

@CucumberOptions(
    features = "C:\\Users\\Sai\\eclipse-workspace\\RLL\\Demo_Web_Shop\\src\\test\\java\\Features\\addtocart.feature",
    glue = { "Steps" },
    plugin = {
        "html:targettestng/Demowebshop_addtocart_report.html",
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output-thread/"
    }
    // Add tags option if needed: tags = "@yourTag"
)
@Listeners(CucumberExtentReportListener.class)
public class addorremovefromcart_TestNgRunner extends AbstractTestNGCucumberTests {

    // A cucumber runner file is used to build a communication between your feature
    // files and step definition file
    // Whenever we have to run multiple features or multiple steps, then we use
    // Cucumber runner file.
    // Whenever have to generate reports, we will use the cucumber runner file
}


