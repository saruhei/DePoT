package jp.ac.waseda.cs.washi;

import jp.ac.waseda.cs.washi.yahoo.AtFirst;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageFactoryTest {

	private static FirefoxDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void YahooTest() throws ClassNotFoundException {
		AtFirst starter = new AtFirst(driver);
		starter.goTopPage().goSearchPage("selenium").goImageSearchPage()
				.goTopPage().goImageSearchPage("selenium").goTopPage()
				.goImageSearchPage("aaaa");
	}
}
