package jp.ac.waseda.cs.washi.makepage;


import org.openqa.selenium.WebDriver;

public class Starter {

	private WebDriver driver;

	public Starter(WebDriver driver) {
		this.driver = driver;
	}

	public InputClassName goFirstPage() throws ClassNotFoundException {
		driver.get("http:// url"); //input url which is start of test
		return new InputClassName(driver);
	}
}
