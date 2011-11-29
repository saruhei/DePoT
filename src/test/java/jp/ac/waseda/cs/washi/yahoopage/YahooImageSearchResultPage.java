package jp.ac.waseda.cs.washi.yahoopage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooImageSearchResultPage extends AbstractPage {

	@FindBy(id = "SaB")
	private WebElement returntop;
	@FindBy(id = "srch")
	private WebElement searchbtn;

	private final String keyword;

	public YahooImageSearchResultPage(WebDriver driver, String keyword)
			throws ClassNotFoundException {
		super(driver);
		this.keyword = keyword;
		// 不変条件のテスト
		assertInvariant();
	}

	@Override
	protected void assertInvariant() {
		assertThat(driver.getTitle(), is("「" + keyword
				+ "」の検索結果 - Yahoo!検索（画像）"));
	}

	public YahooTopPage goTopPage() throws ClassNotFoundException {
		returntop.click();
		return new YahooTopPage(driver);
	}

	public YahooSearchResultPage goSearchPage() throws ClassNotFoundException {
		searchbtn.click();
		return new YahooSearchResultPage(driver, keyword);
	}
}
