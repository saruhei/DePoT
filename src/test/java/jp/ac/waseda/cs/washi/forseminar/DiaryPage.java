package jp.ac.waseda.cs.washi.forseminar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static jp.ac.waseda.cs.washi.assertion.Assertion.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiaryPage extends AbstractPage<DiaryPage> {

	@FindBy(id =  "goHome")
	public WebElement goHome;

	public DiaryPage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(),is("DePoTダイアリー")); //make some invariant test if you need
	}

	public DePoThomePage gogoHome() throws ClassNotFoundException {
		goHome.click();
		return new DePoThomePage(driver);
	}

}
