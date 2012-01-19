package jp.ac.waseda.cs.washi.makepage;


import org.openqa.selenium.WebDriver;

public class Starter {

	private WebDriver driver;

	public Starter(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage goFirstPage() throws ClassNotFoundException {
		driver.get("http://localhost:8888/study.localhost/DePoT/sorce/Login.php"); //input url which is start of test
		return new LoginPage(driver);
	}
}
