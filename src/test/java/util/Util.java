package util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	final static Logger logger = Logger.getLogger(Util.class);

	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	Select select;
	Properties prop = new Properties();

	public Properties loadProp(String filename) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = Util.class.getClassLoader().getResourceAsStream(filename);
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop;
	}

	public void runRobot() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(5000);
	}

	public WebDriver switchToNewWindow(int windowNumber, WebDriver driver) {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite = s.iterator();
		int i = 1;

		while (ite.hasNext() && i < 10) {
			String popupHandle = ite.next().toString();
			driver.switchTo().window(popupHandle);
			driver.manage().window().maximize();

			System.out.println("Window title=====" + driver.getTitle());

			if (i == windowNumber) {
				System.out.println("Window number=====" + i);
				break;
			}

			i++;
		}

		return driver;
	}

	public String genCode() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		Date date = calendar.getTime();
		String formattedDate = new SimpleDateFormat("yyMMddHHmmss").format(date);
		System.out.println("genCode=====" + formattedDate);
		return formattedDate;
	}

	public boolean isAlert(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
