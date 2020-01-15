package main;

import java.awt.AWTException;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import bean.ConnectBean;
import bean.CustomerBean;
import junit.framework.TestCase;
import process.Search;

public class SearchTest extends TestCase {

	WebDriver driver;
	Search search = new Search();
	CustomerBean bean = new CustomerBean();
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
	public void test1SearchCustomer() throws IOException, AWTException {
		bean.setName("Kari");
		search.searchCustomer(driver, bean);
	}

	@Test
	public void test2SearchCustomer() throws IOException, AWTException {
		bean.setName("Nina");
		search.searchCustomer(driver, bean);
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
