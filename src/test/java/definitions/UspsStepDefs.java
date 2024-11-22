package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.USPSLookupZip;
import pages.USPSPriority;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UspsStepDefs {
    USPSPriority priority = new USPSPriority();
    USPSLookupZip zip = new USPSLookupZip();

    @When("I click Ship Now from priority mail page")
    public void iClickShipNowFromPriorityMailPage() {

    }

    @When("I click {string} link")
    public void iClickLink(String link) {
        priority.clickOnLink(link);
    }

    @Then("I validate {string} message present")
    public void iValidateMessagePresent(String message) throws InterruptedException {
        priority.switchToWindow(1);
        assertThat(priority.elementTextPresent(priority.alreadyHaveAccount, message)).isTrue();
    }

    @When("I hover over {string} link")
    public void iHoverOverLink(String link) {
        priority.hoverOver(priority.linkElement(link));
    }

    @When("I fill Portnov Computer School data")
    public void iFillPortnovComputerSchoolData() {
        zip.fillPortnovData();
    }

    @Then("I verify Zip code is {string}")
    public void iVerifyZipCodeIs(String zipCode) {
        assertThat(zip.elementTextPresent(zip.zipCode, zipCode)).isTrue();
        //assertThat(zip.zipCode.getText()).contains(zipCode);
    }

    @And("I click by {string} text")
    public void iClickByText(String text) {
        zip.clickByText(text);
    }
}
