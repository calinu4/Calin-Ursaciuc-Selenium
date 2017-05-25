import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginTest {
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Profile\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://php.thedemosite.co.uk/addauser.php");
		final String userName = "cxcx";
		final String password = "cxcvx";

		WebElement usernameBox = driver.findElement(By.name("username"));
		WebElement passwordBox = driver.findElement(By.name("password"));
		WebElement saveBtn = driver.findElement(By.name("FormsButton2"));

		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		saveBtn.click();

		driver.get("http://php.thedemosite.co.uk/login.php");

		usernameBox = driver.findElement(By.name("username"));
		passwordBox = driver.findElement(By.name("password"));
		saveBtn = driver.findElement(By.name("FormsButton2"));

		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		saveBtn.click();

		
		// create a wait with a timeout of 5 seconds
		WebDriverWait wait = new WebDriverWait(driver, 5);
		boolean testElement = false;
		try {
			System.out.println("Searching...");
			testElement = wait.until(ExpectedConditions.textToBePresentInElementLocated(
							By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"),"Success"));
		} catch (Exception e) {
			e.printStackTrace();
			testElement = false;
		}

		if (testElement)
			System.out.println("Login Successful");
		else
			System.out.println("Failed");
		

		driver.close();
		System.exit(0);
	}
}