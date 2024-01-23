package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ECommercePage_search {
	WebDriver driver;
	 
	 @FindBy(xpath = "//input[@id='small-searchterms']")
		WebElement search_input;
		@FindBy(xpath="//input[@type='submit']")
		WebElement search_btn;
		
		
		public ECommercePage_search(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		

		public void search_placeholder(String search_content) throws InterruptedException {
			search_input.sendKeys(search_content);
			search_btn.click();
			

		}
		public void searchbtn() {
			search_btn.click();
		}
		
		public void navigateToURL(String url) {
			driver.get(url);
		}
		


		
	
	 
	 
	 
	 

}
