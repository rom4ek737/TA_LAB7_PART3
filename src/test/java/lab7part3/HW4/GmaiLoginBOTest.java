package lab7part3.HW4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GmaiLoginBOTest {
    private WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger(GmaiLoginBOTest.class);
    private static String ps = PropertySettings.openProperyFile("driverPath");

    static {
        System.setProperty("webdriver.chrome.driver", ps);
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
        LOGGER.info("Test method");
        driver.get(PropertySettings.openProperyFile("webadress"));
        GmailBusinessObject gim = new GmailBusinessObject(driver);
        gim.openGmailAccount(PropertySettings.openProperyFile("email"), PropertySettings.openProperyFile("password"));
        int number = gim.selectAndDeleteImportantMessages();
        Assert.assertTrue(number != 0);
        LOGGER.info("The test method was completed scientifically");
    }

    @AfterMethod
    public void closeDriver() {
        LOGGER.info("After test method have finished!");
        driver.quit();
    }
}