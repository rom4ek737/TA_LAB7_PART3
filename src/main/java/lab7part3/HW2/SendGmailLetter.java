package lab7part3.HW2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalTime;

public class SendGmailLetter {

    private ChromeDriver driver;
    private static String currentTime;

    public SendGmailLetter(ChromeDriver driver) {
        this.driver = driver;
    }

    public void login(String email) {
        driver.get("https://accounts.google.com");
        driver.findElement(By.cssSelector("input#identifierId")).sendKeys(email);
        driver.findElement(By.cssSelector("#identifierNext > content > span")).click();
        driver.findElementByXPath("//input[@autocomplete = 'current-password']").sendKeys("1@3$5^7*9");
        driver.findElementByCssSelector("#passwordNext > content > span").click();
    }

    public void openGmail() {
        driver.findElementByXPath("//*[@class = 'gb_he']").click();
        driver.findElementByXPath("//*[contains(text(), 'Gmail')]").click();
    }

    public void sendLetter() {
        LocalTime localTime = LocalTime.now();
        currentTime = Integer.toString(localTime.getMinute());
        driver.findElementByXPath("//*[@class = 'T-I J-J5-Ji T-I-KE L3']").click();
        driver.findElementByXPath("//textarea[@aria-label = 'Кому']").sendKeys("roman.zdrok@gmail.com");
        driver.findElementByXPath("//input[@name = 'subjectbox']").sendKeys(currentTime);
        driver.findElementByXPath("//*[@role = 'textbox']").sendKeys("Autoreply");
        driver.findElementByXPath("//div[contains(@aria-label, 'Надіслати')]").click();
        driver.findElementByCssSelector("#aso_search_form_anchor > div > input").sendKeys("in:sent");
        driver.findElementByXPath("//*[@id=\"aso_search_form_anchor\"]/button[4]").click();
    }
}