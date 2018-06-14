package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Constants.BASE_URL;


public class GoogleSearchPage {
    private static final Logger LOGGER = LogManager.getLogger(GoogleSearchPage.class.getName());

    @FindBy(xpath = "//*[@id=\"lst-ib\"]")
    private WebElement searchField;
    @FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")
    private WebElement searchButton;

    private WebDriver driver;


    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().maximize();
    }

    public GoogleSearchPage open() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public GoogleSearchPage search(String searchString) {
        LOGGER.info("Search for " + searchString);
        searchField.sendKeys(searchString);
        searchButton.click();
        return this;
    }

    public boolean isExpectedPage(String url) {
        LOGGER.debug("Start comparing current page with " + url);
        return driver.getCurrentUrl().contains(url);
    }

    public void refresh() {
        LOGGER.debug("Page " + driver.getCurrentUrl() + " was refreshed");
        driver.navigate().refresh();
    }
}
