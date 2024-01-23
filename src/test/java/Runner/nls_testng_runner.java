package Runner;
import org.testng.annotations.Listeners;

import TestNGListeners.CucumberExtentReportListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import testnglisteners.CucumberExtentReportListener;

@CucumberOptions(
        features = {"C:\\Users\\Sai\\eclipse-workspace\\RLL\\Demo_Web_Shop\\src\\test\\java\\Features\\subscriptionofnewsletter.feature",
                    },
        glue = {"Steps" },
        dryRun = false,
        plugin = {
            "pretty",
            "html:targettestng/cucumberreport_newslettersubscription.html",
            "json:targettestng/cucumber.json",
            "junit:targettestng/xmlReport.xml",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:\", \"timeline:test-output-thread/"
            
          
        },
        monochrome=true
)

@Listeners(CucumberExtentReportListener.class)
public class nls_testng_runner extends AbstractTestNGCucumberTests {
}