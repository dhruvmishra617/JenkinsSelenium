package SeleniumPack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SauceTest {

	
	@DataProvider(name = "hardCodedBrowsers", parallel = true)
    public static Object[][] sauceBrowserDataProvider() {
		return new Object[][] {
                new Object[]{"MicrosoftEdge", "14.14393", "Windows 10"},
                new Object[]{"firefox", "49.0", "Windows 10"},
                new Object[]{"internet explorer", "11.0", "Windows 7"},
                new Object[]{"safari", "10.0", "OS X 10.11"},
                new Object[]{"chrome", "54.0", "OS X 10.10"},
        };
	}
        
        
	
	@Test(dataProvider = "hardCodedBrowsers")
	public void SauceLabsTest(String browser, String vers, String plat) throws Exception{
		String SAUCE_USER = "dhruvmishra617";
		String SAUCE_KEY = "baa04393-e3e8-434d-bdfb-0575bf55d0a4";
		String URL = "https://" + SAUCE_USER + ":" + SAUCE_KEY + "@ondemand.saucelabs.com:443/wd/hub";
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platform", plat);
		caps.setCapability("browserName", browser);
		caps.setCapability("version", vers);
		
		
		WebDriver d = new RemoteWebDriver(new URL(URL), caps);
		d.get("http://www.google.com");
		File src = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		File dest = new File("Screenshots\\Screen.png");
		FileUtils.copyFile(src, dest);
		d.quit();
	}
	
	
}
