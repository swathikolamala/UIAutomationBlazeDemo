package pages;

import entities.Flight;
import entities.Price;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightListPage {

    @FindBy(css = ".container>h3")
    private WebElement header;
    @FindBy(css = ".table")
    private WebElement flightListTable;

    WebDriver driver;

    public FlightListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageHeader() {
        return header.getText();
    }

    public void chooseFlight(Flight flight) {
        int numFlights = driver.findElements(By.cssSelector(".table>tbody>tr")).size();
        for (int rowLoopCount = 1; rowLoopCount <= numFlights ; rowLoopCount++) {
            if (driver.findElement(By.xpath("//tbody/tr["+rowLoopCount+"]/td[2]")).getText().equals(flight.getFlightNumber())) {
                flight.setAirline(driver.findElement(By.xpath("//tbody/tr["+rowLoopCount+"]/td[3]")).getText());
                flight.setDepartTime(driver.findElement(By.xpath("//tbody/tr["+rowLoopCount+"]/td[4]")).getText());
                flight.setArrivalTime(driver.findElement(By.xpath("//tbody/tr["+rowLoopCount+"]/td[5]")).getText());

                Price price = new Price();
                price.setBasePrice(Double.parseDouble(driver.findElement(By.xpath("//tbody/tr["+rowLoopCount+"]/td[6]"))
                        .getText().substring(1)));
                flight.setPrice(price);

                driver.findElement(By.xpath("//tbody/tr["+rowLoopCount+"]/td/input")).click();
                break;
            }
        }
    }
}
