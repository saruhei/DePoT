package jp.ac.waseda.cs.washi.forseminar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage<LoginPage> {

	@FindBy(name =  "u_id")
	private WebElement u_id;

	@FindBy(name =  "passwd")
	private WebElement passwd;

	public LoginPage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(),is(driver.getTitle())); //make some invariant test if you need
	}

/*	public InputPageClass goWithPutu_id() throws ClassNotFoundException {
		u_id.sendKeys("HogeHoge");
		u_id.submit();
		return new InputPageClass(driver);
	}

	public InputPageClass goWithPutpasswd() throws ClassNotFoundException {
		passwd.sendKeys("HogeHoge");
		passwd.submit();
		return new InputPageClass(driver);
	}
*/
}
