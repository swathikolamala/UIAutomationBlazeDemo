package tests;

import entities.Card;
import entities.Customer;
import entities.Flight;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.FlightListPage;
import pages.HomePage;
import pages.PurchasePage;
import testBase.TestBase;

public class FlightBookingTest extends TestBase {

    @Test
    public void flightBooking() {

        Flight flight = new Flight("Boston", "London", "12");
        Customer customer = new Customer("testName", "testAddress", "testCity", "testState", 560008);
        Card card = new Card("American Express", "12345678", 11, 2021, "testName");

        new HomePage(driver).findFlights(flight.getFromPort(), flight.getToPort());
        String flightPageHeaderText = new FlightListPage(driver).getPageHeader();
        Assert.assertEquals(flightPageHeaderText,
                "Flights from " + flight.getFromPort() + " to " + flight.getToPort() + ":");

        new FlightListPage(driver).chooseFlight(flight);
        new PurchasePage(driver).enterPurchaseData(customer, card);

        String confirmationId = new ConfirmationPage(driver).getConfirmationId();
        Assert.assertNotEquals(confirmationId, "");
    }
}
