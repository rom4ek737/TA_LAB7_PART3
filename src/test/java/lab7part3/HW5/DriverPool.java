package lab7part3.HW5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPool {

    private DriverPool() {

    }

    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            return new ChromeDriver();
        }

        @Override
        public void remove() {
            WebDriver driver = get();
            if (driver != null) driver.close();
            super.remove();
        }

        @Override
        public void set(WebDriver value) {
            throw new UnsupportedOperationException();
        }
    };

    public static final WebDriver getDriver() {
        return drivers.get();
    }
}