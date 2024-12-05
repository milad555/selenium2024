package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class USPSPriority extends Page {


    public USPSPriority() {
        url = "https://www.usps.com/ship/priority-mail.htm";
        title = "Priority Mail | USPS";
    }

    @FindBy(xpath = "//div[@id='sign-in-wrap']/h2")
    public WebElement alreadyHaveAccount;



}
