package SeleniumPack;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.annotations.*;
import org.testng.Assert;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;


public class SeleniumTest {
	public	WebDriver	driver;
	public	WebElement	button,	sourceElement,	targetElement;
	public	String	box;
	public	List<WebElement>	links;
	public	Actions action;
	public	Action drag;
	
	public static void main(String[] args){
		System.out.print("print");
	}
	
	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() {
	//return new Object[][] { { "data one" }, { "data two" }, { "data 1" }, { "data 2" }  };
	return new Object[][] { { "data one" ,  driver, 3 }, { "data 1" , driver , 4 },  {"data x2" , driver, 90} };
	}
	
	/*@Test(dataProvider = "data-provider")
	public void testMethod(String data, WebDriver data2, int d3) {
	data2.get("http://www.yahoo.com");	
	
	//data2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	data2.findElement(By.xpath("//*[@id='uh-search-box']")).sendKeys(data);
	data2.findElement(By.xpath("//*[@id='uh-search-box']")).submit();
	data2.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	WebDriverWait w = new WebDriverWait(data2, 10);
	w.until(ExpectedConditions.elementToBeClickable(data2.findElement(By.xpath("//*[@id='uh-search-box']"))));
	System.out.println("Data is: " + data + " " + data2 + " " + d3);
	data2.close();
	}*/
	
//	}
//	@Test
//	public void meth(){
//	final int[][] obj={{ 1,2,3 }, { 4,5,6}};
//	for(int i=0; i<2; i++)
//	{
//	for(int j=0; j<3; j++)
//	{
//	System.out.println(i+ " " + j+ " " + obj[i][j]);
//	}
//	}
//	}
//	
	
	
//	@Test
//	public void D() throws IOException{
//		HSSFWorkbook wb = new HSSFWorkbook();
//		FileOutputStream outfile = new FileOutputStream("sheet2.xls");
//		wb.write(outfile);
//		outfile.close();
//	}

//	@Test
//	public void timeTestOne() throws InterruptedException{
//	Thread.sleep(501);
//	System.out.println("Time test method one");
//	}
//	@Test(timeOut=300)
//	public void timeTestTwo() throws InterruptedException{
//	Thread.sleep(400);
//	System.out.println("Time test method two");
//	}
	

@BeforeTest()
	public	void	createDriver(){
	driver	=	new		ChromeDriver();	
	action	=	new		Actions(driver);
}

@Test(enabled	=	true,priority	=	1)
	public	void	method1(){
		driver.get("http://output.jsbin.com/usidix/1");
		button	=	driver.findElement(By.xpath("html/body/input"));
		button.click();
		
		Alert	alert	=	driver.switchTo().alert();
		box	=	alert.getText();
		AssertJUnit.assertEquals(box	,	"This is an alert box.");
		alert.accept();
		}
//@Test(priority	=	2,	groups	=	"group1")
@Parameters(value = "test")
//	public	void	method2() {
//		driver.navigate().to("http://jqueryui.com/droppable/");
//		driver.manage().window().maximize();
//		driver.switchTo().frame(0);
//		sourceElement	=	driver.findElement(By.xpath(".//*[@id='draggable']"));
//		targetElement	=	driver.findElement(By.xpath(".//*[@id='droppable']"));
//		drag	=	action.doubleClick(sourceElement).dragAndDrop(sourceElement, targetElement).build();
//		drag.perform();
//		}
//
//@Test(priority	=	3,dependsOnMethods	=	"method2")
//	public	void	screenshot() throws IOException{
//	File	screen 	=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	File	file	=	new	File("C:/Users/dhruv.mishra/workspace/SeleniumJavaProject/Screenshots/Screen1.jpg");
//	FileUtils.copyFile(screen, file);

//
//
//	/*WebDriver augmentedDriver = new Augmenter().augment(driver);
//    File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
//    FileUtils.copyFile(screenshot, new	File("C:/Users/dhruv.mishra/workspace/SeleniumJavaProject/Screenshots/Screen1.jpg"));*/
//    
//    
//}
//
//
//
//
@AfterTest
public	void	quitDriver(){
driver.quit();	
}

}
