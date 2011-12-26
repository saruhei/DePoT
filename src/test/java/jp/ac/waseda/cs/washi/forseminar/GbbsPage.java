package jp.ac.waseda.cs.washi.forseminar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GbbsPage extends AbstractPage<GbbsPage> {

	@FindBy(id =  "goHome")
	private WebElement goHome;

	@FindBy(name =  "name")
	private WebElement name;

	@FindBy(name =  "email")
	private WebElement email;

	@FindBy(name =  "hp")
	private WebElement hp;

	@FindBy(name =  "subject")
	private WebElement subject;

	public GbbsPage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(),is("画像掲示板")); //make some invariant test if you need
	}

	public DePoThomePage gogoHome() throws ClassNotFoundException {
		goHome.click();
		return new DePoThomePage(driver);
	}

	/*public InputPageClass goWithPutname() throws ClassNotFoundException {
		name.sendKeys("HogeHoge");
		name.submit();
		return new InputPageClass(driver);
	}

	public InputPageClass goWithPutemail() throws ClassNotFoundException {
		email.sendKeys("HogeHoge");
		email.submit();
		return new InputPageClass(driver);
	}

	public InputPageClass goWithPuthp() throws ClassNotFoundException {
		hp.sendKeys("HogeHoge");
		hp.submit();
		return new InputPageClass(driver);
	}

	public InputPageClass goWithPutsubject() throws ClassNotFoundException {
		subject.sendKeys("HogeHoge");
		subject.submit();
		return new InputPageClass(driver);
	}*/

}
