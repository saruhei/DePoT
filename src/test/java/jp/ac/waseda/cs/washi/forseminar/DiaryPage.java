package jp.ac.waseda.cs.washi.forseminar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiaryPage extends AbstractPage {

	@FindBy(id =  "goHome")
	private WebElement goHome;

	public DiaryPage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
	}

	public DePoThomePage goHome() throws ClassNotFoundException {
		goHome.click();
		return new DePoThomePage(driver);
	}

}
