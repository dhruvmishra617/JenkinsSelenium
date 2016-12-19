package SeleniumPack;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class JenkinsTest {

	@Test
	public void JenTest() throws Exception{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\dhruv.mishra\\workspace\\SeleniumJavaProject\\IEDriverServer.exe");
		WebDriver d = new InternetExplorerDriver();
		d.get("http://www.google.com");
		File src = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		File dest = new File("Screenshots\\Screen.png");
		FileUtils.copyFile(src, dest);
		d.quit();
	}
	
	
}
