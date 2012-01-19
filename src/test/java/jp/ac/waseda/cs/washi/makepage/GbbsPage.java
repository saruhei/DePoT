package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static jp.ac.waseda.cs.washi.assertion.Assertion.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class GbbsPage extends AbstractPage<GbbsPage> {

	@FindBy(id =  "goHome")
	public WebElement goHome;

	@FindBy(name =  "scolor")
	public WebElement scolor;

	@FindBy(name =  "scolor")
	public WebElement scolor;

	@FindBy(name =  "scolor")
	public WebElement scolor;
	

	@FindBy(name =  "scolor")
	public WebElement scolor;

	@FindBy(name =  "scolor")
	public WebElement scolor;

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
		scolor.click();
		scolor.click();
		scolor.click();
		scolor.click();
		scolor.click();
		tag.click();
		name.sendKeys("HogeHoge");
		email.sendKeys("HogeHoge");
		hp.sendKeys("HogeHoge");
		pass.sendKeys("HogeHoge");
		subject.sendKeys("HogeHoge");
		comment.sendKeys("HogeHoge");
		return new GbbsPage(driver);
	}

}
