package Steps;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
//import java.util.logging.LogManager;
//import org.apache.logging.log4j.Logger;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.pagecheckout;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class checkoutstepdef {
	private static final Logger logger = LogManager.getLogger(checkoutstepdef.class);
	
	WebDriver driver;
	pagecheckout web;
	public checkoutstepdef() {
		driver=new ChromeDriver();
		web=new pagecheckout(driver);
		
	}
	@Given("User navigates to the URL demowebshop tricentis")
	
	public void user_navigates_to_the_url_demowebshop_tricentis() {
		logger.info("User navigates to the URL"); 
		driver.manage().window().maximize();
	web.navigateToURL("http://demowebshop.tricentis.com");
	}

	@When("User performs the login process in demowebshop")
	public void user_performs_the_login_process_in_demowebshop() {
		logger.info("User performs the login process"); 
		web.clickLoginLink();
		web.performLogin("ratcat@gmail.com", "123456");
	}
	@When("User performs the login process with card")
	public void user_performs_the_login_process_with_card() {
		logger.info("User performs the login process with card");
	web.clickLoginLink();
	web.performLogin("ratcat@gmail.com", "123456");
	}

	@Then("Validate the login is successful or not in demowebshop")
	public void validate_the_login_is_successful_or_not_in_demowebshop() throws InterruptedException {
		logger.info("Validate the login is successful");
		String e1 = driver.getTitle();
		Thread.sleep(2000);
		String e2 = "Demo Web Shop";
		Assert.assertEquals(e2, e1);

	}
	
	@When("user navegates to url in demowebshop tricentis")
	public void user_navegates_to_url_in_demowebshop_tricentis() {
		logger.info("user navegates to url");
		web.navigateToURL("https://demowebshop.tricentis.com/onepagecheckout");
	    
	} 
	
	@Given("the user is on the onepage checkout page")
	public void the_user_is_on_the_onepage_checkout_page() throws InterruptedException {
		logger.info("the user is on the onepage checkout page");
		Thread.sleep(2000);
		web.checkbox();   
	}
    @Given("User clicks on book menu in demowebshop")
    public void user_clicks_on_book_menu_in_demowebshop() throws InterruptedException {
    	logger.info("User clicks on book menu");
    	Thread.sleep(2000);
    	web.clickbookmenu();
    	
    }
    @And("User add third book to cart in demowebshop")
	public void user_add_third_book_to_cart_in_demowebshop() throws InterruptedException {
		
    	logger.info("User add third book to cart");
		Thread.sleep(2000);
       
		web.Iconlists3();
		web.clickAddToCartButton();
		web.shoppingcart();

	}
	@When("the user adds a product to the cart")
	public void the_user_adds_a_product_to_the_cart() throws InterruptedException {
		logger.info("the user adds a product to the cart");
		Thread.sleep(2000);
		web.clickbookmenu();
	   	}
	@When("User clicks on the checkbox in demowebshop")
	public void user_clicks_on_the_checkbox_in_demowebshop() throws InterruptedException {
		logger.info("User clicks on the checkbox");
		Thread.sleep(1000);
	     web.checkbox();
	}
	
	@Then("User should able to checkout in demowebshop")
	public void user_should_able_to_checkout_in_demowebshop() throws InterruptedException {
		logger.info("User should able to checkout");
		Thread.sleep(2000);
		web.checkoutButton();
		}
	
    


	@Then("billing information")
	public void billing_information() throws InterruptedException {
		logger.info("billing information");
	   web.ContinueButton();
	}
	@Then("enters valid shipping")
	public void enters_valid_shipping() throws InterruptedException {
		logger.info("enters valid shipping");
		Thread.sleep(2000);
	web.shipButton();    
	}
	@Then("select shipping type")
	public void select_shipping_type() throws InterruptedException {
		logger.info("select shipping type");
		Thread.sleep(2000);
	 web.ground();
	 web.clickcontinue1();
	}
	@When("selects a payment with card")
	public void selects_a_payment_method() throws InterruptedException {
		logger.info("selects a payment with card");
		Thread.sleep(2000);
		web.cardpayment();
		web.clickcontinue2();
	}
	 
	//}@Then("selects a payment method")
	//public void selects_a_payment_method() throws InterruptedException {
	//	logger.info("selects a payment method");
	//	Thread.sleep(2000);
	//	web.payment();
	//	web.clickcontinue2();
	   
	//}
	
	@Then("selects a payment method")
	public void selects_a_payment_method1() throws InterruptedException {
		
		logger.info("selects a payment method");
		web.payment();
		Thread.sleep(1000);
		web.clickcontinue2();
		
	}
	@Then("completes the purchase cod")
	public void completes_the_purchase_cod() throws InterruptedException {
	
	web.clickcontinue3();
	Thread.sleep(2000);
	
	web.conform();
	Thread.sleep(2000);
	}
	@Then("the user should see order confirmation")
	public void the_user_should_see_order_confirmation() throws InterruptedException {
	 
	  Thread.sleep(2000);
	  System.out.println(web.thanku());
	  driver.close();
	}

	
	@Then("enters payment details")
	public void enters_payment_details() throws InterruptedException {
		logger.info("enters payment details");
		Thread.sleep(2000);
		  web.CreditCard("aadi");
		 web.cardnum("1111222233");
		  web.cardcode("123");
	    
		  
	}
	@When("completes the purchase")
	public void completes_the_purchase() throws InterruptedException {
		logger.info("completes the purchase");
		Thread.sleep(2000);
	
		web.clickcontinue3();
		
		Thread.sleep(2000);
		web.error();
	    captureScreenshot(driver, "Failed1.png");
		System.out.print(web.error);
		Thread.sleep(3000);
		driver.close();
		
	//	captureScreenshot(driver, "Fail1.png");
	}

	@Then("the user should see a confirmation message")
	public void the_user_should_see_a_confirmation_message() throws InterruptedException {
		logger.info("the user should see a confirmation message");
		Thread.sleep(2000);
	    web.conform();
		//Alert alert = driver.switchTo().alert();  alert.dismiss();
	}

	private static void captureScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		//File destinationFile = new File(fileName);
		File destinationFile = new File("C:\\Users\\Sai\\eclipse-workspace\\RLL\\Demo_Web_Shop\\ScreenShots_checkout\\" +fileName);
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			//Files.copy(sourceFile.toPath(), destinationFile.toPath());
			System.out.println("Screenshot captured: " + destinationFile);
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot: " + e.getMessage());
		}
	}
}


