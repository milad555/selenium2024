package pages;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    AndroidDriver androidDriver;

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


    //clicks
    public void clickButton(String button) {
        try {
            getByXpath("//button[text()='" + button + "']").click();
        } catch (NoSuchElementException e) {
            System.out.println("Primary button not found, trying fallback XPath...");
            getByXpath("//button[normalize-space(text())='" + button + "']").click();
        }
    }
    public void clickButtonByContains(String button) {
        getByXpath("//button[contains(text(),'" + button + "')]").click();
    }
    public void clickOnLink(String link) {
        waitForClickable(getByXpath("//a[text()='" + link + "']"));
        getByXpath("(//a[contains(text(),'" + link + "')])[1]").click();
    }
    public void clickByText(String text) {
        elementByText(text).click();
    }

    public void clickWebElement(WebElement element){
        waitForClickable(element);
        element.click();
    }

    //elements

    public WebElement elementByText(String element) {
        return getByXpath("(//*[text()='" + element + "'])[1]");
    }

    public WebElement linkElement(String elementText){
        return getByXpath("(//a[text()='"+elementText+"'])[1]");
    }

    //iframes
    public void switchToIframe(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    //window handling
    public void switchToWindow(int winNum) {
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[winNum]);
    }
    public void test(){
        System.out.println("test");
    }

    public String randomString(int numOfLetters) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder randomText = new StringBuilder(5);
        for (int i = 0; i <= 5; i++) {
            randomText.append(characters.charAt(random.nextInt(characters.length())));
        }
        return randomText.toString();
    }

    //waits
    public void waitFor(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000L);
    }

    public void waitForVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean elementTextPresent(WebElement element, String text) {
        waitForVisible(element);
        return element.getText().contains(text);
    }

    //actions
    public void hoverOver(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

    }

    //fillOuts
    public void fillOutField(WebElement element, String text) {
        element.sendKeys(text);
    }
}
