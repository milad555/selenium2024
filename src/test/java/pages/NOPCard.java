package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NOPCard extends Page{
    public NOPCard() {
    }

    @FindBy(id = "termsofservice")
    private WebElement tos;


    @FindBy(id = "checkout")
    private WebElement checkout;

    public void acceptTOS(){
        tos.click();
    }

    public void clickCheckout(){
        checkout.click();
    }
}
