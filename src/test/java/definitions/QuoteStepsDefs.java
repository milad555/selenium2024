package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Page;
import pages.QuoteForm;
import pages.QuoteResult;
import support.DriverFactory;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class QuoteStepsDefs {


    Page page = new Page();
    WebDriver driver = DriverFactory.getDriver();
    QuoteForm quoteForm = new QuoteForm();
    QuoteResult quoteResult = new QuoteResult();

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
            case "careers log" -> page.open("https://skryabin-careers.herokuapp.com/login");
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
        quoteForm.fillName("Milad", "X", "K");
        quoteForm.fillUsername("Miladski");
        quoteForm.fillPassword("Mila123");
        quoteForm.fillEmail("miladski@test.com");
        quoteForm.fillphone("123312123");
        quoteForm.checkPrivacyPolicy();
        quoteForm.selectTwoCarMakers("Ford","Toyota");
        quoteForm.acceptAgreement();
        quoteForm.checkGender("male").click();
        quoteForm.selectDateOfBirth("1991","Jan", "4");
        quoteForm.selectCountryOfOrigin("Russia");
        quoteForm.fillAdditionalInform("Donald Duck","1231412");
        quoteForm.clickButtonByContains("Related documents");
        quoteForm.switchToWindow(1);
        quoteForm.waitFor(5);
    }

    @And("I submit the form oop")
    public void iSubmitTheFormOop() {
        quoteForm.submit();
    }

    @Then("I see required fields submitted successfully oop")
    public void iSeeRequiredFieldsSubmittedSuccessfullyOop() {
        quoteResult.isSubmittedDataCorrect("firstName","Milad");
        quoteResult.isSubmittedDataCorrect("middleName","X");
        quoteResult.isSubmittedDataCorrect("lastName","K");
        quoteResult.isSubmittedDataCorrect("password","[entered]");
        quoteResult.isSubmittedDataCorrect("username","Miladski");
        quoteResult.isSubmittedDataCorrect("agreedToPrivacyPolicy","true");
        quoteResult.isSubmittedDataCorrect("countryOfOrigin","Russia");
        quoteResult.isSubmittedDataCorrect("thirdPartyAgreement","accepted");
        quoteResult.isSubmittedDataCorrect("carMake","Ford, Toyota");
        quoteResult.isSubmittedDataCorrect("email","miladski@test.com");
        quoteResult.isSubmittedDataCorrect("phone","123312123");
        quoteResult.isSubmittedDataCorrect("dateOfBirth","01/04/1991");
        quoteResult.isSubmittedDataCorrect("gender","male");
        quoteResult.isCurrentTimeCorrect();

    }
}
