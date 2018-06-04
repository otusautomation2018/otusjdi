package blazedemo.tests;

import blazedemo.data.FlightData;
import blazedemo.enums.DepartureCities;
import blazedemo.enums.DestinationCities;
import blazedemo.site.entities.Flight;
import blazedemo.site.entities.Pay;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static blazedemo.site.BlazedemoSite.*;

public class PurchaseATicketFunctionalityTest extends BlazedemoTestInit {

    @Test
    public void purchaseATicketTest(){
        Flight flight;
        Pay pay = new Pay();

        navigationThroughSite.comeToReservePage();
        flight = reservePage.flightEntityWithMinPrice();
        navigationThroughSite.chooseFlightWithMinPrice();

        Assert.assertContains(purchasePage.flightNumber.getText(), flight.number);
        Assert.assertContains(purchasePage.airlineCompany.getText(), flight.airline);
        purchasePage.compareCostsAndVerify(flight.price);
        purchasePage.purchaseForm.submit(pay);

        confirmationPage.title.waitDisplayed();
        confirmationPage.checkOpened();
        confirmationPage.verifyOrderData(pay);
    }

    @DataProvider(parallel = true)
    public Object[][] citiesData(){
        return new Object[][] {
                {DepartureCities.randomCity().toString(), DestinationCities.randomCity().toString()},
                {DepartureCities.randomCity().toString(), DestinationCities.randomCity().toString()},
                {DepartureCities.randomCity().toString(), DestinationCities.randomCity().toString()},
        };
    }

    @Test(dataProvider = "citiesData")
    public void purchaseATicketDataProviderTest(String departureCity, String destinationCity){
        Flight flight;
        Pay pay = new Pay();
        navigationThroughSite.goToHomePage();
        homePage.selectCitiesAndSubmitFormWithCities(departureCity, destinationCity);
        reservePage.checkOpened();
        flight = reservePage.flightEntityWithMinPrice();
        navigationThroughSite.chooseFlightWithMinPrice();

        Assert.assertContains(purchasePage.flightNumber.getText(), flight.number);
        Assert.assertContains(purchasePage.airlineCompany.getText(), flight.airline);
        purchasePage.compareCostsAndVerify(flight.price);
        purchasePage.purchaseForm.submit(pay);

        confirmationPage.title.waitDisplayed();
        confirmationPage.checkOpened();
        confirmationPage.verifyOrderData(pay);
    }
}
