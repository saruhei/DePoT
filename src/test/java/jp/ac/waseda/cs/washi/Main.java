package jp.ac.waseda.cs.washi;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import jp.ac.waseda.cs.washi.yahoopage.AtFirst;
import jp.ac.waseda.cs.washi.yahoopage.YahooSearchResultPage;
import jp.ac.waseda.cs.washi.yahoopage.YahooTopPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException,
			SecurityException, IllegalArgumentException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {

		WebDriver driver = new FirefoxDriver();

		AtFirst page0 = new AtFirst(driver);

		YahooTopPage page1 = page0.goTopPage();

		YahooSearchResultPage page2 = page1.goSearchPage("selenium");

		List<String> list = page2.getGoMethodNames(page2);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		page2.goRandomPage();

		driver.quit();
	}

}
