package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import support.DriverFactory;

public class Page {

    WebDriver driver;

    public Page() {
        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        driver.get(url);
    }

    public void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public WebElement getByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }
    public void clickButton(String button) {
        getByXpath("//button[text()='" + button + "']").click();
    }
    public void clickButtonByContains(String button) {
        getByXpath("//button[contains(text(),'" + button + "')]").click();
    }
    public void switchToIframe(WebElement element) {
        driver.switchTo().frame(element);
    }
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
    public void switchToWindow(int winNum) {
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[winNum]);

    }
    public void waitFor(int sec) throws InterruptedException {
        Thread.sleep(sec* 1000L);
    }
}
