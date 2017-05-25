package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login2 {
	WebDriver driver;

	


	@FindBy(className = "title")
	WebElement title;
	
	@FindBy(id = "ap_email")
	WebElement emailText;
	
	@FindBy(id = "ap_password")
	WebElement passwordText;
	
	@FindBy(id = "signInSubmit")
	WebElement loginButton;
	
	
	
	

	public Login2(WebDriver driver) {
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