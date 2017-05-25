package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login1 {
	WebDriver driver;

	


	@FindBy(className = "title")
	WebElement title;
	
	@FindBy(id = "txtEmail")
	WebElement emailText;
	
	@FindBy(id = "txtPassword")
	WebElement passwordText;
	
	@FindBy(id = "cmdLogin")
	WebElement loginButton;
	
	
	
	

	public Login1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void setEmail(String s1){
		emailText.sendKeys(s1);
	}
	
	public void setPassword(String s2){
		passwordText.sendKeys(s2);
	}
	
	
	
	public void clickSignIn(){
		loginButton.click();
	}
	
	
	

	
}