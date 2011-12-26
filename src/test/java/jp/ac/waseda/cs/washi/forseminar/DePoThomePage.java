package jp.ac.waseda.cs.washi.forseminar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DePoThomePage extends AbstractPage<DePoThomePage> {

	@FindBy(id =  "GoLogin")
	public WebElement GoLogin;

	@FindBy(id =  "Chat")
	public WebElement Chat;

	@FindBy(id =  "Diary")
	public WebElement Diary;

	@FindBy(id =  "gbbs")
	public WebElement gbbs;

	@FindBy(name =  "passwd")
	public WebElement passwd;

	public DePoThomePage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(),is("DePoT_TestPage_Home")); //make some invariant test if you need
	}

	public LoginPage goGoLogin() throws ClassNotFoundException {
		GoLogin.click();
		return new LoginPage(driver);
	}

	public ChatPage goChat() throws ClassNotFoundException {
		//System.out.println(selenium.getAllFields());
		for(String str : selenium.getAllLinks()){
			System.out.println(str);
		}
		Chat.click();
		return new ChatPage(driver);
	}

	public DiaryPage goDiary() throws ClassNotFoundException {
		Diary.click();
		return new DiaryPage(driver);
	}

	public GbbsPage gogbbs() throws ClassNotFoundException {
		gbbs.click();
		return new GbbsPage(driver);
	}

	/*public InputPageClass goWithPutpasswd() throws ClassNotFoundException {
		passwd.sendKeys("HogeHoge");
		passwd.submit();
		return new InputPageClass(driver);
	}*/

}
