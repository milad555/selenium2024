package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.DriverFactory;

import java.time.Duration;
import java.util.Random;

public class Page {

    protected String url;
    protected String title;
    WebDriver driver;

    public Page() {
        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        driver.get(url);
    }

    public void open() {
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
        Thread.sleep(sec * 1000L);
    }

    public String randomString(int numOfLetters) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder randomText = new StringBuilder(5);
        for (int i = 0; i <= 5; i++) {
            randomText.append(characters.charAt(random.nextInt(characters.length())));
        }return randomText.toString();
    }


    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
