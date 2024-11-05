package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.HashMap;

public class NOPHome extends Page {
    public NOPHome() {
        url = "https://nop-qa.portnov.com";
        title = "Your store. Home page title";
    }
    @FindBy(xpath = "//span[@class='cart-label']")
    private WebElement shoppingCard;

    public void clickProduct(String partialLink) {
        driver.findElement(By.xpath("(//a[contains(text(),'" + partialLink + "')])[1]")).click();
    }

    public void clickCategory(String category) {
        if(category.equals("Computers")){
            driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();
        } else if (category.equals("Electronics")) {
            driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']")).click();
        } else if (category.equals("Apparel")) {
            driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel ']")).click();
        } else if (category.equals("Digital downloads")) {
            driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Digital downloads ']")).click();
        } else if (category.equals("Books")) {
            driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books ']")).click();
        } else if (category.equals("Jewelry")) {
            driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Jewelry ']")).click();
        } else if (category.equals("Gift Cards")) {
            driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift Cards ']")).click();
        } else {
            throw new IllegalArgumentException("Invalid category: " + category);
        }
    }

    public void clickShoppingCard(){
        shoppingCard.click();
    }

}
