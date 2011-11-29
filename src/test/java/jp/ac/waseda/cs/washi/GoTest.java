package jp.ac.waseda.cs.washi;

import java.lang.reflect.InvocationTargetException;

import jp.ac.waseda.cs.washi.yahoopage.AtFirst;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoTest {

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
	public void YahooGoTest() throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException,
			ClassNotFoundException, InstantiationException {
		AtFirst starter = new AtFirst(driver);
		starter.goTopPage().goSearchPage("selenium").goImageSearchPage()
				.goTopPage().goSearchPage("aaa").goImageSearchPage()
				.goRandomPage().goRandomPage();

	}

}
