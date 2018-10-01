package lab7part3.HW5;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class DataproviderClass {
    private static ChromeDriver driver;

    @DataProvider(name = "provider-data", parallel = true)
    public static Object[][] userData() {
        return new Object[][]{
                {"roman.zdrok.test", "1@3$5^7*9"},
                {"roman.zdrok.test2", "1@3$5^7*9"},
                {"roman.zdrok.test3", "1@3$5^7*9"},
                {"roman.zdrok.test4", "1@3$5^7*9"},
                {"roman.zdrok.test5", "1@3$5^7*9"}};
    }
}
