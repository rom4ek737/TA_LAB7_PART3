package lab7part3.HW2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class SendGmailLetterTest {
    private ChromeDriver driver;
    private SendGmailLetter sendGmailLetter;
    private static LocalTime localTime;
    private String minutes;

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        localTime = LocalTime.now();
    }

    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void gmailLogin() {
        sendGmailLetter = new SendGmailLetter(driver);
        sendGmailLetter.login("roman.zdrok.test");
        sendGmailLetter.openGmail();
        minutes = Integer.toString(localTime.getMinute());
        sendGmailLetter.sendLetter();
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
