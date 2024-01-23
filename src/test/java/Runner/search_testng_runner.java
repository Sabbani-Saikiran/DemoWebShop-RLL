package Runner;

import org.testng.annotations.Listeners;

import TestNGListeners.CucumberExtentReportListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\Sai\\eclipse-workspace\\RLL\\Demo_Web_Shop\\src\\test\\java\\Features\\search.feature"},
        glue = {"Steps"},
        dryRun = false,
        tags="@SearchTest",
        plugin = {
                "pretty",
                "html:targettestng/cucumberreport_search.html",
                "json:targettestng/cucumber.json",
                "junit:targettestng/xmlReport.xml"
        },
        monochrome = true
)
@Listeners(CucumberExtentReportListener.class)
public class search_testng_runner extends AbstractTestNGCucumberTests {
}
