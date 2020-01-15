package main;

import java.awt.AWTException;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import bean.ConnectBean;
import junit.framework.TestCase;

public class ElementTest extends TestCase {

	WebDriver driver;
	WebElement element;
	ConnectBean login = new ConnectBean();

	@Before
	public void setUp() {
		login.getSystem();
		driver = login.getDriver();
		element = driver.findElement(By.id("add"));
		element.click();
	}

	@Test
	public void testElementXpath() throws IOException, AWTException {
		element = driver.findElement(By.xpath("//*[@id='j_idt10:name']"));
		element.sendKeys("Anne");
	}

	@Test
	public void testElementName() throws IOException, AWTException {
		element = driver.findElement(By.name("j_idt10:name"));
		element.sendKeys("Nina");
	}

	@Test
	public void testElementClassName() throws IOException, AWTException {
		element = driver.findElement(By.className("link"));
		element.click();
	}

	@Test
	public void testElementCssSelector() throws IOException, AWTException {
		element = driver.findElement(By.cssSelector("a.link"));
		element.click();
	}

	@Test
	public void testElementTagName() throws IOException, AWTException {
		element = driver.findElement(By.tagName("a"));
		element.click();
	}

	@Test
	public void testElementLinkText() throws IOException, AWTException {
		element = driver.findElement(By.linkText("Søk kunde"));
		element.click();
	}

	@Test
	public void testElementPartialLinkText() throws IOException, AWTException {
		element = driver.findElement(By.partialLinkText("kunde"));
		element.click();
	}

	@After
	public void tearDown() {
		try {
			Thread.sleep(2000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
