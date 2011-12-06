package jp.ac.waseda.cs.washi.yahoo;

import org.openqa.selenium.WebDriver;

public class AtFirst {

	private WebDriver driver;

	public AtFirst(WebDriver driver) {
		this.driver = driver;
	}

	public YahooTopPage goTopPage() throws ClassNotFoundException {
		driver.get("http://www.yahoo.jp");
		return new YahooTopPage(driver);
	}
}
