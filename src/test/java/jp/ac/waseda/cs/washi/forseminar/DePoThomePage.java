package jp.ac.waseda.cs.washi.forseminar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DePoThomePage extends AbstractPage {

	@FindBy(id =  "GoLogin")
	private WebElement GoLogin;

	@FindBy(id =  "goChat")
	private WebElement goChat;

	@FindBy(id =  "goDiary")
	private WebElement goDiary;

	@FindBy(id =  "gogbbs")
	private WebElement gogbbs;

	public DePoThomePage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(), is("DePoT_TestPage_Home"));
	}
	
	public DePoThomePage assertNotInvariant() throws ClassNotFoundException{
		assertThat(driver.getTitle(),is("DePoT_TestPage_Home"));
		return new DePoThomePage(driver);		
	}
	
	/*public InputPageClass GoLogin() throws ClassNotFoundException {
		GoLogin.click();
		return new InputPageClass(driver);
	}*/

	public ChatPage goChat() throws ClassNotFoundException {
		goChat.click();
		return new ChatPage(driver);
	}

	public DiaryPage goDiary() throws ClassNotFoundException {
		goDiary.click();
		return new DiaryPage(driver);
	}

	public GbbsPage gogbbs() throws ClassNotFoundException {
		gogbbs.click();
		return new GbbsPage(driver);
	}

}
