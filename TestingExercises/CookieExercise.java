
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CookieExercise {
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Profile\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.mouseprice.com/login/");
		final String userName = "justtesting1990@outlook.com";
		final String password = "testing1990";

		WebElement usernameBox = driver.findElement(By.id("txtEmail"));
		WebElement passwordBox = driver.findElement(By.id("txtPassword"));
		WebElement saveBtn = driver.findElement(By.id("cmdLogin"));

		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		saveBtn.click();

		driver.get("http://www.mouseprice.com/");

		
	
		
		// create a wait with a timeout of 5 seconds
		WebDriverWait wait = new WebDriverWait(driver, 5);
		boolean testElement = false;
		try {
			System.out.println("Searching for logout button...");
			testElement = wait.until(ExpectedConditions.textToBePresentInElementLocated(
						By.id("A1"),"Logout"));
		} catch (Exception e) {
			e.printStackTrace();
			testElement = false;
		}

		if (testElement)
			System.out.println("Passed----User logged in successfully!");
		else
			System.out.println("Failed----User didn't log in!");
		

       //Save the cookies before log out and rewrite it after logout
		
		Set<Cookie> cookiesList1 =  driver.manage().getCookies();
		System.out.println("Retrieving cookies...."+"\n");
		
	    
		//find logout button and click on it
		WebElement logoutBtn = driver.findElement(By.id("A1"));
		logoutBtn.click();
		
	  
		boolean result = true;

		try {
			driver.findElement(By.id("cmdLogin"));
		}
		catch (NoSuchElementException e) {
			System.out.println(e);
			result = false;
		}



		if (result)
			System.out.println("---Passed---User logged out"+"\n");
		else
			System.out.println("---Failed---"+"\n");
		
		
		driver.get("https://www.mouseprice.com/");
		
		System.out.println("Rewritting cookies on website page....");
		for(Cookie ck:cookiesList1){
		driver.manage().addCookie(ck);
		}
		
		//Set<Cookie> cookiesList =  driver.manage().getCookies();
		
		    driver.get("https://www.mouseprice.com/");
		    
		    try {
				System.out.println("Searching for logout button...");
				testElement = wait.until(ExpectedConditions.textToBePresentInElementLocated(
							By.id("A1"),"Logout"));
			} catch (Exception e) {
				e.printStackTrace();
				testElement = false;
			}

			if (testElement)
				System.out.println("Passed----User logged in successfully!");
			else
				System.out.println("Failed----User didn't log in!");
		
		    
		driver.close();
		System.exit(0);
	}
}