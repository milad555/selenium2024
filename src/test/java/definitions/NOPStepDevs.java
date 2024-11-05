package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.*;
import support.DriverFactory;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NOPStepDevs {
    HashMap<String, String> user;

    WebDriver driver = DriverFactory.getDriver();
    //Instance of NOPRegister page
    NOPRegister nopRegister = new NOPRegister();
    NOPLogin nopLogin = new NOPLogin();
    NOPHome nopHome = new NOPHome();
    NOPProduct nopProduct = new NOPProduct();
    NOPCard nopCard = new NOPCard();

    @Given("I am on the nopCommerce homepage")
    public void iAmOnTheNopCommerceHomepage() {
        driver.get("https://nop-qa.portnov.com/");
    }

    @When("I click on the {string} category tab")
    public void iClickOnTheCategoryTab(String category) {
      nopHome.clickCategory(category);
    }

    @When("I click on the {string} subcategory in the sidebar")
    public void iClickOnTheSubcategoryInTheSidebar(String subcategory) {
        if (subcategory.equals("Desktops")) {
            driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[@href='/desktops']")).click();
        } else if (subcategory.equals("Notebooks")) {
            driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[@href='/notebooks']")).click();
        } else if (subcategory.equals("Software")) {
            driver.findElement(By.xpath("//div[@class='block block-category-navigation']//a[@href='/software']")).click();
        } else {
            throw new IllegalArgumentException("Invalid subcategory: " + subcategory);
        }
    }


    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        nopRegister.open();
    }

    @When("I register with a Default User")
    public void iRegisterWithADefaultUser() {
        //Fill out the Registered User AND store the users email and password
        this.user = nopRegister.registerUser();
        //nopRegister.registerUser();
    }

    @Then("I should see a registration success message")
    public void iShouldSeeARegistrationSuccessMessage() {
        nopRegister.waitForRegistrationResultMessage();
    }

    @When("I register using first name {string}, last name {string}, email {string}, and password {string}")
    public void iRegisterUsingFirstNameLastNameEmailAndPassword(String fname, String lname, String email, String password) {
        nopRegister.registerUser(fname, lname, email, password);
    }

    @And("I click Logout")
    public void iClickLogout() {
        nopRegister.clickLogoutButton();
    }

    @When("I am on the login page")
    public void iAmOnTheLoginPage() {
        nopLogin.open();
    }

    @When("I enter Default Credentials")
    public void iEnterDefaultCredentials() {
//       String email = user.get("email");
//       String password = user.get("password");
        nopLogin.login(user.get("email"), user.get("password"));
    }

    @Then("I verify something")
    public void iVerifySomething() {
    }

    @And("I am logged in as a registered user")
    public void iAmLoggedInAsARegisteredUser() {
        this.user = nopRegister.registerUser();
        nopLogin.login(user.get("email"), user.get("password"));
    }

    @And("I select the product {string}")
    public void iSelectTheProduct(String partialLink) {
        nopHome.clickProduct(partialLink);
    }

    @And("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        nopProduct.addToCart();
    }

    @And("I click on Shopping cart tab")
    public void iClickOnShoppingCartTab() {
        nopHome.clickShoppingCard();
    }

    @Then("I proceed to the checkout page")
    public void iProceedToTheCheckoutPage() {
        nopCard.acceptTOS();
        nopCard.clickCheckout();
    }

    @And("I select ram as {string} for desktop")
    public void iSelectRamForDesktop(String ram) {
        nopProduct.selectRam(ram);
    }
}
