package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.DriverFactory;

public class CareerLogin {
    public CareerLogin() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    QuoteForm quote = new QuoteForm();

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement username;

    public void fillOutUsername(String name) {
        username.sendKeys(name);

    }

    public void fillOutPassword(String pass) {
        password.sendKeys(pass);
    }

}
