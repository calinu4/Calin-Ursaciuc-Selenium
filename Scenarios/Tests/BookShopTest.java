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

import Pages.*;

public class BookShopTest {
	WebDriver driver;

	
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
        //The purchase of a product will be tested only to the point of adding a payment method
		
		//Test the home page title and enter location details
		homePage = new Home4(driver);
		String homePageTitle = homePage.getTitle();
		assertEquals(homePageTitle, "Hive.co.uk - Books, eBooks, DVDs, Blu-ray, Stationery, Music CDs");
		homePage.setLocation("Manchester");
		homePage.clickFind();
		
        //Navigate to bookshop finder results
		shop=new ShopFinder(driver);
		String shopTitle=shop.getTitle();
		String firsttitle=shop.getFirstResult();
		String firstdistance=shop.getFirstDistance();
		String firstaddress=shop.getFirstAddress();
		
		assertEquals(shopTitle,"hive.co.uk Store Locator");
		assertEquals(firsttitle,"Giddy Goat Toys");
		assertEquals(firstdistance,"4.65 miles");
		assertEquals(firstaddress,"2 Albert Hill Street, Didsbury");
		
	    
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