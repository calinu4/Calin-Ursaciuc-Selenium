package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home2 {
	WebDriver driver;

	@FindBy(className = "title")
	WebElement title;
	
	@FindBy(id = "twotabsearchtextbox")
    WebElement searchinput;
	
	@FindBy(xpath = "/html/body/div[1]/header/div/div[1]/div[3]/div/form/div[2]/div/input")
    WebElement goButton;

	
	public Home2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	public String getButtonTitle(){
		return goButton.getAttribute("value");
	}
	public void setSearchInput(){
		searchinput.sendKeys("cabin bag");
	}
	
	public void clickSearchButton(){
		goButton.click();
		
	}
	
	
}