package main;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import bean.ConnectBean;
import junit.framework.TestCase;

public class WaitsTest extends TestCase {

	WebDriver driver;
	WebElement element;
	Select select;
	WebDriverWait wait;
	ConnectBean login = new ConnectBean();

	@Before
	public void setUp() {
		login.getSystem();
		driver = login.getDriver();

		element = driver.findElement(By.id("search"));
		element.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAssert() throws IOException, AWTException {
		/*** Explicit Waits **/
		// wait = new WebDriverWait(driver, 10);
		// element =
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test")));

		/*** Implicit Waits **/
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element = driver.findElement(By.id("test"));
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
