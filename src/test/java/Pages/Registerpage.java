package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerClick;

	@FindBy(id = "gender-male")
	private WebElement genderClick;

	@FindBy(id = "FirstName")
	private WebElement firstNameClick;

	@FindBy(id = "LastName")
	private WebElement lastNameClick;

	@FindBy(id = "Email")
	private WebElement emailClick;

	@FindBy(id = "Password")
	private WebElement passwordClick;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordClick;

	@FindBy(xpath = "//span[@for='ConfirmPassword']")
	public WebElement confirmPasswordError;

	@FindBy(id = "register-button")
	private WebElement registerButtonClick;

	@FindBy(xpath = "(//div[@class = 'validation-summary-errors'])/ul/li")
	public WebElement mailerr;

	public Registerpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickRegister() {
		registerClick.click();
	}

	public void clickGender() {
		genderClick.click();
	}

	public void enterFirstName(String fname) {
		firstNameClick.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastNameClick.sendKeys(lname);
	}

	public void enterEmail(String email) {
		emailClick.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordClick.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordClick.sendKeys(confirmPassword);
	}

	public void clickRegisterButton() {
		registerButtonClick.click();

	}

	public String getmessage(WebElement element) {
		return element.getText();
	}

}
