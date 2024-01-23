package Steps;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import Pages.subscriptionofnewsletter_page;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import base.BasePage;
import io.cucumber.java.After;

//import org.junit.Assert;

//import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class subscriptionofnewsletter_stepdef {
	SoftAssert s=new SoftAssert();
	private static final Logger logger = LogManager.getLogger(subscriptionofnewsletter_stepdef.class);
	subscriptionofnewsletter_page snl = new subscriptionofnewsletter_page(BasePage.driver);

	@Given("I am on DemoWebShop Homepage launching url")
	public void i_am_on_demo_web_shop_homepage_launching_url() {
		logger.info("Navigating to the URL");
		BasePage.driver.manage().window().maximize();
		BasePage.driver.get("https://demowebshop.tricentis.com/");

	}

	@When("I click on login link")
	public void i_click_on_login_link() throws InterruptedException {
		logger.info("Clicking on login link");
		snl.Click_LoginLink();

	}

	@Then("I will be on Login Page and Capture the title of the page")
	public void i_will_be_on_login_page_and_capture_the_title_of_the_page() throws InterruptedException {
		BasePage.driver.getTitle();

		System.out.println("title of the is page is : " + BasePage.driver.getTitle());

	}

	@Then("I entered email id on the page")
	public void i_entered_email_id_on_the_page() throws InterruptedException {
		logger.info("Entering the Email id");
		//Thread.sleep(2000);
		snl.give_email("saikirandemo@gmail.com");
	}

	@Then("I entered password on the page")
	public void i_entered_password_on_the_page() throws InterruptedException {

		logger.info("Entering the Password");
		//Thread.sleep(2000);
		snl.give_password("123456");

	}

	@Then("I click on Login button")
	public void i_click_on_submit_button() throws InterruptedException {
		logger.info("Clicking on login button");
		//Thread.sleep(2000);
		snl.Click_Login();

	}

	@Then("I click on sign up for our newsletter {string}")
	public void i_click_on_sign_up_for_our_newsletter(String signup_emailid) throws InterruptedException {
		logger.info("Entering the signup mail id");
		Thread.sleep(2000);
		snl.give_signup_emailid(signup_emailid);

	}

	@Then("I click on Subscribe")
	public void i_click_on_subscribe() throws InterruptedException {
		logger.info("Clicking on Subscribe");
		Thread.sleep(2000);
		snl.Click_Signup();

	}

	@Then("i get the result block")
	public void i_get_the_result_block() throws InterruptedException, IOException {
		
		
		
		//snl.entervalidmail();
		

		//System.out.print(expectedResult);
		
		

		Thread.sleep(950);
		String actualResult = BasePage.driver.findElement(By.id("newsletter-result-block")).getText();
		
		System.out.print(actualResult);
		
		
		String expectedResult = "Thank you for signing up! A verification email has been sent. We appreciate your interest.";
		
		
	
		
		
		try {
		    Assert.assertEquals(expectedResult, actualResult);
		  
		   // s.assertAll();
		   
		}  catch (AssertionError e) {
		    // Log the failure message before logging out
		    System.out.println("Assertion failed: " + e.getMessage());
		    TakesScreenshot ts = (TakesScreenshot) BasePage.driver;
				File screenshot = ts.getScreenshotAs(OutputType.FILE);
				String screenshotName = "Failure_" + "_" + System.currentTimeMillis() + ".png";
				FileUtils.copyFile(screenshot, new File("./Screenshots_nls/" + screenshotName));
				i_logout();
		}
	}
		
		
		
	
		
		/* if (expectedResult.equals(actualResult)) {
			 Assert.assertEquals(actualResult,expectedResult);
			 
			 //s.assertEquals(expectedResult, actualResult);
			/* TakesScreenshot ts = (TakesScreenshot) BasePage.driver;
				File screenshot = ts.getScreenshotAs(OutputType.FILE);
				String screenshotName = "Failure_" + "_" + System.currentTimeMillis() + ".png";
				FileUtils.copyFile(screenshot, new File("./Screenshots/" + screenshotName));*/
				
				//i_logout(); 
		/*	 }
	  
		else {
			//System.out.println("passed");
			
        	TakesScreenshot ts = (TakesScreenshot) BasePage.driver;
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			String screenshotName = "Failure_" + "_" + System.currentTimeMillis() + ".png";
			FileUtils.copyFile(screenshot, new File("./Screenshots/" + screenshotName));
			//Assert.assertEquals(actualResult,expectedResult);
			i_logout();
			
        }
	}*/
		 
		
		
		
		
		
	
		
		
		

	

	

	@Then("I logout")
	public void i_logout() throws InterruptedException {
		logger.info("Clicking on logout");
		snl.Click_Logout();
		
			
		
		}
	
	
	 private static void captureScreenshot(WebDriver driver, String fileName) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File(fileName);
			try {
				Files.copy(sourceFile.toPath(), destinationFile.toPath());
				System.out.println("Screenshot captured: " + destinationFile.getAbsolutePath());
			} catch (IOException e) {
				System.out.println("Unable to capture screenshot: " + e.getMessage());
			}
		}  
}
	 


