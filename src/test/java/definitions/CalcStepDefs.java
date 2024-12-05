package definitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Calculator;
import pages.MobPage;
import pages.Page;
import support.DriverFactory;
import io.appium.java_client.AppiumDriver;
public class CalcStepDefs {
    private WebDriver driver;
    public AndroidDriver castAndroid(){
        return ((AndroidDriver) driver);
    }
    Page page = new Page();
    Calculator calc = new Calculator();

    @Given("I open the calculator app")
    public void iOpenTheCalculatorApp() throws InterruptedException {

        calc.tapAgreePerm();
        calc.clickDigit(5);
        calc.tapButton(calc.plusButton);
        calc.clickDigit(5);
        calc.tapButton(calc.equalsButton);

    }

    @Then("I wait for {int} seconds")
    public void iWaitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
