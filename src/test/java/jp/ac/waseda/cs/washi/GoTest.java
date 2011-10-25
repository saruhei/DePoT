package jp.ac.waseda.cs.washi;

import java.lang.reflect.InvocationTargetException;

import jp.ac.waseda.cs.washi.page.AtFirst;
import jp.ac.waseda.cs.washi.page.YahooTopPage;

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
	public void YahooGoTest() throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
		AtFirst starter = new AtFirst(driver);
		YahooTopPage result = starter.goTopPage();
		result.goSearchPage("selenium")
			.goImageSearchPage()
			.goTopPage()
			.goSearchPage("aaa")
			.goRandomPage(result);
	}

}
