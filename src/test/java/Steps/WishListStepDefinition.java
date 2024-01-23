package Steps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.ECommercePage_addtowishlist;

	
    public class WishListStepDefinition {

    	Logger logger = LogManager.getLogger(WishListStepDefinition.class);

    	private final WebDriver driver;
    	private final ECommercePage_addtowishlist wl;
    	
    	

    public WishListStepDefinition()  {
    		driver = new ChromeDriver();
    		wl = new ECommercePage_addtowishlist(driver);
    		
    	    }

    
    @Given("User navigates to the URL demowebshop")
    public void user_navigates_to_the_url_demowebshop() {
    	logger.info("User navigates to the URL");
    	wl.navigateToURL("http://demowebshop.tricentis.com");
       
    }

    @When("User performs the login process with credentials")
    public void user_performs_the_login_process_with_credentials() {
    	logger.info("User performs the login process");
    	wl.clickLoginLink();
    	wl.performLogin("demouser1234@gmail.com", "123456");
    	
 
       
    }

    @Then("Validate the login is successful or not")
    public void validate_the_login_is_successful_or_not() {
    	logger.info("Validate the login is successfulL");
    	String e1 = driver.getTitle();
    	String e2 = "Demo Web Shop";
    	Assert.assertEquals(e2, e1);
        
    }

    @Given("the user is on the Demo Web Shop homepage")
    public void the_user_is_on_the_demo_web_shop_homepage() {
    	logger.info("the user is on the Demo Web Shop homepage");
    	
    	wl.clickdigitalmenu();
    	String e1 = driver.getTitle();
    	String e2 = "Demo Web Shop. Digital downloads";
    	Assert.assertEquals(e2, e1);
    }
    	
    	
        
    
    @When("the user clicks on {string}")
    public void the_user_clicks_on(String string) {
    	logger.info("the user clicks on {string}");
    	wl.clickdigitalmenu();
       
    }

    @Then("the user adds products to the wishlist")
    public void the_user_adds_products_to_the_wishlist() {
    	logger.info("the user adds products to the wishlist");
    	wl.addProduct1();
    	driver.navigate().back();
    	
    	wl.addProduct2();
    	driver.navigate().back();
    	
    	wl.addProduct3();
    	driver.navigate().back();
    	
    	}

    @Then("the user goes to the Wishlist")
    public void the_user_goes_to_the_wishlist() {
    	logger.info("the user goes to the Wishlist");
    	
    	wl.viewProducts();
    	String e1 = driver.getTitle();
    	String e2 = "Demo Web Shop. Wishlist";
    	Assert.assertEquals(e2, e1);
       
    }

    @Then("the user removes a product from the Wishlist")
    public void the_user_removes_a_product_from_the_wishlist() {
    	logger.info("the user removes a product from the Wishlist");
    	
    	wl.viewProducts();;
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'cart')][1]"));
		java.util.List<WebElement> checkboxes = table.findElements(By.xpath(".//tbody/tr[1]/td[1]/input[1]"));
		for (int i = 0; i < Math.min(2, checkboxes.size()); i++) {
			checkboxes.get(i).click();
		}
		wl.clickUpdateButton();
    	}
        
    
    @Then("the Wishlist should be updated accordingly")
    public void the_wishlist_should_be_updated_accordingly() {
    	logger.info("the Wishlist should be updated accordingly");
    	WebElement table = driver.findElement(By.xpath("//table/tbody"));
    	int rowCount = table.findElements(By.tagName("tr")).size();
    	if (rowCount == 1) {
    		System.out.println(" Only one product in the wishlist");
    	} else {
    		System.out.println(" Multiple product in the wishlist");
    	}
    } 
    @After
    public void closebrowser() {
    	driver.close();
    }
    
}