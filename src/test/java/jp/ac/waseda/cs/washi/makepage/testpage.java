package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class testpage extends AbstractPage {

	@FindBy(id =  "GoLogin")
	private WebElement GoLogin;

	@FindBy(id =  "Chat")
	private WebElement Chat;

	@FindBy(id =  "Diary")
	private WebElement Diary;

	@FindBy(id =  "gbbs")
	private WebElement gbbs;

	@FindBy(name =  "passwd")
	private WebElement passwd;

	public testpage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(),is(driver.getTitle())); //make some invariant test if you need
	}

	public testpage assertNotInvariant() throws ClassNotFoundException{
		assertThat(driver.getTitle(), is(driver.getTitle())); //make some not invariant test if you need
		return new testpage(driver);
	}

	public InputPageClass goGoLogin() throws ClassNotFoundException {
		GoLogin.click();
		return new InputPageClass(driver);
	}

	public InputPageClass goChat() throws ClassNotFoundException {
		Chat.click();
		return new InputPageClass(driver);
	}

	public InputPageClass goDiary() throws ClassNotFoundException {
		Diary.click();
		return new InputPageClass(driver);
	}

	public InputPageClass gogbbs() throws ClassNotFoundException {
		gbbs.click();
		return new InputPageClass(driver);
	}

	public InputPageClass goWithPutpasswd() throws ClassNotFoundException {
		passwd.sendKeys("HogeHoge");
		passwd.submit();
		return new InputPageClass(driver);
	}

}
