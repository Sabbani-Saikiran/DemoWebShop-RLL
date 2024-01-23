package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/login']")
    WebElement loginPage;

    @FindBy(xpath = "//input[@class='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@class='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='Log in']")
    WebElement loginButton;

    // Constructor to initialize the elements
    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods to perform actions on the page
    public void clickLoginPage() {
        loginPage.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() throws InterruptedException {
        loginButton.click();
        Thread.sleep(15000);
    }

    
}