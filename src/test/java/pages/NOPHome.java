package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

public class NOPHome extends Page {

    public NOPHome() {
        url = "https://nop-qa.portnov.com/";
        title = "Your store. Home page title";
    }

    @FindBy(xpath = "//a[@class='ico-cart']")
    private WebElement shoppingCart;

    public void clickAndVerifySoppingCart(){
        shoppingCart.click();
    }

    public void clickCategory(String category) {
        getByXpath("//ul[@class='top-menu notmobile']//a[text()='" + category + " ']").click();
    }

    public void clickSubCategory(String subcategory) {
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

    //Generic Method to click ANY Product
    public void clickProduct(String text) {
        //Storing into an element
        WebElement element = driver.findElement(By.xpath("//*[text()='" + text + "']"));
        //Creating an instance of Webdriver Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Waiting Until the element is visible
        wait.until(ExpectedConditions.visibilityOf(element));
        //Clicking element
        element.click();
    }

    public void goToShoppingCart() {
        shoppingCart.click();
    }

    public void clickSocials(String social) {
        driver.findElement(By.className(social)).click();
    }

    public void verifyTitle() {
        assertThat(driver.getTitle()).contains(title);
    }

    public void verifySubCategory(String subcat) {
        WebElement subs = getByXpath("(//li/a[normalize-space()='" + subcat + "'])[1]");
        assertThat(subs.isDisplayed()).isTrue();
    }

}

