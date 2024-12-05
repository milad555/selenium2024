package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UPSCreateShipment;

public class UPSStepDefs {

    UPSCreateShipment upsCreateShipment = new UPSCreateShipment();

    @When("I fill out required fields for shipment information")
    public void iFillOutRequiredFieldsForShipmentInformation() throws InterruptedException {
        upsCreateShipment.closeModalWindow();
        upsCreateShipment.closePrivacyPopUp();
        upsCreateShipment.fillOutShipFromInfo();
        upsCreateShipment.fillOutShipToInfo();
        upsCreateShipment.fillOutPackageInfo();
    }

    @Then("I verify that required fields present on Shipper and Receiver details")
    public void iVerifyThatRequiredFieldsPresentOnShipperAndReceiverDetails() {
        upsCreateShipment.verifyShipperDetails();
        upsCreateShipment.verifyReceiverDetails();
    }

    @And("I submit shipment form")
    public void iSubmitShipmentForm() {
        upsCreateShipment.clickSelectServiceButton();
    }
}
