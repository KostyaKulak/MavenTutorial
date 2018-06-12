import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;


public class GoogleSearchPage {
    protected static final Logger LOGGER = LogManager.getLogger(GoogleSearchPage.class.getName());
    @FindBy(xpath = "//*[@id=\"lst-ib\"]")
    private WebElement searchField;
    @FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")
    private WebElement searchButton;
    public static final String BASE_URL = "https://www.google.by";
    protected WebDriverDecorator webDriverDecorator;
    protected JSExecutor jsExecutor;


    public GoogleSearchPage(WebDriverDecorator webDriverDecorator) {
        this.webDriverDecorator = webDriverDecorator;
        this.jsExecutor = new JSExecutor(webDriverDecorator);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriverDecorator)), this);

    }

    public GoogleSearchPage open() {
        webDriverDecorator.navigate().to(BASE_URL);
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
        return webDriverDecorator.getCurrentUrl().contains(url);
    }

    public void refresh() {
        LOGGER.debug("Page " + webDriverDecorator.getCurrentUrl() + " was refreshed");
        webDriverDecorator.navigate().refresh();
    }


}
