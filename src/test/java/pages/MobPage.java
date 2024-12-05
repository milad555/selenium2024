package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import support.DriverFactory;

import java.time.Duration;

public class MobPage {

    protected String url;
    protected String title;
    WebDriver driver;

    public MobPage() {
        driver = DriverFactory.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
    }

    public AndroidDriver castAndroid() {
        return ((AndroidDriver) driver);
    }

    public void tapButton(WebElement button) {
        button.click();
    }

}