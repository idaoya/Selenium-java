package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import bean.ConnectBean;
import junit.framework.TestCase;

public class DatabaseTest extends TestCase {

	WebDriver driver;
	WebElement element;
	Select select;
	ConnectBean login = new ConnectBean();

	@Before
	public void setUp() throws Exception {
		login.getSystem();
		driver = login.getDriver();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDB() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException,
			InterruptedException {
		element = driver.findElement(By.id("add"));
		element.click();

		String url = "jdbc:mysql://localhost:3306/testdb";
		String dbClass = "com.mysql.jdbc.Driver";
		Class.forName(dbClass).newInstance();
		Connection con = DriverManager.getConnection(url, "root", "");

		Statement stmt = (Statement) con.createStatement();
		ResultSet result = (ResultSet) stmt.executeQuery("select * from customer where customer_id = 1");

		if (result.next()) {
			String name = result.getString("name");
			driver.getCurrentUrl();
			Thread.sleep(2000);
			element = driver.findElement(By.id("j_idt10:name"));
			element.sendKeys(name);
			element = driver.findElement(By.xpath("//*[@id='j_idt10']/input[2]"));
			element.click();
		}
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