package Tests;

import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import Pages.*;

public class BookShopTest {
	
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	
	Home4 homePage;
	ShopFinder shop;
	
	// pass scenario
		@Test(priority = 1, enabled = true)
		public void verifyHomePageTitle() {

			// where to create the report file
			report = new ExtentReports(
					"C:\\extent.html",
					true);
			// start the test
			test = report.startTest("Verify Website Title");
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Profile\\Desktop\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			//driver.manage().window().maximize();
			
			// add a note to the test
			test.log(LogStatus.INFO, "Browser started");
			driver.get("http://www.hive.co.uk/");
			
			homePage = new Home4(driver);
			String title = homePage.getTitle();
			
			System.out.println(title);
			
			if (title.equals(
					"Hive.co.uk - Books, eBooks, DVDs, Blu-ray, Stationery, Music CDs")) {
				
				
				test.log(LogStatus.PASS, "verify Title of the page");
				// report the test as a pass
			
				
				
			} else {
				test.log(LogStatus.FAIL, "verify Title of the page");
			}
			report.endTest(test);
			report.flush();
		}
		
		@Test(priority = 2, enabled = true)
		public void verifyShopFinderTitle() throws IOException {
			test = report.startTest("Verify Title of Finder");
			String finderTitle=homePage.getFinderTitle();
           System.out.println(finderTitle);
			
			if (finderTitle.equals(
					"Bookshop Finder")) {
				
				
				test.log(LogStatus.PASS, "verify Finder Title");
				// report the test as a pass
			
				homePage.setLocation("Manchester");
				homePage.clickFind();
				
			} else {
				test.log(LogStatus.FAIL, "verify Finder Title");
			}
			report.endTest(test);
			report.flush();
			// driver.quit();
		}
		
		@Test(priority = 3, dependsOnMethods={"verifyShopFinderTitle"})
		public void verifyFirstResult() throws IOException {
			test = report.startTest("Verify  First Result");
			shop=new ShopFinder(driver);
			String shopTitle=shop.getTitle();
		
			if (shopTitle.equals(
					"hive.co.uk Store Locator")) {
				
				
				test.log(LogStatus.PASS, "Verify Results Page Title");
				// report the test as a pass
			
				
				
			} else {
				test.log(LogStatus.FAIL, "Verify Results Page Title");
			}
			report.endTest(test);
			report.flush();
			// driver.quit();
		}
		
		@Test(priority = 4, dependsOnMethods={"verifyFirstResult"})
		public void verifyFirstResultDetails() throws IOException {
			test = report.startTest("Verify  First Result Details");
			
			
			String firsttitle=shop.getFirstResult();
			String firstdistance=shop.getFirstDistance();
			String firstaddress=shop.getFirstAddress();
			
			
			
			if (firsttitle.equals("Giddy Goat Toys")&&firstdistance.equals("4.65 miles")&&firstaddress.equals("2 Albert Hill Street, Didsbury")) {
				
				
				test.log(LogStatus.PASS, "Verify Closest Location Details");
				// report the test as a pass
			
				
				
			} else {
				test.log(LogStatus.FAIL, "Verify Closest Location Details");
			}
			report.endTest(test);
			report.flush();
			 driver.quit();
		}
		
	

		
		


	
	
}