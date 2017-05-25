package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;

	


	@FindBy(className = "title")
	WebElement title;
	
	@FindBy(id = "A2")
	WebElement accountButton;
	
	
	@FindBy(id = "A1")
	WebElement logoutButton;
	
	
	
	

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	public String getLogoutText(){
		return logoutButton.getText();
	}
	
	
	public void clickAccountLink(){
		accountButton.click();
	}
	public void clickLogout(){
		logoutButton.click();
	}
	
	
	

	
}