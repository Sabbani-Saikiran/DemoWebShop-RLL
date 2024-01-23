package Steps;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import Pages.CommPoll;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class CommunitypollStepdef {
	WebDriver driver;
	CommPoll Cmp;

	private static Logger logger = LogManager.getLogger(CommunitypollStepdef.class);

	public CommunitypollStepdef() {
		driver = new ChromeDriver();
		Cmp = new CommPoll(driver);
	}

	@Given("User navigate to Url")

	public void user_navigate_to_url() {
		logger.info("URL");
		Cmp.navigateToURL("https://demowebshop.tricentis.com/");

	}

	@Then("User performs Login")
	public void user_performs_login() {

		logger.info("Users performs to the Login");
		Cmp.Click_Login();
		Cmp.Login_details("aa222@gmail.com", "123456");

	}

	@Then("User select one option from poll and vote")
	public void user_select_one_option_from_poll_and_vote() throws InterruptedException {
		logger.info("Users select one option from poll");

		try {
			{

				Cmp.select_button();

				Cmp.Click_Vote();
			}
		} catch (Exception e) {
			
			WebElement optionElement = driver.findElement(By.xpath("//span[@class='poll-total-votes']"));
			String actualvalue = Cmp.Tol_Result();

			if (optionElement.isDisplayed())

			System.out.println("user already votedd..");
			System.out.println(Cmp.Pol_Result());
			System.out.println(Cmp.Tol_Result());
			captureScreenshot(driver, "Fail1.png");
			Assert.assertFalse(actualvalue, true);

		}

	}

	@Then("User select one option from given poll")
	public void user_select_one_option_from_given_poll() {
		logger.info("Users selects the poll  ");
		Cmp.select_button();

	}

	@SuppressWarnings("deprecation")
	@Then("Click on vote button")
	public void click_on_vote_button() throws InterruptedException {
		logger.info("User Click on the vote button");
		Cmp.Click_Vote();
		Thread.sleep(1000);
		captureScreenshot(driver, "Fail2.png");
		Assert.assertFalse("Only registered users can vote.", true);
		System.out.println("Only login can vote");

	}

	@Then("Click on vote button directly")
	public void click_on_vote_button_directly() throws InterruptedException {
		logger.info("Users direct click on vote button");
		Cmp.Click_Vote();
		// Assert.assertFalse("Please select an answer", true);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.dismiss();

		// captureScreenshot(driver, "Fail3.png");

	}

	private static void captureScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		//File destinationFile = new File(fileName);
		File destinationFile = new File("C:\\Users\\Sai\\eclipse-workspace\\RLL\\Demo_Web_Shop\\ScreenShots_poll\\" +fileName);
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			//Files.copy(sourceFile.toPath(), destinationFile.toPath());
			System.out.println("Screenshot captured: " + destinationFile);
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot: " + e.getMessage());
		}
	}

	@io.cucumber.java.After
	public void afterScenario(io.cucumber.java.Scenario scenario) {
	/*	if (scenario.isFailed()) {
			logger.error("Scenario failed. Taking a screenshot or performing cleanup if needed.");
			// Add code to capture a screenshot or perform cleanup on failure*/
		
		driver.quit();
		}
		
	

}
