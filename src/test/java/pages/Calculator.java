package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Calculator extends MobPage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
    private WebElement agreePermissionButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.miui.calculator:id/op_add\")")
    public WebElement plusButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.miui.calculator:id/btn_equal_s\")")
    public WebElement equalsButton;

    public void tapAgreePerm() {
        tapButton(agreePermissionButton);
    }

    public void clickDigit(int digit) {
         driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_" + digit + "")).click();
    }
}