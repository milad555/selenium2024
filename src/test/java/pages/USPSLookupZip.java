package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testDataClasses.CompanyData;

public class USPSLookupZip extends Page{


    public USPSLookupZip() {
        url = "https://tools.usps.com/zip-code-lookup.htm";
        title = "ZIP Code™ Lookup | USPS";
    }
    @FindBy(xpath = "//input[@id='tCompany']")
    private WebElement companyName;
    @FindBy(xpath = "//input[@id='tAddress']")
    private WebElement address;
    @FindBy(xpath = "//input[@id='tCity']")
    private WebElement city;
    @FindBy(xpath = "//select[@id='tState']")
    private WebElement state;
    @FindBy(xpath = "//input[@id='tApt']")
    private WebElement apt;
    @FindBy(xpath = "//div[@class='zipcode-result-address']/p/strong")
    public WebElement zipCode;

    CompanyData portnov = new CompanyData(
            "Portnov Computer School",
            "830 Stewart drive",
            "Sunnyvale",
            "CA - California",
            "106"
    );

    public void fillPortnovData() {
        fillOutField(address, portnov.getStreetAddress());
        fillOutField(city, portnov.getCity());
        selectByVisibleText(state, portnov.getState());
        //fillOutField(state, portnov.getState());
        fillOutField(apt, portnov.getSuite());
    }


    public void hoverAndSearch(String text) {
//        hoverOver()
    }
}
