package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CareerLogin;
import pages.QuoteForm;

public class CareersStepDefs {

    CareerLogin careerLogin = new CareerLogin();
    QuoteForm quoteForm = new QuoteForm();
    @When("I fill out username {string} and password {string}")
    public void iFillOutUsernameAndPassword(String username, String password) {
        careerLogin.fillOutUsername(username);
        careerLogin.fillOutPassword(password);

    }

    @And("I click {string} button")
    public void iClickButton(String button) {
        quoteForm.clickButton(button);
    }
}
