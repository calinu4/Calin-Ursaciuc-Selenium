package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home3 {
	WebDriver driver;

	@FindBy(className = "title")
	WebElement title;
	
	@FindBy(id = "navMenuLogoff")
	WebElement login;
	
	public Home3(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getLoginTitle(){
		return login.getText();
	}
	
	public void clickLogin(){
		login.click();
	}
	
	
}