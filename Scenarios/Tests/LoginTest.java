package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.Home1;
import Pages.Login1;
import Pages.AccountPage;;
public class LoginTest {
	WebDriver driver;

	Login1 loginPage;
	Home1 homePage;
	AccountPage accountPage;
	final String userName = "justtesting1990@outlook.com";
	final String password = "testing1990";
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Profile\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.mouseprice.com/");
	}
	@Test
	public void testLoginLogout() {

		homePage = new Home1(driver);
		String homePageTitle = homePage.getTitle();
		assertEquals(homePageTitle, "Land Registry Sold House Prices and Property Valuations – Mouseprice.com");
		homePage.clickSignInLink();

		loginPage = new Login1(driver);
		//check we're on the login page
		String loginTitle = loginPage.getTitle();
		assertTrue(loginTitle.contains("Login - Mouseprice"));
		
		//set email and password
	    loginPage.setEmail(userName);
	    loginPage.setPassword(password);
	   
		//click sign in button
	    loginPage.clickSignIn();
	    
	    //check user is logged in and go to account area then logout
	    accountPage=new AccountPage(driver);
	    
	    String logouttext=accountPage.getLogoutText();
	    assertTrue(logouttext.contains("Logout"));
	    
	    accountPage.clickAccountLink();
	    String areaTitle=accountPage.getTitle();
	    assertTrue(areaTitle.contains("Account Details - Mouseprice"));
	    
	    accountPage.clickLogout();
	        loginTitle=accountPage.getTitle();
	    assertTrue(loginTitle.contains("Login - Mouseprice"));
	
	    	
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