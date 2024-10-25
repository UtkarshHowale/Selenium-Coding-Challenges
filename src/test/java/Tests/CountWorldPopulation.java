package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BasePage;
import Utils.TestUtils;

public class CountWorldPopulation extends BasePage {

	public CountWorldPopulation() {

		super();
	}

	@BeforeMethod
	public void setUpMethod() {

		initConfig();
		TestUtils.lounchUrl("https://www.worldometers.info/world-population/");
	}

	@AfterMethod
	public void tearDownMethod() {

		closeConfig();
	}

	By currentPopulation = By.xpath("//div[@class=\"maincounter-number\"]//span[@class=\"rts-counter\"]");
	By todaysPopulation = By.xpath("//div[@class=\"col-sm-6 col-counters\"][1]//div[@class=\"sec-counter\"]");
	By thisYearPopulation = By.xpath("//div[@class=\"col-sm-6 col-counters\"][2]//div[@class=\"sec-counter\"]");

	@Test(priority = 1)
	public void getCurrentWorldPupulation() {

		System.out.println("Fetched current world population.");

		int count = 1;

		while (count <= 20) {

			System.out.println(count + " second");
			if (count == 21)
				break;

			List<WebElement> getCurrentPopulation = TestUtils.getElements(currentPopulation);
			for (WebElement population : getCurrentPopulation) {

				System.out.println(population.getText());
				TestUtils.waitFewSeconds(1000);

			}

			count++;

			System.out.println("=========== Current population count ===========");
		}

		System.out.println("Current world population fecthed successfully.");

	}

	@Test(priority = 2)
	public void getTodaysPopoulation() {

		System.out.println("Fetched todays world population.");

		int count = 1;

		while (count <= 20) {

			System.out.println(count + " second");
			if (count == 21)
				break;

			List<WebElement> getTodaysPopulation = TestUtils.getElements(todaysPopulation);
			for (WebElement population : getTodaysPopulation) {

				System.out.println(population.getText());
				TestUtils.waitFewSeconds(1000);

			}

			count++;

			System.out.println("=========== Todays population count ===========");
		}

		System.out.println("Todays world population fecthed successfully.");
	}

	@Test(priority = 3)
	public void getThisYearsPopulation() {

		System.out.println("Fetched this years world population.");

		int count = 1;

		while (count <= 20) {

			System.out.println(count + " second");
			if (count == 21)
				break;

			List<WebElement> getThisYearPopulation = TestUtils.getElements(todaysPopulation);
			for (WebElement population : getThisYearPopulation) {

				System.out.println(population.getText());
				TestUtils.waitFewSeconds(1000);

			}

			count++;

			System.out.println("=========== This year population count ===========");
		}

		System.out.println("This year world population fecthed successfully.");
	}

}
