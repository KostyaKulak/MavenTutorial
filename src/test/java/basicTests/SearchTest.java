package basicTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

public class SearchTest {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @BeforeClass(groups = {"pageTests","search"})
    public void loadState() {
        driver = new FirefoxDriver();
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.open();
    }

    @Test(groups = "pageTests")
    public void pageTest() {
        Assert.assertTrue(googleSearchPage.isExpectedPage("https://www.google.by"));
    }


    @Test(groups = "search")
    public void searchTest() {
        googleSearchPage.search("hello");
    }

    @AfterClass(groups = {"pageTests","search"})
    public void afterClass() {
        driver.quit();
    }
}
