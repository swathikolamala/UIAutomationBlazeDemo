package pages;

import entities.Card;
import entities.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage {

    @FindBy(id = "inputName")
    private WebElement name;
    @FindBy(id = "address")
    private WebElement address;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "state")
    private WebElement state;
    @FindBy(id = "zipCode")
    private WebElement zipCode;

    @FindBy(id = "cardType")
    private WebElement cardType;
    @FindBy(id = "creditCardNumber")
    private WebElement creditCardNumber;
    @FindBy(id = "creditCardMonth")
    private WebElement creditCardMonth;
    @FindBy(id = "creditCardYear")
    private WebElement creditCardYear;
    @FindBy(id = "nameOnCard")
    private WebElement nameOnCard;

    @FindBy(css = ".btn.btn-primary")
    private WebElement purchaseButton;

    public PurchasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private void enterCustomerData(Customer customer) {
        name.sendKeys(customer.getName());
        address.sendKeys(customer.getAddress());
        city.sendKeys(customer.getCity());
        state.sendKeys(customer.getState());
        zipCode.sendKeys(String.valueOf(customer.getZipCode()));
    }

    private void enterCardData(Card card) {
        Select cardTypeDropDown = new Select(cardType);
        cardTypeDropDown.selectByVisibleText(card.getType());
        creditCardNumber.sendKeys(card.getNumber());
        creditCardMonth.clear();
        creditCardMonth.sendKeys(String.valueOf(card.getMonth()));
        creditCardYear.clear();
        creditCardYear.sendKeys(String.valueOf(card.getYear()));
        nameOnCard.sendKeys(card.getNameOnCard());
    }

    public void enterPurchaseData(Customer customer, Card card) {
        enterCustomerData(customer);
        enterCardData(card);
        purchaseButton.click();
    }
}
