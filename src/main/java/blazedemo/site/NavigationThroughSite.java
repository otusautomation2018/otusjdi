package blazedemo.site;

import blazedemo.enums.FlightTableColumns;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import ru.yandex.qatools.allure.annotations.Step;

import static blazedemo.site.BlazedemoSite.homePage;
import static blazedemo.site.BlazedemoSite.purchasePage;
import static blazedemo.site.BlazedemoSite.reservePage;

@JPage
public class NavigationThroughSite extends WebPage {

    @Step
    public void goToHomePage(){
        homePage.open();
        homePage.submitFormBtn.waitDisplayed();
    }

    @Step
    public void comeToReservePage(){
        goToHomePage();
        homePage.selectCitiesAndSubmitForm();
        reservePage.checkOpened();
    }

    @Step
    public void chooseFlightWithMinPrice(){
        reservePage.flightRowWithMinPrice().get(FlightTableColumns.CHOOSE.toString()).click();
        purchasePage.title.waitDisplayed();
        purchasePage.checkOpened();
    }
}
