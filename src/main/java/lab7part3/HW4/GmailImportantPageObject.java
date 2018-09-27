package lab7part3.HW4;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GmailImportantPageObject {

    private WebDriver driver;
    List<WebElement> checkedMessages;

    public GmailImportantPageObject(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        this.driver = driver;
    }

    @FindAll({
            @FindBy(css = "div.pH-A7.a9q")
    })
    private List<WebElement> messages;

    @FindBy(css = "#aso_search_form_anchor > div > input")
    private WebElement searchField;

    @FindBy(css = ".T-Jo.J-J5-Ji.T-Jo-auq.T-Jo-iAfbIe")
    private WebElement selectThreeLetters;

    @FindBy(css = "#\\3a 9z > span > span:nth-child(1) > span:nth-child(2)")
    private WebElement importantLetters;

    @FindBy(css = "#\\3a 8o > div.J-J5-Ji.J-JN-M-I-Jm > span")
    private WebElement selectForDelete;

    @FindBy(xpath = "//*[@id=\":5\"]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]")
    private WebElement delete;

    public int checkThreeMessages() {
        for (int i = 0; i < messages.size(); i++) {
                messages.get(i).click();
        }
        System.out.println(messages.size());
        return messages.size();
    }

    public void openImportantFolder() {
        searchField.sendKeys("is:important");
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean deleteLetters() {
        selectForDelete.click();
        delete.click();
        return selectForDelete.isEnabled();
    }
}
