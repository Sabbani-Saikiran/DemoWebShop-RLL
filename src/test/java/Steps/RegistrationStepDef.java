package Steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.Registerpage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RegistrationStepDef {
	private static final Logger logger = LogManager.getLogger(RegistrationStepDef.class);

	private static WebDriver driver;
	private Registerpage registerPage;

	private static final String EXCEL_PATH = "C:\\Users\\Sai\\eclipse-workspace\\RLL\\Demo_Web_Shop\\src\\test\\resources\\Register_TestData.xlsx";
	private static final String SHEET_NAME = "Sheet1";

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		registerPage = new Registerpage(driver);
		driver.get("https://demowebshop.tricentis.com/");
		logger.info("user is on the home page");
	}

	@When("the user clicks on the register link")
	public void the_user_clicks_on_the_register_link() {
		registerPage.clickRegister();
		logger.info("user is on the register page");
	}

	@And("the user selects gender")
	public void the_user_selects_gender() {
		registerPage.clickGender();
	}

	@When("the user enters First Name from Excel {int}")
	public void the_user_enters_first_name_from_excel(Integer RowNo) throws IOException {
		Object[][] excelData = readExcelData(EXCEL_PATH, SHEET_NAME);
		String firstName = excelData[RowNo][0].toString();
		registerPage.enterFirstName(firstName);
		logger.info("user enters first name");
	}

	@When("the user enters Last Name from Excel {int}")
	public void the_user_enters_last_name_from_excel(Integer RowNo) throws IOException {
		Object[][] excelData = readExcelData(EXCEL_PATH, SHEET_NAME);
		String lastName = excelData[RowNo][1].toString();
		registerPage.enterLastName(lastName);
		logger.info("user enters last name");
	}

	@When("the user enters email from Excel {int}")
	public void the_user_enters_email_from_excel(Integer RowNo) throws IOException {
		Object[][] excelData = readExcelData(EXCEL_PATH, SHEET_NAME);
		String email = excelData[RowNo][2].toString();
		registerPage.enterEmail(email);
		logger.info("user enters Email ID");
	}

	@When("the user enters password from Excel {int}")
	public void the_user_enters_password_from_excel(Integer RowNo) throws IOException {
		Object[][] excelData = readExcelData(EXCEL_PATH, SHEET_NAME);
		String password = excelData[RowNo][3].toString();
		registerPage.enterPassword(password);
		logger.info("user enters password");
	}

	@When("the user enters confirm password from Excel {int}")
	public void the_user_enters_confirm_password_from_excel(Integer RowNo) throws IOException {
		Object[][] excelData = readExcelData(EXCEL_PATH, SHEET_NAME);
		String confirmPassword = excelData[RowNo][4].toString();
		registerPage.enterConfirmPassword(confirmPassword);
		logger.info("user enters confirm password");
	}

	@And("the user clicks on register")
	public void the_user_clicks_on_register() throws InterruptedException, IOException {
		registerPage.clickRegisterButton();

		List<By> errorLocators = Arrays.asList(By.xpath("//div[@class='page registration-page']//ul//li"),
				By.xpath("//span[@for='Email']"), By.xpath("//span[@for='Password']")

		);

		boolean isAnyElementVisible = false;

		for (By locator : errorLocators) {
			if (driver.findElements(locator).size() > 0 && driver.findElement(locator).isDisplayed()) {
				isAnyElementVisible = true;
				break;
			}
		}
		try {
			 if(isAnyElementVisible) {
				 Assert.fail("Failure got to catch block");
		         System.out.println("None of the error elements are visible. Test passed.");
			 }else {			
					System.out.println("PAssessd");

			 }
	            
	        } catch (AssertionError e) {
	            System.out.println("At least one error element is visible. Test failed.");
	            TakesScreenshot ts = (TakesScreenshot) driver;
				File screenshot = ts.getScreenshotAs(OutputType.FILE);
				String screenshotName = "Failure" + "_" + System.currentTimeMillis() + ".png";
				FileUtils.copyFile(screenshot, new File("./Screenshots_registration/" + screenshotName));
				System.out.println("Screenshot captured: " + screenshotName);
				throw e;
	         
	        }
	}

	private Object[][] readExcelData(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				Cell cell = row.getCell(j);
				data[i - 1][j] = cell.toString();
			}
		}

		workbook.close();
		file.close();

		return data;
	}

	public static WebDriver getDriver() {

		return driver;
	}

	@io.cucumber.java.After
	public void afterScenario(io.cucumber.java.Scenario scenario) {
		/*
		 * if (scenario.isFailed()) { logger.
		 * error("Scenario failed. Taking a screenshot or performing cleanup if needed."
		 * ); // Add code to capture a screenshot or perform cleanup on failure
		 */
		driver.close();

	}

}