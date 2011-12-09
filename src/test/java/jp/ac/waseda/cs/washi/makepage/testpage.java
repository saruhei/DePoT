package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class testpage extends AbstractPage {

	@FindBy(id =  "GoLogin")
	private WebElement GoLogin;

	@FindBy(id =  "goChat")
	private WebElement goChat;

	@FindBy(id =  "goDiary")
	private WebElement goDiary;

	@FindBy(id =  "gogbbs")
	private WebElement gogbbs;

	public testpage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		//assertThat(testword,is(testword));	}

	public InputPageClass goGoLogin() throws ClassNotFoundException {
		GoLogin.click();
		return new InputPageClass(driver);
	}

	public InputPageClass gogoChat() throws ClassNotFoundException {
		goChat.click();
		return new InputPageClass(driver);
	}

	public InputPageClass gogoDiary() throws ClassNotFoundException {
		goDiary.click();
		return new InputPageClass(driver);
	}

	public InputPageClass gogogbbs() throws ClassNotFoundException {
		gogbbs.click();
		return new InputPageClass(driver);
	}

}
