package SeleniumPack;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class Dummy {
 
WebDriver driver;
 
 @BeforeTest
 public void start(){
  
  DesiredCapabilities cap = new DesiredCapabilities();
  driver = new ChromeDriver(cap);
 }
  
 public void SearchSuggestion() throws InterruptedException {
  
	 
	 driver.manage().window().maximize();
  driver.get("http://google.com");
  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  WebDriverWait w = new WebDriverWait(driver,10);
  w.until(ExpectedConditions.presenceOfElementLocated(By.id("lst-ib")));
  driver.findElement(By.id("lst-ib")).sendKeys("selenium");
  
  //driver.findElement(By.id("lst-ib")).getAttribute("value").equals("robot");
  
  Assert.assertEquals("xya",driver.findElement(By.id("lst-ib")).getAttribute("value"));
  //driver.findElement(By.id("lst-ib")).getText().contentEquals(arg0)
  
  Select dropdown = new Select(driver.findElement(By.id("lst-ib")));
  
  WebElement option = dropdown.getFirstSelectedOption();
  
  
  System.out.print("jkdhfkdjfh");
  
  Actions act = new Actions(driver);
  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
  
  
  driver.findElement(By.id("lst-ib")).getAttribute("value").contentEquals("selenium");
  Thread.sleep(5000);
 }
 
 @AfterTest
 public void end(){
	 driver.quit();
 }
}
  
  
  //  
//   WebElement table = driver.findElement(By.className("gssb_m")); 
//   List rows = table.findElements(By.tagName("tr")); 
//   Iterator i = rows.iterator(); 
//   System.out.println("-----------------------------------------"); 
//   while(i.hasNext()) { 
//           WebElement row = (WebElement) i.next(); 
//           List columns = row.findElements(By.tagName("td")); 
//           Iterator j = columns.iterator(); 
//           while(j.hasNext()) { 
//                   WebElement column = (WebElement) j.next(); 
//                   System.out.println(column.getText()); 
//           } 
//           System.out.println(""); 
//            
//   System.out.println("-----------------------------------------"); 
//   } 
//  } 


