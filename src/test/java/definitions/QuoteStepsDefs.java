package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import support.DriverFactory;
import support.Loggable;
import testDataClasses.UserData;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class QuoteStepsDefs implements Loggable {
    UserData data = new UserData(
            "Miladski",
            "Milad",
            "X",
            "K",
            "Mila123",
            "Mila123",
            "test@test.com","Russia",
            "Las Palmas",
            "Irvine",
            "CA",
            "92620"
    );

    Page page = new Page();
    WebDriver driver = DriverFactory.getDriver();
    QuoteForm quoteForm = new QuoteForm();
    QuoteResult quoteResult = new QuoteResult();
    USPSPriority priority = new USPSPriority();
    USPSLookupZip lookupZip = new USPSLookupZip();
    UPSCreateShipment upsCreateShipment = new UPSCreateShipment();

    public void click(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }
    public void click(WebElement element){
        element.click();
    }



    public void fillOutField(String xpath, String value) {
        driver.findElement(By.xpath(xpath)).sendKeys(value);

    }

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String openPage) {

        switch (openPage) {
            case "quote" -> page.open("https://skryabin.com/market/quote.html");
            case "login" -> page.open("https://skryabin.com/market/login.html");
            case "careers" -> page.open("https://skryabin-careers.herokuapp.com/");
            case "careers login" -> page.open("https://skryabin-careers.herokuapp.com/login");
            case "usps priority mail" -> priority.open();
            case "usps lookup a zip code by address" -> lookupZip.open();
            case "ups shipment info" -> upsCreateShipment.open();
            default -> throw new IllegalStateException("Unexpected value: " + page);
        }
    }

    @When("I fill out the required fields on the form")
    public void iFillOutTheRequiredFieldsOnTheForm() {
        // fill out name
        click("//input[@id='name']");
        fillOutField("//input[@id='firstName']", "Milad");
        fillOutField("//input[@id='middleName']", "X");
        fillOutField("//input[@id='lastName']", "K");
        click("//button/span[text()='Save']");
        //Username
        fillOutField("//input[@name='username']", "Miladski");
        //Password
        fillOutField("//input[@name='password']", "Miladski123");
        fillOutField("//input[@name='confirmPassword']", "Miladski123");
        //Email
        fillOutField("//input[@name='email']", "miladski@gmail.com");
        //DOB
        click("//input[@id='dateOfBirth']");
        new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"))).selectByVisibleText("1991");
        new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"))).selectByVisibleText("Jan");
        click("(//td[@data-handler='selectDay']/a[contains(text(),'4')])[1]");

        //Country of origin
        new Select(driver.findElement(By.xpath("//select[@name='countryOfOrigin']"))).selectByValue("USA");
        //Gender
        click("//input[@value='male']");
        //Agree to terms
        click("//button[@id='thirdPartyButton']");
        driver.switchTo().alert().accept();

        click("//input[@name='agreedToPrivacyPolicy']");


    }

    @Then("I verify the page title is {string}")
    public void iVerifyThePageTitleIs(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs(title));
        System.out.println("Current page title is " + driver.getTitle());
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        //Submit
        click("//button[@id='formSubmit']");
    }

    @Then("I see required fields submitted successfully")
    public void iSeeRequiredFieldsSubmittedSuccessfully() {

    }

    @Given("I navigate to {string} page oop")
    public void iNavigateToPageOop(String arg0) {

    }

    @When("I fill out the required fields on the form oop")
    public void iFillOutTheRequiredFieldsOnTheFormOop() throws InterruptedException {


        quoteForm.fillName(data.getFirstName(), data.getMiddleName(), data.getLastName());
        quoteForm.fillUsername(data.getUsername());
        quoteForm.fillPassword(data.getPassword());
        quoteForm.fillEmail(data.getEmail());
        quoteForm.fillphone(data.getPhone());
        quoteForm.checkPrivacyPolicy();
        quoteForm.selectTwoCarMakers("Ford","Toyota");
        quoteForm.acceptAgreement();
        quoteForm.checkGender("male");
        quoteForm.selectDateOfBirth("1991","Jan", "4");
        quoteForm.selectCountryOfOrigin(data.getCountry());
        quoteForm.fillAdditionalInform("Donald Duck","1231412");
        quoteForm.clickButtonByContains("Related documents");
        quoteForm.switchToWindow(1);
        assertThat(driver.findElement(By.xpath("//body")).getText()).contains("Document 1");
        quoteForm.switchToWindow(0);
    }

    @And("I submit the form oop")
    public void iSubmitTheFormOop() {
        quoteForm.submit();
    }

    @Then("I see required fields submitted successfully oop")
    public void iSeeRequiredFieldsSubmittedSuccessfullyOop() {
        quoteResult.isSubmittedDataCorrect("firstName", data.getFirstName());
        quoteResult.isSubmittedDataCorrect("middleName",data.getMiddleName());
        quoteResult.isSubmittedDataCorrect("lastName",data.getLastName());
        quoteResult.isSubmittedDataCorrect("password","[entered]");
        quoteResult.isSubmittedDataCorrect("username",data.getUsername());
        quoteResult.isSubmittedDataCorrect("agreedToPrivacyPolicy","true");
        quoteResult.isSubmittedDataCorrect("countryOfOrigin", data.getCountry());
        quoteResult.isSubmittedDataCorrect("thirdPartyAgreement","accepted");
        quoteResult.isSubmittedDataCorrect("carMake","Ford, Toyota");
        quoteResult.isSubmittedDataCorrect("email",data.getEmail());
//        quoteResult.isSubmittedDataCorrect("phone",data.getPhone());
        quoteResult.isSubmittedDataCorrect("dateOfBirth","01/04/1991");
        quoteResult.isSubmittedDataCorrect("gender","male");
        quoteResult.isCurrentTimeCorrect();

    }
}
