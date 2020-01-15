package main;

import java.awt.AWTException;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import bean.ConnectBean;
import junit.framework.TestCase;

public class AddCustomerTest extends TestCase {

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
	public void testAddCustomer() throws IOException, AWTException, InterruptedException {
		element = driver.findElement(By.id("add"));
		element.click();
		element = driver.findElement(By.id("j_idt10:name"));
		element.sendKeys("Nina");
		element = driver.findElement(By.id("j_idt10:gender:0"));
		element.click();
		element = driver.findElement(By.id("j_idt10:address"));
		element.sendKeys("Oslo 23");
		select = new Select(driver.findElement(By.id("j_idt10:country")));
		select.selectByValue("Norge");
		element = driver.findElement(By.id("j_idt10:receive:0"));
		element.click();
		element = driver.findElement(By.id("j_idt10:receive:1"));
		element.click();
		Thread.sleep(3000);
		element = driver.findElement(By.xpath("//*[@id='j_idt10']/input[2]"));
		element.click();
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
