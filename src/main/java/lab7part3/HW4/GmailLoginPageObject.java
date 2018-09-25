package lab7part3.HW4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPageObject {

    private WebDriver driver;

    @FindBy(css = "input#identifierId")
    private Input inputLoginField;

    @FindBy(xpath = "//input[@autocomplete = 'current-password']")
    private Input passwordField;

    @FindBy(xpath = "//*[@class = 'gb_he']")
    private WebElement openGoogleApps;

    @FindBy(xpath = "//*[contains(text(), 'Gmail')]")
    private WebElement selectGmail;

    public GmailLoginPageObject(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        this.driver = driver;
    }

    public void gmailLogin(String email, String password) {
        inputLoginField.addText(email);
        inputLoginField.submit();
        passwordField.addText(password);
        passwordField.submit();
    }

    public void openGmail() {
        openGoogleApps.click();
        selectGmail.click();
    }
}
