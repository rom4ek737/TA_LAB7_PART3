package lab7part3.HW4;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Input extends Element {
    public Input(WebElement webElement) {
        super(webElement);
    }

    public void addText(String s) {
        webElement.sendKeys(s);
    }

    public void submit() {
        webElement.sendKeys(Keys.ENTER);
    }
}
