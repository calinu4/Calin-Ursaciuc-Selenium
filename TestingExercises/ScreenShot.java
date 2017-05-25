import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

     
    public class ScreenShot{
        public static WebDriver driver;
         
     
      public static void main(String[] args) throws Exception {
    	  System.setProperty("webdriver.gecko.driver",
    			  "C:\\Users\\Profile\\Desktop\\Selenium\\geckodriver.exe");
    	  
    	  driver = new FirefoxDriver();
    	  driver.manage().window().maximize();
    	  driver.get("http://www.facebook.com");
    	  
    	  try{
                //the below statement will throw an exception as the element is not found, Catch block will get executed and takes the screenshot.
    		  driver.findElement(By.id("testing")).sendKeys("test");
                 
                   //if we remove the below comment, it will not return exception and screen shot method will not get executed.
    		  //driver.findElement(By.id("gbqfq")).sendKeys("test");
    	  }
    	  catch (Exception e){
    		  System.out.println("I'm in exception");
               //calls the method to take the screenshot.
    		  getscreenshot();
     	  }
      }
      
      public static void getscreenshot() throws Exception 
      {
              File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             
              //The below method will save the screen shot in c drive with name "screenshot.png"
              FileUtils.copyFile(scrFile, new File("C:\\screenshot.png"));
              System.out.println("Screenshot saved at: C:\\screenshot.png");
              
      }
 }