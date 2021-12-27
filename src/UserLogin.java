import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserLogin {
	public static void workingUserLogin(WebDriver driver,String username2, String password2) {
		driver.get("https://192.168.4.74/Working/UI/Common/Login.aspx");
		driver.manage().window().maximize();
		driver.findElement(By.id("txt_username")).sendKeys(""+username2+"");
		// driver.findElement(By.id("SALogIn_btn_LogIn")).click();
		driver.findElement(By.id("txt_password")).sendKeys(""+password2+"");
		driver.findElement(By.id("btn_login")).click();
		System.out.println(driver.getTitle());

	}
	public static void prodUserLogin(WebDriver driver,String username2, String password2) {
		driver.get("https://192.168.1.16/ProdMaster/UI/Common/Login.aspx");
		driver.manage().window().maximize();
		driver.findElement(By.id("txt_username")).sendKeys(""+username2+"");
		// driver.findElement(By.id("SALogIn_btn_LogIn")).click();
		driver.findElement(By.id("txt_password")).sendKeys(""+password2+"");
		driver.findElement(By.id("btn_login")).click();
		System.out.println(driver.getTitle());

	}
	public static void netUserLogin(WebDriver driver,String username2, String password2) {
		driver.get("https://192.168.1.15/Working/UI/Common/Login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("txt_username")).sendKeys(""+username2+"");
		// driver.findElement(By.id("SALogIn_btn_LogIn")).click();
		driver.findElement(By.id("txt_password")).sendKeys(""+password2+"");
		driver.findElement(By.id("btn_login")).click();
		System.out.println(driver.getTitle());

	}
}
