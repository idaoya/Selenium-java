package main;

import java.awt.AWTException;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import bean.ConnectBean;
import junit.framework.TestCase;

public class JavaScriptTest extends TestCase {

	WebDriver driver;
	WebElement element;
	ConnectBean login = new ConnectBean();

	@Before
	public void setUp() {
		login.getSystem();
		driver = login.getDriver();

		element = driver.findElement(By.id("long"));
		element.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testJavaScript() throws IOException, AWTException, InterruptedException {

		/*
		 * if (driver instanceof JavascriptExecutor) { ((JavascriptExecutor)
		 * driver).executeScript("alert('Thai Girl Test JavaScript');"); }
		 */

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 2000);");
		Thread.sleep(5000);
		jse.executeScript("scroll(0,-2000);");
	}

	@After
	public void tearDown() {
		try {
			Thread.sleep(10000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
