package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static jp.ac.waseda.cs.washi.assertion.Assertion.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class ChatPage extends AbstractPage<ChatPage> {

	@FindBy(id =  "goHome")
	public WebElement goHome;

	@FindBy(name =  "ncolorblue")
	public WebElement ncolorblue;

	@FindBy(name =  "ncolorred")
	public WebElement ncolorred;

	@FindBy(name =  "ncolorgreen")
	public WebElement ncolorgreen;

	@FindBy(name =  "ncolorbrown")
	public WebElement ncolorbrown;

	@FindBy(name =  "ncolorpurple")
	public WebElement ncolorpurple;

	@FindBy(name =  "name")
	public WebElement name;

	@FindBy(name =  "message")
	public WebElement message;

	@FindBy(name =  "refresh")
	public Select refresh;

	@FindBy(name =  "Submit")
	public WebElement Submit;

	public ChatPage(WebDriver driver)
			throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(),is(driver.getTitle())); //make some invariant test if you need
	}

	public DePoThome gogoHome() throws ClassNotFoundException {
		goHome.click();
		return new DePoThome(driver);
	}

	public ChatPage goForm0() throws Exception {
		ncolorblue.click();
		ncolorred.click();
		ncolorgreen.click();
		ncolorbrown.click();
		ncolorpurple.click();
		name.sendKeys("HogeHoge");
		message.sendKeys("HogeHoge");
		refresh.selectByValue("60");
		refresh.selectByValue("45");
		refresh.selectByValue("30");
		Submit.submit();
		return new ChatPage(driver);
	}

}
