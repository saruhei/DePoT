package jp.ac.waseda.cs.washi.test_PO_test1;


import org.openqa.selenium.WebDriver;

public class Starter {

	private WebDriver driver;

	public Starter(WebDriver driver) {
		this.driver = driver;
	}

	public MainPage goFirstPage() throws ClassNotFoundException {
		driver.get("http://develop.saruhei.com"); //input url which is start of test
		return new MainPage(driver);
	}
}
