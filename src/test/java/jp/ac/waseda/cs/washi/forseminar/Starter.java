package jp.ac.waseda.cs.washi.forseminar;

import org.openqa.selenium.WebDriver;

public class Starter {

	private WebDriver driver;

	public Starter(WebDriver driver) {
		this.driver = driver;
	}

	public DePoThomePage goDePoThomePage() throws ClassNotFoundException {
		driver.get("http://localhost:8888/study.localhost/DePoT/sorce/DePoThome.php");
		return new DePoThomePage(driver);
	}
}