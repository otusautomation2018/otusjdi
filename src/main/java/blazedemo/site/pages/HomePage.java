package blazedemo.site.pages;

import blazedemo.data.FlightData;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

@JPage(url = "/", title = " BlazeDemo")
public class HomePage extends WebPage {

    @FindBy(css = "[name='fromPort']")
    public Selector departureCity;

    @FindBy(css = "[name='toPort']")
    public Selector destinationCity;

    @FindBy(css = "[type='submit']")
    public Button submitFormBtn;

    @Step
    public void selectCitiesAndSubmitForm(){
        this.departureCity.select(FlightData.departureCity());
        this.destinationCity.select(FlightData.destinationCity());
        this.submitFormBtn.click();
    }
}
