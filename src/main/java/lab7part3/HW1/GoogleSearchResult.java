package lab7part3.HW1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResult {

    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement query;

    public GoogleSearchResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void search(String str) {
        query.sendKeys(str);
        query.submit();
    }
}