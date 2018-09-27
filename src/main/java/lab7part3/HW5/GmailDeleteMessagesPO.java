package lab7part3.HW5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailDeleteMessagesPO {
    private WebDriver driver;

    public GmailDeleteMessagesPO(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        this.driver = driver;
    }

    @FindBy(css = "#\\3a 8o > div.J-J5-Ji.J-JN-M-I-Jm > span")
    private WebElement selectForDelete;

    @FindBy(xpath = "//*[@id=\":5\"]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]")
    private WebElement delete;


    public boolean deleteLetters() {
        selectForDelete.click();
        delete.click();
        return selectForDelete.isEnabled();
    }
}
