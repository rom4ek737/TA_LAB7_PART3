package lab7part3.HW3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GmailImportantMessagesTest {
    private WebDriver driver;
    private GmailImportantMessages gim;

    private static final Logger LOGGER = LogManager.getLogger(GmailImportantMessages.class);
    private static String ps = PropertySettings.openProperyFile("driverPath");

    static {
        System.setProperty("webdriver.chrome.driver", PropertySettings.openProperyFile("driverPath"));
    }

    @BeforeMethod
    public void init() throws IOException {
        LOGGER.info("Before test method");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void openGmailAndDeleteImportantMessages() {
        driver.get(PropertySettings.openProperyFile("webadress"));
        gim = new GmailImportantMessages(driver);
        gim.gmailLogin(PropertySettings.openProperyFile("email"), PropertySettings.openProperyFile("password"));
        gim.openGmail();
        int str = gim.checkThreeMessages();
        gim.openImportantFolder();
        Assert.assertTrue(str != 0);
        boolean bool = gim.deleteLetters();
        Assert.assertTrue(bool);
    }

    @AfterMethod
    public void closeDriver() {
        LOGGER.info("After test method have finished!");
        driver.quit();
    }
}