package lab7part3.HW5.PO;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GmailImportantPO {

    private WebDriver driver;

    public GmailImportantPO(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        this.driver = driver;
    }

    @FindAll({
            @FindBy(css = "div.pG")
    })
    private List<WebElement> messages;

    @FindBy(css = "#aso_search_form_anchor > div > input")
    private WebElement searchField;

    @FindBy(css = ".T-Jo.J-J5-Ji.T-Jo-auq.T-Jo-iAfbIe")
    private WebElement selectThreeLetters;

    @FindBy(css = "#\\3a 9z > span > span:nth-child(1) > span:nth-child(2)")
    private WebElement importantLetters;

    public int checkThreeMessages() {

        System.out.println(messages.size());
        for (int i = 0; i < 3; i++) {
            //int k = 0;
            //driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
           // if (messages.get(i).isSelected())
            //messages.get(i + 1).click();
            messages.get(i).click();
        }

        return messages.size();
    }

    public void openImportantFolder() {
        searchField.sendKeys("is:important");
        searchField.sendKeys(Keys.ENTER);
    }
}
