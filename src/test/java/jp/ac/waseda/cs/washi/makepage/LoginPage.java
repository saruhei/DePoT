package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static jp.ac.waseda.cs.washi.assertion.Assertion.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class LoginPage extends AbstractPage<LoginPage> {

	@FindBy(name =  "u_id")
	public WebElement u_id;

	@FindBy(name =  "passwd")
	public WebElement passwd;

	public LoginPage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(),is(driver.getTitle())); //make some invariant test if you need
	}

	public LoginPage goForm0() throws Exception {
		u_id.sendKeys("HogeHoge");
		passwd.sendKeys("HogeHoge");
		return new LoginPage(driver);
	}

}
