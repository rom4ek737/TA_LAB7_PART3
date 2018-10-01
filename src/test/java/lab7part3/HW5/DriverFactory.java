package lab7part3.HW5;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
    private RemoteWebDriver driver;

    RemoteWebDriver getDriver() {
        driver = new ChromeDriver();
        return driver;
    }
}
