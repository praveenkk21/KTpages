package KTPages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserLogin {

	public static void workingUserLogin(WebDriver driver, String username2, String password2)
			throws InterruptedException {
		driver.get("https://192.168.4.74/Working/UI/Common/Login.aspx");
		driver.manage().window().maximize();
		login(driver, username2, password2);
	}

	public static void prodUserLogin(WebDriver driver, String username2, String password2) throws InterruptedException {
		driver.get("https://192.168.1.16/ProdMaster/UI/Common/Login.aspx");
		driver.manage().window().maximize();
		login(driver, username2, password2);
	}

	public static void netUserLogin(WebDriver driver, String username2, String password2) throws InterruptedException {
		driver.get("https:/dev.kantimemedicare.net/UI/Common/Login.aspx");
		driver.manage().window().maximize();
		login(driver, username2, password2);
	}

	public static void login(WebDriver driver, String username2, String password2) throws InterruptedException {
		try {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.id("txt_username")).sendKeys("" + username2 + "");
			// driver.findElement(By.id("SALogIn_btn_LogIn")).click();
			driver.findElement(By.id("txt_password")).sendKeys("" + password2 + "");
			driver.findElement(By.id("btn_login")).click();
			System.out.println(driver.getTitle());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Something went wrong");
			Thread.sleep(2000);
			driver.findElement(By.id("txt_username")).clear();
			driver.findElement(By.id("txt_username")).sendKeys("support@z4.com");
			// driver.findElement(By.id("SALogIn_btn_LogIn")).click();
			driver.findElement(By.xpath("//*[@id='div_MessageAlert']/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("txt_password")).clear();
			Thread.sleep(2000);
			driver.findElement(By.id("txt_password")).sendKeys("demo");
			driver.findElement(By.id("btn_login")).click();
			System.out.println(driver.getTitle());
		}

	}
}
