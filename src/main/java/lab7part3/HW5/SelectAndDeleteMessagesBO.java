package lab7part3.HW5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SelectAndDeleteMessagesBO {
    private WebDriver driver;
    private GmailImportantPO gmailImportantPO;
    private GmailDeleteMessagesPO deleteMessages;
    private static final Logger LOGGER = LogManager.getLogger(SelectAndDeleteMessagesBO.class);

    public SelectAndDeleteMessagesBO(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        this.driver = driver;
    }

    public int selectAndDeleteImportantMessages() {
        gmailImportantPO = new GmailImportantPO(driver);
        deleteMessages = new GmailDeleteMessagesPO(driver);
        LOGGER.info("We are starting to check the important messages");
        int number = gmailImportantPO.checkThreeMessages();
        LOGGER.info("Messages are checked!");
        gmailImportantPO.openImportantFolder();
        LOGGER.info("Folder 'Important' was open!");
        deleteMessages.deleteLetters();
        LOGGER.info("The letters have been deleted!");
        return number;
    }
}
