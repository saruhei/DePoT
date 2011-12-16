package jp.ac.waseda.cs.washi;

import java.lang.reflect.InvocationTargetException;
import static org.junit.Assert.*;

import jp.ac.waseda.cs.washi.yahoo.AssertFunction;
import jp.ac.waseda.cs.washi.yahoo.AtFirst;
import jp.ac.waseda.cs.washi.yahoo.UnExpectAction;
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
	public void YahooTest() throws SecurityException,
	IllegalArgumentException, NoSuchMethodException,
	IllegalAccessException, InvocationTargetException,
	ClassNotFoundException, InstantiationException  {
		AtFirst starter = new AtFirst(driver);
		starter.goTopPage()
				.goSearchPage("selenium")
				.doAssert(new AssertFunction<YahooSearchResultPage>() {

					@Override
					public void assertPage(YahooSearchResultPage page) {
						assertNotNull(page.returntop);
					}
				})
				.doUnEx(new UnExpectAction<YahooImageSearchResultPage,YahooSearchResultPage>() {

					@Override
					public <T> YahooImageSearchResultPage unExpectAct(
							YahooSearchResultPage t)
							throws ClassNotFoundException {
						assertNotNull(t.returntop);
						t.isearchbtn.click();
						return new YahooImageSearchResultPage(driver, "keyword");
					}
				})
				.goTopPage()
				.goSearchPage("selenium")
				.goTopPage()
				.goImageSearchPage("aaa")
				.goRandomPage();
	}
}
