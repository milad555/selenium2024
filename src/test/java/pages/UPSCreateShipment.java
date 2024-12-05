package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testDataClasses.UserData;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class UPSCreateShipment extends Page {

    @FindBy(xpath = "//h2[contains(text(),'Try our Simplified Shipping Experience')]")
    private WebElement upsModalWindow;

    @FindBy(xpath = "//button[@data-dismiss='modal']")
    private WebElement closeModalWindow;

    @FindBy(xpath = "//button[@class='close_btn_thick']")
    private WebElement closePrivacyPopUpButton;

    //Ship From Xpaths
    @FindBy(xpath = "//button[@id='btn_ShippingSummaryOriginAdd-country']")
    private WebElement originCountry;

    @FindBy(xpath = "//input[@id='ShippingSummaryOriginAdd-Name']")
    private WebElement originFullName;

    @FindBy(xpath = "//input[@id='ShippingSummaryOriginAdd-Postal']")
    private WebElement originZip;

    @FindBy(xpath = "//input[@id='ShippingSummaryOriginAdd-Email']")
    private WebElement originEmail;

    @FindBy(xpath = "//input[@id='ShippingSummaryOriginAdd-Phone']")
    private WebElement originPhone;

    @FindBy(xpath = "//input[contains(@id,'ShippingSummaryOriginAdd-Address')]")
    private WebElement originAddress;

    @FindBy(xpath = "//input[@id='ShippingSummaryOriginAdd-City']")
    private WebElement originCity;

    @FindBy(xpath = "//button[@id='btn_ShippingSummaryOriginAddStateDropdown']")
    private WebElement originState;

    @FindBy(xpath = "(//button[@id='btn_ShippingSummaryOriginAdd-country']/span)[1]")
    private WebElement originCountryText;

    //Ship To Xpaths
    @FindBy(xpath = "//button[@id='btn_ShippingSummaryDestinationAdd-country']")
    private WebElement receiverCountry;

    @FindBy(xpath = "//input[@id='ShippingSummaryDestinationAdd-Name']")
    private WebElement receiverFullName;

    @FindBy(xpath = "//input[@id='ShippingSummaryDestinationAdd-Email']")
    private WebElement receiverEmail;

    @FindBy(xpath = "//input[@id='ShippingSummaryDestinationAdd-Phone']")
    private WebElement receiverPhone;

    @FindBy(xpath = "//input[contains(@id,'ShippingSummaryDestinationAdd-Address')]")
    private WebElement receiverAddress;

    @FindBy(xpath = "//input[@id='ShippingSummaryDestinationAdd-Postal']")
    private WebElement receiverZip;

    //Package Xpaths
    @FindBy(xpath = "//input[@id='ShippingSummaryOriginAdd-Weight']")
    private WebElement packageWeight;

    @FindBy(xpath = "//input[@id='ShippingSummaryOriginAdd-Length']")
    private WebElement packageLength;

    @FindBy(xpath = "//input[@id='ShippingSummaryOriginAdd-Width']")
    private WebElement packageWidth;

    @FindBy(xpath = "//input[@id='ShippingSummaryOriginAdd-Height']")
    private WebElement packageHeight;

    //Shippers summary details
    @FindBy(xpath = "//div[@id='shippingSummaryOriginName'][1]")
    private WebElement shipperSummaryName;

    @FindBy(xpath = "//div[@id='shippingSummaryOriginEmail']")
    private WebElement shipperSummaryEmail;

    @FindBy(xpath = "//div[@id='shippingSummaryOriginPhone']")
    private WebElement shipperSummaryPhone;

    @FindBy(xpath = "//div[@id='shippingSummaryOriginAddressLine1']")
    private WebElement shipperAddressLine1;

    @FindBy(xpath = "//div[@id='shippingSummaryOriginAddressLine2']")
    private WebElement shipperAddressLine2;

    @FindBy(xpath = "//div[@id='shippingSummaryOriginCityStatePostalCode']")
    private WebElement shipperCityStatePostalCode;

    //Receiver summary details

    @FindBy(xpath = "//div[@id='shippingSummaryDestinationName'][1]")
    private WebElement receiverSummaryNameFirst;

    @FindBy(xpath = "//div[@id='shippingSummaryDestinationEmail']")
    private WebElement receiverSummaryEmail;

    @FindBy(xpath = "//div[@id='shippingSummaryDestinationPhone']")
    private WebElement receiverSummaryPhone;

    @FindBy(xpath = "//div[@id='shippingSummaryDestinationAddressLine1']")
    private WebElement receiverSummaryAddressLine1;

    @FindBy(xpath = "//div[@id='shippingSummaryDestinationAddressLine2']")
    private WebElement receiverSummaryAddressLine2;

    @FindBy(xpath = "//div[@id='shippingSummaryDestinationCityStatePostalCode']")
    private WebElement receiverSummaryCityStatePostalCode;

    public UPSCreateShipment() {
        url = "https://www.ups.com/ship/basic/shipment-info";
        title = "UPS Shipping";
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    UserData senderUser = new UserData.UserDataBuilder()
            .setFirstName("John")
            .setMiddleName("M.")
            .setLastName("Doe")
            .setEmail("john.doe@example.com")
            .setPhone("646-555-1234")
            .setStreetAddress("508 Las Palmas Dr")
            .setCity("Irvine")
            .setCountry("United States")
            .setState("California")
            .setZip("92602")
            .build();

    UserData receiverUser = new UserData.UserDataBuilder()
            .setFirstName("Peter")
            .setMiddleName("P")
            .setLastName("Parker")
            .setEmail("spiderman@example.com")
            .setPhone("555-555-1234")
            .setStreetAddress("1121 Melrose Avenue")
            .setCity("Glendale")
            .setCountry("United States")
            .setState("California")
            .setZip("91202")
            .build();



    public void closeModalWindow() {
        waitForVisible(upsModalWindow);
        clickWebElement(closeModalWindow);
    }

    public void closePrivacyPopUp() {
        waitForVisible(closePrivacyPopUpButton);
        clickWebElement(closePrivacyPopUpButton);
    }

    public void selectSenderCountry(String country) {
        originCountry.click();
        getByXpath("//button[normalize-space(text())='" + country + "' and contains(@id,'ShippingSummaryOriginAdd')]").click();

    }

    public void selectReceiverCountry(String country) {
        clickWebElement(receiverCountry);
        clickWebElement(getByXpath("//button[normalize-space(text())='" + country + "' and contains(@id,'SummaryDestinationAdd-country')]"));
    }

    public void selectOriginState(String state) {
        originState.click();
        waitForClickable(getByXpath("//button[normalize-space(text())='" + state + "' and contains(@id,'ShippingSummaryOriginAddStateDropdown')]"));
        clickWebElement(getByXpath("//button[normalize-space(text())='" + state + "' and contains(@id,'ShippingSummaryOriginAddStateDropdown')]"));
    }

    public void fillOutShipFromInfo() {
        if(!originCountryText.getText().equals("United States")) {
            selectSenderCountry(senderUser.getCountry());
        }

        originFullName.sendKeys(senderUser.getFirstName() + " " + senderUser.getLastName());
        originEmail.sendKeys(senderUser.getEmail());
        originPhone.sendKeys(senderUser.getPhone());
        originAddress.sendKeys(senderUser.getStreetAddress());
        originCity.sendKeys(senderUser.getCity());
        selectOriginState(senderUser.getState());
        originZip.sendKeys(senderUser.getZip());
    }


    public void selectReceiverAddress() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ngb-typeahead-window[@class='dropdown-menu show']")));
        clickWebElement(getByXpath("//button[@class='dropdown-item active' and contains(., '" + receiverUser.getStreetAddress() + ", " + receiverUser.getCity() + "')]"));
    }
    public void fillOutShipToInfo() throws InterruptedException {
        if(!receiverCountry.getText().equals("United States")) {
            selectReceiverCountry(senderUser.getCountry());
        }
        receiverFullName.sendKeys(receiverUser.getFirstName() + " " + receiverUser.getLastName());
        receiverEmail.sendKeys(receiverUser.getEmail());
        receiverPhone.sendKeys(receiverUser.getPhone());
        receiverAddress.sendKeys(receiverUser.getStreetAddress() + ", " + receiverUser.getCity());
        //waitFor(2);
        selectReceiverAddress();
    }

    public void fillOutPackageInfo() {
        packageWeight.sendKeys("10");
        packageLength.sendKeys("10");
        packageWidth.sendKeys("10");
        packageHeight.sendKeys("10");
    }

    public void verifyShipperDetails() {
        waitForVisible(shipperSummaryName);
        assertThat(shipperSummaryName.getText()).contains(senderUser.getFirstName() + " " + senderUser.getLastName());
        assertThat(shipperSummaryEmail.getText()).contains(senderUser.getEmail());
        assertThat(shipperSummaryPhone.getText()).contains(senderUser.getPhone());
        assertThat(shipperAddressLine1.getText()).contains(senderUser.getStreetAddress());
    }

    public void clickSelectServiceButton() {
        clickButton("Select a Service");
    }

    public void verifyReceiverDetails() {
    }
}
