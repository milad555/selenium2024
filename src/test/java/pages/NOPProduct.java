package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NOPProduct extends Page{
    public NOPProduct() {

    }
    // Locators
    @FindBy(xpath = "//button[contains(@id,'add-to-cart-button')]")
    private WebElement addToCartButton;

    @FindBy(id = "product-details")
    private WebElement productDetails;

    @FindBy(id = "product_attribute_2")
    private WebElement attribute2;


    // Method to add product to cart
    public void addToCart() {
        waitForElement(addToCartButton);
        addToCartButton.click();
    }

    // Method to verify product details are visible
    public void verifyProductDetails() {
       waitForElement(productDetails);
    }
    public void selectRam(String ram){
        selectByVisibleText(attribute2, ram);
    }

}
