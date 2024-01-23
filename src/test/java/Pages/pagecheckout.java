package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pagecheckout {

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

	
	@FindBy(css = "div.product")
	private WebElement product;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button-45']")
	private WebElement addToCartButton;
    
	 @FindBy(xpath="//input[@id='termsofservice']")
	    private WebElement checkbox_clk;
	    
	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement checkout;
	
	@FindBy(css = "div.cart-item")
	private WebElement cartItem;

	


	@FindBy(xpath = "//a[contains(@href, '/books')][1]")
	private WebElement bookmenu;

	
	

	@FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Fiction']")
	private WebElement Iconlist3;

	

	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement Shoppingcart;

	@FindBy(xpath="//input[@onclick='Billing.save()']")
    private WebElement Continue;
	
    @FindBy(xpath="//input[@onclick='Shipping.save()']")
    private WebElement clickcontinue;
    
    @FindBy(xpath="//input[@id='shippingoption_1']")
    private WebElement ground;

    @FindBy(xpath="//input[@class='button-1 shipping-method-next-step-button']")
    private WebElement clickcontinue1;
    
    @FindBy(xpath="//input[@id=\"paymentmethod_0\"]")
    private WebElement payment;
    
    @FindBy(xpath="//input[@value='Payments.Manual']")
    private WebElement cardpayment;
    
    @FindBy(xpath="//input[@id='CardholderName']")
    private WebElement CreditCard;
    
    @FindBy(xpath="//input[@id='CardNumber']")
    private WebElement cardnum;
   
    @FindBy(id="CardCode")
    private WebElement cardcode;
    
    @FindBy(xpath="//input[@class='button-1 payment-method-next-step-button']")
    private WebElement clickcontinue2;
    
    @FindBy(xpath="//input[@onclick='PaymentInfo.save()']")
    private WebElement clickcontinue3;
    
    @FindBy(xpath="//div[@class='validation-summary-errors']/ul/li[text()='Wrong card number']")
	public WebElement error;
    
    @FindBy(xpath="//input[@onclick='ConfirmOrder.save()']")
    private WebElement conform;
    
    @FindBy(xpath="//div[@class='title']")
    private WebElement thanku;
    
	public pagecheckout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToURL(String url) {
		driver.get(url);
	}

	public void clickLoginLink() {
		loginLink.click();
	}

	
	

	public void checkoutButton() {
		checkout.click();
	}
	public void Iconlists3() {
		Iconlist3.click();
	}

	

	public void shoppingcart() {
		Shoppingcart.click();
	}


	public void performLogin(String email, String password) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		loginButton.click();
	}

	public void clickOnProduct(int index) {
		driver.findElements(By.cssSelector("div.product")).get(index).click();
	}

	public void clickOnCartItem(int index) {
		driver.findElements(By.cssSelector("div.cart-item")).get(index).click();
	}

	public void clickbookmenu() {
		bookmenu.click();
	}

	public void clickAddToCartButton() {
		addToCartButton.click();
	}

	public void checkbox() throws InterruptedException {
		checkbox_clk.click();
		Thread.sleep(2000);
	}
    public void ContinueButton() throws InterruptedException {
    	 Continue.click();
    	 Thread.sleep(2000);
    }
    
    public void shipButton() throws InterruptedException {
   	 clickcontinue.click();
   	Thread.sleep(2000);
   	
   }
    
    public void ground() throws InterruptedException
    {
    	ground.click();
    	Thread.sleep(2000);
    }
    public void clickcontinue1() throws InterruptedException
    {
    	clickcontinue1.click();
    	Thread.sleep(2000);
    }
    
	public void payment() throws InterruptedException {
		payment.click();
		Thread.sleep(2000);
	}
	
	public void cardpayment() {
		cardpayment.click();
	}
    public void CreditCard(String name) {
    	CreditCard.sendKeys("name");
    	
    }
    public void cardnum(String number) {
    	cardnum.sendKeys(number);
    	
    }
    public void cardcode(String number1) {
    	cardcode.sendKeys(number1);
    	
    }
	
	 public void clickcontinue2() throws InterruptedException
	    {
	    	clickcontinue2.click();
	    	Thread.sleep(2000);
	    	
	    }
	 public void clickcontinue3() throws InterruptedException
	    {
	    	clickcontinue3.click();
	    	Thread.sleep(2000);
	    	
	    }  
	 public String error() {
		 return error.getText();
	 }
	public void conform() throws InterruptedException
	    {
		
	    	conform.click();
	    	Thread.sleep(2000);
	    }  
	public String thanku() {
		return thanku.getText();
	}
}

