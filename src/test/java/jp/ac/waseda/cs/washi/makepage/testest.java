package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class testest extends AbstractPage {

	@FindBy(id =  "GoLogin")
	private WebElement GoLogin;

	@FindBy(id =  "goChat")
	private WebElement goChat;

	@FindBy(id =  "goDiary")
	private WebElement goDiary;

	@FindBy(id =  "gogbbs")
	private WebElement gogbbs;

	private final String keyword;

	public testest(WebDriver driver, String keyword)
			throws ClassNotFoundException {
		super(driver);
		this.keyword = keyword;
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
	}

	public HogeHoge GoLogin() throws ClassNotFoundException {
		GoLogin.click();
		return new HogeHoge(driver);
	}

	public HogeHoge goChat() throws ClassNotFoundException {
		goChat.click();
		return new HogeHoge(driver);
	}

	public HogeHoge goDiary() throws ClassNotFoundException {
		goDiary.click();
		return new HogeHoge(driver);
	}

	public HogeHoge gogbbs() throws ClassNotFoundException {
		gogbbs.click();
		return new HogeHoge(driver);
	}

}
