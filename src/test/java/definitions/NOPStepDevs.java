package definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.QuoteForm;
import support.DriverFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NOPStepDevs {
    QuoteForm quoteForm = new QuoteForm();
    QuoteStepsDefs quote = new QuoteStepsDefs();

    public WebElement subCategory(String catName) {
       return quoteForm.getByXpath("//ul[@class='sublist']//a[text()='" + catName + " ']");
    }

    WebDriver driver = DriverFactory.getDriver();


    @Then("I click on the {string} category tab")
    public void iClickOnTheCategoryTab(String tabText) {

        quote.click("//ul[@class='top-menu notmobile']//a[text()='" + tabText + "']");

    }

    @When("I click on {string} subcategory in the sidebar")
    public void iClickOnSubcategoryInTheSidebar(String subCategoryName) {
        quote.click(subCategory(subCategoryName));

    }
}
