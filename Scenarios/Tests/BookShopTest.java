package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import static org.junit.Assert.assertNotSame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.*;

public class BookShopTest {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	Home4 homePage;
	ShopFinder shop;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Profile\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.hive.co.uk/");

	}

	@Test
	public void BookShopLocator() {
		// The purchase of a product will be tested only to the point of adding
		// a payment method
		report = AllTests.report1;// new ExtentReports("C:\\extent1.html",
									// true);
		// start the test
		test = report.startTest("BookShop Scenario");
		test.log(LogStatus.INFO, "Browser started");
		// Test the home page title and enter location details
		homePage = new Home4(driver);
		String homePageTitle = homePage.getTitle();
		if (homePageTitle.equals("Hive.co.uk - Books, eBooks, DVDs, Blu-ray, Stationery, Music CDs")) {
			test.log(LogStatus.PASS, "verify Title of the page");
			homePage.setLocation("Manchester");
			homePage.clickFind();
		} else
			test.log(LogStatus.FAIL, "Title of the page doesn't match!");
		
		
		// Navigate to bookshop finder results
		shop = new ShopFinder(driver);
		String shopTitle = shop.getTitle();
		String firsttitle = shop.getFirstResult();
		String firstdistance = shop.getFirstDistance();
		String firstaddress = shop.getFirstAddress();

	    if(shopTitle.equals("hive.co.uk Store Locator"))
	    	test.log(LogStatus.PASS, "verify Title of the Store Locator Page");
	    else
	    	test.log(LogStatus.FAIL, "verify Title of the Store Locator Page");
	            	   
		if(firsttitle.equals("Giddy Goat Toys"))
			test.log(LogStatus.PASS, "verify Title of the closest store");
	    else
	    	test.log(LogStatus.FAIL, "verify Title of the closest store");
		
		if(firstdistance.equals("4.65 miles"))
			test.log(LogStatus.PASS, "verify the distance of the first shop");
	    else
	    	test.log(LogStatus.FAIL, "verify the distance of the first shop");
		
		if(firstaddress.equals("2 Albert Hill Street, Didsbury"))
			test.log(LogStatus.PASS, "verify address of first shop found");
	    else
	    	test.log(LogStatus.FAIL, "verify address of first shop found");
		report.endTest(test);
		report.flush();

	}

	@After
	public void tearDown() {
		try {
			driver.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}