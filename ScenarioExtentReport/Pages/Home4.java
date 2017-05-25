package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home4 {
	WebDriver driver;

	@FindBy(className = "title")
	WebElement title;
	
	@FindBy(id = "postcode")
	WebElement post;
	
	
	
	@FindBy(css = "html.desktop.unauthenticated.avgrund-ready.wf-proximanova-n7-active.wf-proximanova-i7-active.wf-proximanova-n6-active.wf-proximanova-n4-active.wf-proximanova-i4-active.wf-bookmania-n4-active.wf-bookmania-n6-active.wf-active body div#outerWrap div#wrap div#footer div#mainFooter div.container_16.clearfix div.grid_16 div.grid_8.omega div.storeLocator div.locator h6")
	WebElement finder;
	
	public Home4(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void setLocation(String s){
		post.sendKeys(s);
	}
	
	public String getFinderTitle(){
		return finder.getText();
	}
	public void clickFind(){
		post.sendKeys(Keys.RETURN);
	}
	
	
	
	
}