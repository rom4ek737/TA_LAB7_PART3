package lab7part3.HW5;

import lab7part3.HW5.BO.GmaiLoginBO;
import lab7part3.HW5.BO.SelectAndDeleteMessagesBO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;

import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GmaiLoginBOTest {

    private WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(GmaiLoginBOTest.class);
    private static String ps = PropertySettings.openProperyFile("driverPath");

    static {
        System.setProperty("webdriver.chrome.driver", ps);
    }

    @BeforeClass
    public void setupClassName(ITestContext context) {
        LOGGER.info("Before class method");
        context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(3);
        context.getCurrentXmlTest().getSuite().setPreserveOrder(false);
        context.getCurrentXmlTest().getSuite().setThreadCount(3);
    }

    @BeforeMethod
    public void init() throws IOException {
        LOGGER.info("Before test method");
        driver = DriverPool.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(PropertySettings.openProperyFile("webadress"));
    }

    @Test(dataProvider = "provider-data", dataProviderClass = DataproviderClass.class, threadPoolSize = 3, timeOut = 10000)
    public void openGmailAndDeleteImportantMessages(String email, String password) {
        LOGGER.info("Test method");
        GmaiLoginBO gim = new GmaiLoginBO(driver);
        assertTrue(gim.openGmailAccount(email, password));
        SelectAndDeleteMessagesBO gdbo = new SelectAndDeleteMessagesBO(driver);
        int number = gdbo.selectAndDeleteImportantMessages();
        assertNotNull(number);
        LOGGER.info("The test method was completed scientifically");
    }

    @AfterMethod
    public void closeDriver() {
        LOGGER.info("After test method have finished!");
        driver.quit();
    }
}