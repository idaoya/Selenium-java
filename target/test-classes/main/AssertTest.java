package main;

import java.awt.AWTException;
import java.io.IOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import bean.ConnectBean;
import junit.framework.TestCase;

public class AssertTest extends TestCase {

	WebDriver driver;
	WebElement element;
	Select select;
	ConnectBean login = new ConnectBean();

	@Before
	public void setUp() {
		login.getSystem();
		driver = login.getDriver();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAssert() throws IOException, AWTException {
		element = driver.findElement(By.id("add"));
		element.click();

		Assert.assertTrue(driver.getPageSource().contains("Opprette Kunde"));

		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://localhost:8181/JavaServerFaces/faces/index.xhtml");
		Assert.assertEquals("Demo Opprette Kunde", this.driver.getTitle());

		element = driver.findElement(By.xpath("//*[@id='j_idt10']/input[2]"));
		element.click();
		Assert.assertTrue(driver.getPageSource().contains("Navn: Validation Error: Value is required."));
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
