package Steps;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Logindemostepdef {
	private static final Logger logger = LogManager.getLogger(Logindemostepdef.class);
    WebDriver driver;
    @When("user enters {string} and {string}")
    public void userEntersemailAndPassword(String email, String password) {
    	logger.info("user Enters email And Password");
        WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }
   
    @Given("user navigates to the login page")
    public void userNavigatesToLoginPage() throws InterruptedException {
    	logger.info("user Navigates To Login Page");
        driver = new ChromeDriver();
        driver.get("http://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement loginpage = driver.findElement(By.xpath("//a[@href='/login']"));
        loginpage.click();
        Thread.sleep(5000);
    }

    

    @And("clicks the login button")
    public void clicksLoginButton() {
    	logger.info("clicks Login Button"); 
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));
        loginButton.click();
    }

//    //@Then("Message Should Be Displayed {string}")
//    public void messageShouldBeDisplayed(String loginResult) {
//    	logger.info("message Should Be Displayed");
//        if (loginResult.equals("logged_in_successfully")) {
//            // Add assertion or verification for successful login
//            System.out.println("logged in successfully");
//        } else {
//        	captureScreenshot(driver, "screenshot.png");
//            // Add assertion or verification for unsuccessful login
//            // For example, checking error messages or validating the login page
//            String errorMessage = "Incorrect email or Password";
//        s.Assert.assertTrue(driver.getPageSource().contains(errorMessage));
//            //captureScreenshot(driver, "screenshot1");
//        }
//        driver.quit();
//    }
    @Then("Message Should Be Displayed {string}")
    public void messageShouldBeDisplayed(String loginResult) throws IOException {
    	logger.info("message Should Be Displayed");
    	String actual = loginResult;
    	System.out.println(actual);
    	String expected = "logged_in_successfully";
       /* if (actual.equals(expected)) {
            // Add assertion or verification for successful login
        	Assert.assertEquals(expected, actual);
           System.out.println("logged in successfully");
        } else {
        	
        	TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			String screenshotName = "Failure_" + "_" + System.currentTimeMillis() + ".png";
			FileUtils.copyFile(screenshot, new File("./Screenshots/" + screenshotName));
        }*/
    	
    	
    	try {
		    Assert.assertEquals(expected, actual);
		  
		   // s.assertAll();
		   
		}  catch (AssertionError e) {
		    // Log the failure message before logging out
		    System.out.println("Assertion failed: " + e.getMessage());
		    TakesScreenshot ts = (TakesScreenshot) driver;
				File screenshot = ts.getScreenshotAs(OutputType.FILE);
				String screenshotName = "Failure_" + "_" + System.currentTimeMillis() + ".png";
				FileUtils.copyFile(screenshot, new File("./Screenshots_login/" + screenshotName));
				WebElement loginpage = driver.findElement(By.xpath("//a[@href='/login']"));
		        loginpage.clear();
		}
    	
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
    @io.cucumber.java.After("@LoginTest")
	public void afterScenario(io.cucumber.java.Scenario scenario) {
		/*if (scenario.isFailed()) {
			logger.error("Scenario failed. Taking a screenshot or performing cleanup if needed.");
			// Add code to capture a screenshot or perform cleanup on failure*/
    	driver.close();

		}
		
	
}