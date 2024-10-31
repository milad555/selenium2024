package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.DriverFactory;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class QuoteResult extends Page {

    QuoteForm quote = new QuoteForm();

    @FindBy(xpath = "//b[@name='currentTime']")
    private WebElement currentTime;

    public String submittedApplicationData(String element){
        String xpath = String.format("//b[@name='%s']", element);
        return quote.getByXpath(xpath).getText();
    }

    public void isSubmittedDataCorrect(String element, String expectedValue ){
        assertThat(submittedApplicationData(element).equalsIgnoreCase(expectedValue)).isTrue();
    }

    public void isCurrentTimeCorrect (){
        assertThat(currentTime.getText().equalsIgnoreCase(getLocalTime())).isTrue();
    }

    private String getLocalTime(){
        LocalTime now = LocalTime.now();
        // Define the formatter for the desired format (e.g., 4:09 pm)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        // Format the current time
        String formattedTime = now.format(formatter);
        return formattedTime + " Pacific Daylight Time";
    }
}
