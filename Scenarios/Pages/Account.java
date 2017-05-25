package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Account {
	WebDriver driver;

	


	@FindBy(className = "title")
	WebElement title;
	
	@FindBy(id = "navMenuHello")
	WebElement hello;
	
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/div[2]/div[2]/ul/li[3]/a")
	WebElement logout;
	

	
	
	

	public Account(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	

	public String getHello(){
		return hello.getText();
	}
	
	public void clickLogout(){
		logout.click();
	}
	

	
}