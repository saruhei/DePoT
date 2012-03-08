package jp.ac.waseda.cs.washi;

import java.lang.reflect.InvocationTargetException;
import jp.ac.waseda.cs.washi.yahoo.AtFirst;
import jp.ac.waseda.cs.washi.automake.UnExpectAction;
import jp.ac.waseda.cs.washi.yahoo.YahooImageSearchResultPage;
import jp.ac.waseda.cs.washi.yahoo.YahooSearchResultPage;
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
	public void YahooTest() throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, ClassNotFoundException,
			InstantiationException, Exception {
		AtFirst starter = new AtFirst(driver);
		starter.goTopPage()
				.goSearchPage("selenium")
				.doUnEx(new UnExpectAction<YahooImageSearchResultPage, YahooSearchResultPage>() {

					@Override
					public <T> YahooImageSearchResultPage unExpectAct(
							YahooSearchResultPage page)
							throws ClassNotFoundException {
						// TODO Auto-generated method stub
						return null;
					}
				}).goTopPage().goImageSearchPage("aaa").goTopPage();
	}
}
