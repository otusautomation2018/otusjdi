package blazedemo.site.sections;

import blazedemo.site.entities.Pay;
import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Selector;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ById;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.ByName;
import org.openqa.selenium.support.FindBy;

public class PurchaseForm extends Form<Pay> {

    @ById("inputName")
    ITextField name;

    @ById("address")
    ITextField address;

    @ById("city")
    ITextField city;

    @ById("state")
    ITextField state;

    @ById("zipCode")
    ITextField zipCode;

    @ById("creditCardNumber")
    ITextField creditCardNumber;

    @ById("creditCardMonth")
    ITextField creditCardMonth;

    @ById("creditCardYear")
    ITextField creditCardYear;

    @ById("nameOnCard")
    ITextField nameOnCard;

    @ByName("cardType")
    Selector cardType;

    @FindBy(css = "input[type=submit]")
    IButton submit;
}
