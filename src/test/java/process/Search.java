package process;

import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import bean.CustomerBean;

public class Search {

	WebElement element;

	public void searchCustomer(WebDriver driver, CustomerBean bean) throws IOException, AWTException {
		element = driver.findElement(By.id("search"));
		element.click();
		element = driver.findElement(By.id("j_idt8:name"));
		element.sendKeys(bean.getName());
		element = driver.findElement(By.xpath("//*[@id='j_idt8']/input[2]"));
		element.click();
	}
}