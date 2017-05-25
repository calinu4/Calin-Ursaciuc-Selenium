package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;

	@FindBy(className = "title")
	WebElement title;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div[1]/div/ul/li[1]/div/div/div/div[2]/div[1]/div[1]/a")
	WebElement productlink;
	
	@FindBy(id = "add-to-cart-button")
	WebElement addbutton;
	
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getAddButtonText(){
		return addbutton.getAttribute("value");
	}
	
	public void clickFirstProduct(){
		productlink.click();
	}
	
	public void addToBasket(){
		addbutton.click();
	}
	
	
}