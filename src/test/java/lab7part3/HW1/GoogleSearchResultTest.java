package lab7part3.HW1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSearchResultTest {
    WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void equalResult() {
        driver.get("https://google.com");
        GoogleSearchResult gsr = new GoogleSearchResult(driver);
        String searchKey = "Apple";
        gsr.search(searchKey);
        Assert.assertTrue(gsr.getTitle().contains(searchKey));
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}