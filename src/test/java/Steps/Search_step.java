package Steps;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.Xls_DataProvider_search;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.ECommercePage_search;



public class Search_step {

	private WebDriver driver;
	private  ECommercePage_search Page_search;
	private  ExtentReports extentReports;
	private  ExtentTest extentTest;
	Logger logger = LogManager.getLogger(Search_step.class);
	
	

   

	
	@Before("@SearchTest")
	public void setUp() {
		logger.info("Setting up WebDriver and Page_search.");
		
		driver = new ChromeDriver();
//		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/SparkReport/customized_search.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter); 
		Page_search = new ECommercePage_search(driver);
	
	 
	}
	 
	 
	@Given("the user is on the search page")
	public void userIsOnSearchPage() {
		extentTest = extentReports.createTest("Navigate to URL");
		logger.info("Navigating to the search page.");
		
		
		Page_search.navigateToURL("http://demowebshop.tricentis.com");
		
		 Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "User is not on the search tab");
	}

	@When("the user clicks the search button")
	public void userClicksSearchButton() throws InterruptedException {
		logger.info("Clicking the search button.");
		Page_search.searchbtn();
		Thread.sleep(2000);
	}

	@Then("the user dismisses the pop-up")
	public void userDismissesPopup() {
		logger.info("Dismissing the pop-up.");
		 extentTest = extentReports.createTest("Search Results Pop up validation");
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.dismiss();
      
	}
	
	

	@When("the user performs a search with data from Excel sheet {string}")
	public void userPerformsSearchWithDataFromExcel(String search_term) throws IOException, InterruptedException {
		
		
		String sheetName = "Sheet1"; // Specify the sheet name from your Excel file
		String[] searchTerms = Xls_DataProvider_search.getSearchData(sheetName);
		logger.info("Search terms from Excel sheet: " + Arrays.toString(searchTerms));
		System.out.println("Search terms from Excel sheet: " + Arrays.toString(searchTerms));
		for (String currentterm : searchTerms) {
			Page_search.search_placeholder(currentterm); // Here, you pass the data to the method
			validateSearchResults(currentterm);

		}
	}
	

	@Test
	@Then("the search results should be displayed for {string}")
	public void validateSearchResults(String search_term) throws IOException{
		int retryCount = 0;
	    int maxRetryCount = 2;
		
		By noResultsMessage = By.xpath("//strong[@class='result' and contains(text(), 'No products were found')]");
	
		
		boolean isNoResultsMessageDisplayed = driver.findElements(noResultsMessage).size() > 0;
		
		while (retryCount < maxRetryCount) {
		try {
			if (isNoResultsMessageDisplayed) {
		        // Test fails if the "No products were found" message is displayed
				extentTest = extentReports.createTest("Search Results Validation - " + search_term);
				
				Assert.fail("No result displayed for "+search_term);
				 
		    }
		
			
			 else {
				 
				 
					extentTest = extentReports.createTest("Search Results Validation - " + search_term);
					extentTest.pass("Search results displayed for: " + search_term);

					logger.info("Search results displayed for: " + search_term);
					System.out.println("Search results displayed for: " + search_term);
					return;   // Break out of retry loop if successful

			
			 }
		}
		
		 catch (AssertionError e) {
			// Log the failure message without rethrowing the exception
			extentTest.fail("Assertion failed for search term: " + search_term + ". Error message: " + e.getMessage());
		
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			String screenshotName = "Failure" + search_term + "_" + System.currentTimeMillis() + ".png";
			FileUtils.copyFile(screenshot, new File("./Screenshots_search/" + screenshotName));

			extentTest.addScreenCaptureFromPath("C:\\Users\\Sai\\eclipse-workspace\\RLL\\Demo_Web_Shop\\Screenshots_search\\" + screenshotName);


			System.out.println("Screenshot captured: " + screenshotName);
			logger.error("Screenshot captured: " + screenshotName);
			
		
		
		}
		retryCount++;
        logger.info("Retrying search validation for: " + search_term + ". Attempt: " + retryCount);
        try {
            Thread.sleep(1000); // Adjust sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		}
		 extentTest.fail("Search validation failed after " + maxRetryCount + " attempts for: " + search_term);
	}
        
	
	@After("@SearchTest")
	public void afterScenario() {
	    try {
	        logger.info("Scenario completed.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        extentReports.flush();
	        if (driver != null) {
	            driver.close();
	        }
	    }
	

	}
}
