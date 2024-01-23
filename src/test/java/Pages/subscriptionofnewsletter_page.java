package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

//import base.SharedSteps;

public class subscriptionofnewsletter_page {
	
	//Page Factory
	
	@FindBy(xpath="//a[@class='ico-login']")
	public static WebElement Login_Link;
	
	@FindBy(id = "Email")
	public static WebElement email;

	@FindBy(id = "Password")
	public static WebElement Password;

	@FindBy(xpath = "//input[@value='Log in']")
	public static WebElement Click_Login;
	
	@FindBy(xpath = "//input[@id='newsletter-email']")
	public static WebElement Signupmail;
	
	@FindBy(xpath = "//input[@id='newsletter-subscribe-button']")
	public static WebElement Click_Signup;
	
	//@FindBy(xpath = "//div[contains(text(), 'Enter valid email')]")
	@FindBy(xpath = "//div[@id='newsletter-result-block']")
	public static String entervalidmail;
	
	
	@FindBy(xpath ="//div[@id = 'newsletter-result-block']")
	public static WebElement result;
	
	@FindBy(xpath ="//a[@class='ico-logout']")
	public static WebElement logout;
	

	public subscriptionofnewsletter_page(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
	
	public void Click_LoginLink() throws InterruptedException {
		Thread.sleep(2000);
		Login_Link.click();
	

}



	public void give_email(String emailID) throws InterruptedException {
		Thread.sleep(2000);
		email.sendKeys(emailID);
	}

	public void give_password(String password) throws InterruptedException {
		Thread.sleep(2000);
		Password.sendKeys(password);
	}

	public void Click_Login() throws InterruptedException {
		Thread.sleep(2000);
		Click_Login.click();
	

}
	
	public void give_signup_emailid(String signup_emailid) throws InterruptedException {
		Thread.sleep(2000);
		Signupmail.sendKeys(signup_emailid);
		
	}
	
	
	public void Click_Signup() throws InterruptedException {
		Thread.sleep(2000);
		Click_Signup.click();
		
		
	

}
	public String result() throws InterruptedException {
		Thread.sleep(2000);
		return result.getText();
	
		
	}
	 public  String entervalidmail() throws InterruptedException {
		 Thread.sleep(500);
		 String  entervalidmail = BasePage.driver.findElement(By.id("newsletter-result-block")).getText();	
		/* WebDriverWait wait = new WebDriverWait(BasePage.driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.linkText("Enter valid email"))); */
		 
		return entervalidmail;
}
	
	public void Click_Logout() throws InterruptedException {
		Thread.sleep(2000);
		logout.click();
	}
}