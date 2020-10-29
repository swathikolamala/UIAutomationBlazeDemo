package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    @FindBy(name = "fromPort")
    private WebElement fromPort;
    @FindBy(name = "toPort")
    private WebElement toPort;
    @FindBy(css = ".btn.btn-primary")
    WebElement findFlightsButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void findFlights(String source, String destination) {
        Select sourceDropDown = new Select(fromPort);
        sourceDropDown.selectByVisibleText(source);

        Select destinationDropDown = new Select(toPort);
        destinationDropDown.selectByVisibleText(destination);

        findFlightsButton.click();
    }
}
