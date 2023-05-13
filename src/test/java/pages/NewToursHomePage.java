package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewToursHomePage {

	WebDriver driver;
	WebElement registrationLink;

	public NewToursHomePage(WebDriver driver) {
		// this keyward is used for differenceate instance & local member variable
		this.driver = driver;
	}

	public WebElement getRegistrationLink() {
		// for calling purpose we have pest it setRegistrationLink
		setRegistrationLink();
		return registrationLink;
	}

	public void setRegistrationLink() {
		this.registrationLink = driver.findElement(By.xpath("//a[text()='REGISTER']"));
	}

	// for click operation purpose we have create method
	public void clickOnRegistrationLink() {
		getRegistrationLink().click();
	}

}
