package Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.TestUtils;

public class BasePage {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream file;

	public BasePage() {

		try {

			String filePath = "\\src\\main\\java\\Files\\config.properties";
			file = new FileInputStream(System.getProperty("user.dir") + filePath);
			prop = new Properties();
			prop.load(file);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void initConfig() {

		String browser = prop.getProperty("browserName");

		switch (browser.toLowerCase()) {

		case "chrome":

			driver = new ChromeDriver();
			break;

		case "firefox":

			driver = new FirefoxDriver();
			break;

		case "edge":

			driver = new EdgeDriver();
			break;

		default:

			System.out.println("Unsupported browser...!!!");
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.implicitWaitTimeout));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.pageLoadTimeout));
		System.out.println("Browser lounched...!!");
	}

	public static void closeConfig() {

		if (driver != null) {

			driver.quit();
			System.out.println("Browser closed...!!");
		}

		System.out.println("==================Test Completed Successfully...!!========================");
	}

}
