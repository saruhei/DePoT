package jp.ac.waseda.cs.washi.yahoo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import jp.ac.waseda.cs.washi.automake.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class YahooSearchResultPage extends AbstractPage<YahooSearchResultPage>{

	@FindBy(id = "SaB")
	public WebElement returntop;
	@FindBy(id = "isrch")
	public WebElement isearchbtn;

	private final String keyword;

	public YahooSearchResultPage(WebDriver driver, String keyword)
			throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		super(driver);
		this.keyword = keyword;
		// 不変条件のテスト
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(), is("「" + keyword + "」の検索結果 - Yahoo!検索"));
	}

	public YahooTopPage goTopPage() throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		returntop.click();
		return new YahooTopPage(driver);
	}

	public YahooImageSearchResultPage goImageSearchPage()
			throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		isearchbtn.click();
		return new YahooImageSearchResultPage(driver, keyword);
	}
	

}
