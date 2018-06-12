import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest {
    protected WebDriverDecorator webDriverDecorator;
    protected GoogleSearchPage googleSearchPage;

    @BeforeClass(groups = {"pagetests","search"})
    public void loadState() {
        webDriverDecorator = new WebDriverDecorator(new FirefoxDriver());
        googleSearchPage = new GoogleSearchPage(webDriverDecorator);
        googleSearchPage.open();
    }

    @Test(groups = "pagetests")
    public void pageTest() {
        Assert.assertTrue(googleSearchPage.isExpectedPage("https://www.google.by"));
    }


    @Test(groups = "search")
    public void searchTest() {
        googleSearchPage.search("hello");
    }

    @AfterClass(groups = {"pagetests","search"})
    public void afterClass() {
        webDriverDecorator.quit();
    }
}
