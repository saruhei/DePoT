package jp.ac.waseda.cs.washi.makepage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import jp.ac.waseda.cs.washi.automake.AbstractPage;

public class GbbsPage extends AbstractPage<GbbsPage> {

	@FindBy(id = "goHome")
	public WebElement goHome;

	@FindBy(id = "radioblue")
	public WebElement radioblue;

	@FindBy(id = "radiored")
	public WebElement radiored;

	@FindBy(id = "radiogreen")
	public WebElement radiogreen;

	@FindBy(id = "radiobrown")
	public WebElement radiobrown;

	@FindBy(id = "radiopurple")
	public WebElement radiopurple;

	@FindBy(id = "delpass")
	public WebElement delpass;

	@FindBy(id = "redelpass")
	public WebElement redelpass;

	@FindBy(name = "tag")
	public WebElement tag;

	@FindBy(name = "delcode")
	public WebElement delcode;

	@FindBy(name = "recheckdelcode")
	public WebElement recheckdelcode;

	@FindBy(name = "name")
	public WebElement name;

	@FindBy(name = "email")
	public WebElement email;

	@FindBy(name = "hp")
	public WebElement hp;

	@FindBy(name = "pass")
	public WebElement pass;

	@FindBy(name = "subject")
	public WebElement subject;

	@FindBy(name = "comment")
	public WebElement comment;

	@FindBy(name = "upfile")
	public WebElement upfile;

	@FindBy(name = "upfile2")
	public WebElement upfile2;

	@FindBy(name = "upfile3")
	public WebElement upfile3;

	@FindBy(css = "input[value = \"書き込みor更新\"]")
	public WebElement 書き込みor更新;

	@FindBy(id = "delete")
	public WebElement delete;

	@FindBy(css = "input[value = \"返信\"]")
	public WebElement 返信;

	@FindBy(id = "redelete")
	public WebElement redelete;

	public GbbsPage(WebDriver driver) throws ClassNotFoundException {
		super(driver);
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(), is(driver.getTitle())); // make some
																// invariant
																// test if you
																// need
	}

	public DePoThome gogoHome() throws ClassNotFoundException {
		goHome.click();
		return new DePoThome(driver);
	}

	public GbbsPage goForm0() throws Exception {
		radioblue.click();
		radiored.click();
		radiogreen.click();
		radiobrown.click();
		radiopurple.click();
		tag.click();
		name.sendKeys("HogeHoge");
		email.sendKeys("HogeHoge");
		hp.sendKeys("HogeHoge");
		pass.sendKeys("HogeHoge");
		subject.sendKeys("HogeHoge");
		comment.sendKeys("HogeHoge");
		upfile.sendKeys("HogeHoge");
		upfile2.sendKeys("HogeHoge");
		upfile3.sendKeys("HogeHoge");
		書き込みor更新.submit();
		return new GbbsPage(driver);
	}

	public GbbsPage goForm1() throws Exception {
		delcode.click();
		delpass.sendKeys("HogeHoge");
		delete.submit();
		return new GbbsPage(driver);
	}

	public GbbsPage goForm2() throws Exception {
		返信.submit();
		return new GbbsPage(driver);
	}

	public GbbsPage goForm3() throws Exception {
		recheckdelcode.click();
		redelpass.sendKeys("HogeHoge");
		redelete.submit();
		return new GbbsPage(driver);
	}

}
