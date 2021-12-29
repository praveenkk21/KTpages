package KTPages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	public static WebDriver internet() {
	System.setProperty("webdriver.ie.driver","C:\\Users\\praveenkumar\\Documents\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
	DesiredCapabilities des = DesiredCapabilities.internetExplorer();
	des.setAcceptInsecureCerts(true);
	InternetExplorerOptions c = new InternetExplorerOptions();
	c.merge(des);
	WebDriver driver= new InternetExplorerDriver(c);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	return driver;

}
	public static WebDriver firefox() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\praveenkumar\\Documents\\gecko\\geckodriver.exe");
		DesiredCapabilities des = DesiredCapabilities.firefox();
		des.setAcceptInsecureCerts(true);
		FirefoxOptions c = new FirefoxOptions();
		c.merge(des);
		WebDriver driver = new FirefoxDriver(c);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return driver;

	}
	public static WebDriver chrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\praveenkumar\\Documents\\chromedriver_win32 (2)\\chromedriver3.exe");
		DesiredCapabilities des = DesiredCapabilities.chrome();
		des.setAcceptInsecureCerts(true);
		ChromeOptions c = new ChromeOptions();
		c.merge(des);
		WebDriver driver= new ChromeDriver(c);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//driver.get("http://kpc.kantime.com");
		return driver;
	}
	
}

