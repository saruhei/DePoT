package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static jp.ac.waseda.cs.washi.assertion.Assertion.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class GbbsPage extends AbstractPage<GbbsPage> {

	@FindBy(id =  "goHome")
	public WebElement goHome;

	@FindBy(name =  "scolorblue")
	public WebElement scolorblue;

	@FindBy(name =  "scolorred")
	public WebElement scolorred;

	@FindBy(name =  "scolorgreen")
	public WebElement scolorgreen;

	@FindBy(name =  "scolorbrown")
	public WebElement scolorbrown;

	@FindBy(name =  "scolorpurple")
	public WebElement scolorpurple;

	@FindBy(name =  "tag")
	public WebElement tag;

	@FindBy(name =  "name")
	public WebElement name;

	@FindBy(name =  "email")
	public WebElement email;

	@FindBy(name =  "hp")
	public WebElement hp;

	@FindBy(name =  "pass")
	public WebElement pass;

	@FindBy(name =  "subject")
	public WebElement subject;

	@FindBy(name =  "comment")
	public WebElement comment;

	@FindBy(css =  "input[value = \"書き込み／更新\"]")
	public WebElement 書き込み／更新;

	public GbbsPage(WebDriver driver)
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

	public GbbsPage goForm0() throws Exception {
		scolorblue.click();
		scolorred.click();
		scolorgreen.click();
		scolorbrown.click();
		scolorpurple.click();
		tag.click();
		name.sendKeys("HogeHoge");
		email.sendKeys("HogeHoge");
		hp.sendKeys("HogeHoge");
		pass.sendKeys("HogeHoge");
		subject.sendKeys("HogeHoge");
		comment.sendKeys("HogeHoge");
		書き込み／更新.submit();
		return new GbbsPage(driver);
	}

}
