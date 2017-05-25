package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home1 {
	WebDriver driver;

	By title = By.className("title");
	By signin = By.xpath("/html/body/form/div[4]/div/ul/li[1]/a");
	public Home1(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSignInLink() {
		driver.get(driver.findElement(signin).getAttribute("href"));
	}

	public String getTitle() {
		return driver.getTitle();
	}
}