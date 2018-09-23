package lab7part3.HW3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GmailImportantMessages {

    private static final Logger LOGGER = LogManager.getLogger(GmailImportantMessages.class);
    private WebDriver driver;

    @FindBy(css = "input#identifierId")
    private WebElement inputLoginField;

    @FindBy(xpath = "//input[@autocomplete = 'current-password']")
    private WebElement passwordField;

    @FindBy(css = "#\\:3g > div:nth-child(2)")
    private WebElement checkAsImportant;

    @FindBy(xpath = "//*[@class = 'gb_he']")
    private WebElement openGoogleApps;

    @FindBy(xpath = "//*[contains(text(), 'Gmail')]")
    private WebElement selectGmail;

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

    public GmailImportantMessages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void gmailLogin(String email, String password) {
        LOGGER.info("Starting of gmailLogin method");
        inputLoginField.sendKeys(email);
        inputLoginField.sendKeys(Keys.ENTER);
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
        LOGGER.info("Login method have finished");
    }

    public void openGmail() {
        openGoogleApps.click();
        selectGmail.click();
    }

    public int checkThreeMessages() {
        LOGGER.info("List is emty? " + messages.isEmpty());
        LOGGER.info("List size " + messages.size());
        for (int i = 1; i < 4; i++) {
            messages.get(i).click();
        }
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