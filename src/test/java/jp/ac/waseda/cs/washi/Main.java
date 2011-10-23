package jp.ac.waseda.cs.washi;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import jp.ac.waseda.cs.washi.page.AtFirst;
import jp.ac.waseda.cs.washi.page.YahooSearchResultPage;
import jp.ac.waseda.cs.washi.page.YahooTopPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

		WebDriver driver = new FirefoxDriver();

		AtFirst Page0 = new AtFirst(driver);

		YahooTopPage Page1 = Page0.goTopPage();
		
		YahooSearchResultPage Page2 = Page1.goSearchPage("selenium");
		
		List<String> list = Page2.getGoMethodNames(Page2);
		
		for(int i = 0; i < list.size();i++){
		System.out.println(list.get(i));
		}
		
		Page1.goRandomPage(Page2);

		driver.quit();
	}

}
