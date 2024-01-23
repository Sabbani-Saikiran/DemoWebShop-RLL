package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class ECommercePage_addtowishlist {

		private final WebDriver driver;

		@FindBy(css = "a.ico-login")
		private WebElement loginLink;

		@FindBy(id = "Email")
		private WebElement emailInput;

		@FindBy(id = "Password")
		private WebElement passwordInput;

		@FindBy(css = "input[value='Log in']")
		private WebElement loginButton;

		@FindBy(css = "button[type='submit'][name='register-button']")
		private WebElement registerButton;
		
		@FindBy(xpath= "//a[contains(@href, '/digital-downloads')][1]")
		private WebElement Digital;
		
		@FindBy(xpath="//div[@class='product-item'][@data-productid='53']//img")
		private WebElement Product1;
		
		@FindBy(xpath ="//div[@class='product-item'][@data-productid='51']//img")
		private WebElement Product2;
		
		@FindBy(xpath = "//div[@class='product-item'][@data-productid='52']//img")
		private WebElement Product3;
		
		@FindBy(id = "add-to-wishlist-button-53")
		private WebElement WishList1;
		
		@FindBy(id = "add-to-wishlist-button-51")
		private WebElement WishList2;
		
		@FindBy(id = "add-to-wishlist-button-52")
		private WebElement WishList3;
		
		@FindBy(xpath = "//span[contains(text(),'Wishlist')]")
		private WebElement WishList;
		
		@FindBy(name = "removefromcart")
		private WebElement removeButton;
		
		@FindBy(xpath="//input=[@type='checkbox' and @name = 'removefromcart' and @value='3842253']")
		private WebElement Remove1;
		
		@FindBy(name = "updatecart")
		private WebElement updatecart ;
		
		@FindBy(linkText = "Log out")
		private WebElement Logout ;

		public ECommercePage_addtowishlist(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		public void navigateToURL(String url) {
			driver.get(url);
		}

		public void clickLoginLink() {
			loginLink.click();
		}

		public void addProduct1() {
			Product1.click();
			WishList1.click();
			
		}
		
		public void addProduct2() {
			Product2.click();
			WishList2.click();
			
		}

		public void addProduct3() {
			Product3.click();
			WishList3.click();
			
		}
			
		public void viewProducts() {
			WishList.click();
			
		}
		
		public void RemoveProduct1() {
			Remove1.click();
			
		}
		

		public void performLogin(String email, String password) {
			emailInput.sendKeys(email);
			passwordInput.sendKeys(password);
			loginButton.click();
		}

	
		public void clickdigitalmenu() {
			Digital.click();
		}

		
		
		public void clickUpdateButton() {
			updatecart.click();
		}
		
        
	}

