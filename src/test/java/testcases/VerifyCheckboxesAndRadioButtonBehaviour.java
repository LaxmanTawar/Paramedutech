package testcases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.param.project.Utility;

import pages.HomePage;

public class VerifyCheckboxesAndRadioButtonBehaviour {

	WebDriver driver;
	HomePage homepage;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {

		driver = Utility.getDriver();
		driver.get(Utility.getProperty("url"));
		driver.manage().window().maximize();
		homepage = new HomePage(driver);

	}

	@Test(priority = 1, groups = { "e2e" }, enabled = true)
	public void verifyCheckboxesAndRadioButtonBehaviour() throws IOException {
		/*
		 * Verify that male and female radio buttton are unchecked make sure orange
		 * checkbox is checked and blue checkbox is unchecked
		 */

		assertFalse(homepage.getMaleRadioButton().isSelected());
		assertFalse(homepage.getFemaleRadioButton().isSelected());

		assertTrue(homepage.getOrangeCheckbox().isSelected());
		assertFalse(homepage.getBlueCheckbox().isSelected());

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility.gateScreenshot(driver, result.getName());
		}
		driver.quit();

	}

}
