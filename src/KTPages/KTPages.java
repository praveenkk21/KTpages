package KTPages;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.lang.Math;
import org.apache.commons.io.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class KTPages {
	static WebDriver driver;
	static String username, password, Client, intakeClient, subformname, subformfrom;
	static String subformlibraryid;

	@Test

	public static void browser() throws Exception {
		File file = new File("C:\\Users\\praveenkumar\\eclipse-workspace\\KTPages\\file.properties");
		FileInputStream fi = new FileInputStream(file);
		Properties fi1 = new Properties();
		fi1.load(fi);
		String browsername = fi1.getProperty("Browser");
		username = fi1.getProperty("username");
		password = fi1.getProperty("password");
		intakeClient = fi1.getProperty("intakeClient");
		Client = fi1.getProperty("Client");
		subformname = fi1.getProperty("subformname");
		subformlibraryid = fi1.getProperty("subformlibraryid");
		subformfrom = fi1.getProperty("subformfrom");

		if (browsername.equals("Chrome")) {
			System.out.println(browsername);
			driver = Driver.chrome();
		} else if (browsername.equals("internet")) {
			System.out.println(browsername);
			driver = Driver.internet();
		} else {
			driver = Driver.firefox();
		}

		if (fi1.getProperty("site").equals("working")) {
			UserLogin.workingUserLogin(driver, username, password);
		} else if (fi1.getProperty("site").equals("prod")) {
			UserLogin.prodUserLogin(driver, username, password);
		} else {
			UserLogin.netUserLogin(driver, username, password);
		}

		takeSnapShot(driver, "Dashboard");

		driver.findElement(By.id("66")).click();
		takeSnapShot(driver, "Clinical");
		driver.findElement(By.xpath("//*[contains(text(),'Reports') and @class='MenuItemNormalStyle_Training']"))
				.click();
		List<WebElement> ctNum = driver.findElements(
				By.xpath("//*[@class='MenuItemNormalStyle_DefaultNewStyles' and contains(@id,'td_sub')]"));
		int ctNum2 = ctNum.size();
		System.out.println(ctNum.size());
		String tempUrl = driver.getCurrentUrl();
		String[] st = tempUrl.split("/UI/", 3);
		String st1 = st[0];
		String st2 = st1.concat("/UI/Common/HomeBlank.aspx");
		System.out.println(st2);
		driver.get(st2);
		

		for (int i = 0; i < ctNum2; i++) {
			try {
				driver.findElement(By.id("66")).click();
				driver.findElement(
						By.xpath("//*[contains(text(),'Reports') and @class='MenuItemNormalStyle_Training']")).click();
				jExcecutor(driver.findElement(By.xpath("//*[@id=\"td_sub" + i + "\"]")));
				driver.findElement(By.xpath("//*[@id=\"td_sub" + i + "\"]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@value='Display']")).click();
				String Pagename = driver.findElement(By.id("mastePage_Title")).getText();
				Thread.sleep(5000);
				System.out.println(Pagename + " page is working fine");
				takeSnapShot(driver, "KT " + i + " " + Pagename);
			}

			catch (Exception e) {
				System.out.println("page is failing");
				System.out.println(i + " Exception error");
				System.out.println(st2);
				driver.get(st2);
			}

		}
		driver.close();
	}
	
	public static void jExcecutor(WebElement el) {
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", el);
	}

	public static void takeSnapShot(WebDriver webdriver, String Pagename) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(
				"C:\\Users\\praveenkumar\\Downloads\\MyAutomation\\selenium-server-3.141.59\\Screnshots\\" + Pagename
						+ " " + Math.random() + ".jpg");
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
