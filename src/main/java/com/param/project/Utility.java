package com.param.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility {

	public static WebDriver getDriver() {
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public static String getProperty(String key) throws IOException {
		File file = new File("src/test/resources/data.properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties.getProperty(key);
	}

	public static void gateScreenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("src/test/resources/Screenshot/" + screenshotName + ".png"));
	}

	public static List<String> readExcel() throws IOException {
		File file = new File("src/test/resources/Screenshot/Registration data details.xls");
		FileInputStream fileInputStream = new FileInputStream(file);

		List<String> userRegistrationDetails = new ArrayList<String>();

		// reading .xls file
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
		// represent excel work book
		HSSFSheet sheet = hssfWorkbook.getSheetAt(0);

		int lastRowNumber = sheet.getLastRowNum();
		int lastCellNumber = 0;

		for (int i = 1; i <= lastRowNumber; i++) {
			HSSFRow row = sheet.getRow(i);
			lastCellNumber = row.getLastCellNum();
			for (int j = 0; j < lastCellNumber; j++) {

				userRegistrationDetails.add(row.getCell(j).getStringCellValue());
			}
		}

		return userRegistrationDetails;
	}
	
	public static void selectValueFromDropdown(WebElement dropDown,String valueToSelect)
	{
		Select select=new Select(dropDown);
		select.selectByVisibleText(valueToSelect);
	}
	public void login(){
	}

}
