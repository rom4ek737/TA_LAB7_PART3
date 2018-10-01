package lab7part3.HW5.BO;

import lab7part3.HW5.PO.CustomFieldDecorator;
import lab7part3.HW5.PO.GmailLoginPO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GmaiLoginBO {

    private WebDriver driver;
    private GmailLoginPO gmailLoginPO;
    private boolean isOpened = false;

    private static final Logger LOGGER = LogManager.getLogger(GmaiLoginBO.class);

    public GmaiLoginBO(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        this.driver = driver;
    }

    public boolean openGmailAccount(String email, String password) {
        gmailLoginPO = new GmailLoginPO(driver);
        LOGGER.info("We are started to open gmail page");
        gmailLoginPO.gmailLogin(email, password);
        LOGGER.info("We typed the login/password!");
        gmailLoginPO.openGmail();
        LOGGER.info("we opened gmail account!!!");
        isOpened = true;
        return isOpened;
    }
}
