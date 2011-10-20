package jp.ac.waseda.cs.washi;

import java.util.List;

import jp.ac.waseda.cs.washi.page.AtFirst;
import jp.ac.waseda.cs.washi.page.YahooTopPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {

		WebDriver driver = new FirefoxDriver();

		AtFirst Page0 = new AtFirst(driver);

		YahooTopPage Page1 = Page0.goTopPage();
		
		List<String> list = Page1.getGoMethodNames(Page1);
		
		for(int i = 0; i < list.size();i++){
		System.out.println(list.get(i));
		}

		driver.quit();
	}

}
