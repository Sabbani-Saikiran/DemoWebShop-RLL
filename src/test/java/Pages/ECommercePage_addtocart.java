package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ECommercePage_addtocart {

	private final WebDriver driver;

	@FindBy(css = "a.ico-login")
	private WebElement loginLink;

	@FindBy(id = "Email")
	private WebElement emailInput;

	@FindBy(id = "Password")
	private WebElement passwordInput;

	@FindBy(css = "input[value='Log in']")
	private WebElement loginButton;


	@FindBy(xpath = "//a[contains(@href, '/books')][1]")
	private WebElement bookmenu;

	@FindBy(xpath = "//input[@class='button-1 add-to-cart-button']")
	private WebElement validatesbutton;

	@FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Computing and Internet']")
	private WebElement Iconlist1;

	@FindBy(xpath = "//a[normalize-space()='Copy of Computing and Internet EX']")
	private WebElement Iconlist2;

	@FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Fiction']")
	private WebElement Iconlist3;

	@FindBy(xpath = "//a[normalize-space()='Fiction EX']")
	private WebElement Iconlist4;

	@FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Health Book']")
	private WebElement Iconlist5;

	@FindBy(xpath = "//a[normalize-space()='Science']")
	private WebElement Iconlist6;

	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement Shoppingcart;

	@FindBy(xpath = "//input[@value='Update shopping cart']")
	private WebElement Shopingproduct;

	public ECommercePage_addtocart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToURL(String url) {
		driver.get(url);
	}

	public void clickLoginLink() {
		loginLink.click();
	}

	public void validatebutton() {
		validatesbutton.click();
	}

	public void Iconlists1() {
		Iconlist1.click();
	}

	public void Iconlists2() {
		Iconlist2.click();
	}

	public void Iconlists3() {
		Iconlist3.click();
	}

	public void Iconlists4() {
		Iconlist4.click();
	}

	public void Iconlists5() {
		Iconlist5.click();
	}

	public void Iconlists6() {
		Iconlist6.click();
	}
	
	
	 public void clickIconlists(int productNumber) {
	        switch (productNumber) {
	            case 1:
	                Iconlist1.click();
	                break;
	            case 2:
	            	Iconlist2.click();
	                break;
	            case 3:
	                Iconlist3.click();
	                break;
	            case 4:
	            	Iconlist4.click();
	                break;  
	            case 5:
	                Iconlist5.click();
	                break;
	            case 6:
	            	Iconlist6.click();
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid product number: " + productNumber);
	        }
	    }

	public void shoppingcart() {
		Shoppingcart.click();
	}

	public void shoppingpro() {
		Shopingproduct.click();
	}

	public void performLogin(String email, String password) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginButton.click();
	}


	public void clickbookmenu() {
		bookmenu.click();
	}


}
