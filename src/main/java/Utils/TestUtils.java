package Utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BasePage;

public class TestUtils extends BasePage {

	public static long implicitWaitTimeout = 20;
	public static long pageLoadTimeout = 20;
	public static WebDriverWait wait;
	public static Actions action;

	public static void lounchUrl(String inputUrl) {

		driver.get(inputUrl);
		System.out.println("Url has lounched..!!");
	}

	public static String getCurrentPageTitle() {

		String title = driver.getTitle();
		System.out.println("Current web page title is: " + title);
		return title;
	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {

		return driver.findElements(locator);
	}

	public static void clickElement(By locator) {

		driver.findElement(locator).click();
	}

	public static void enterInput(By locator, String keys) {

		driver.findElement(locator).sendKeys(keys);
	}

	public static String getText(By locator) {

		return driver.findElement(locator).getText();
	}

	public static void waitUntilVisibilityOfEelement(By locator, long time) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitUntilElementToBeClickable(By locator, long time) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitFewSeconds(long time) {

		try {

			Thread.sleep(time);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void mouseHoverAndClick(WebElement element) {
		
		action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	public static void enterInputAndSend(WebElement element, String keys) {

		action = new Actions(driver);
		action.moveToElement(element).sendKeys(keys, Keys.ENTER).build().perform();
	}

	public static void doubleClick(WebElement element) {

		action = new Actions(driver);
		action.moveToElement(element).doubleClick().build().perform();
	}

	public static void enterInputAndArrowDownAndEnter(WebElement element, String keys) {

		action = new Actions(driver);
		action.moveToElement(element).sendKeys(keys).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
}
