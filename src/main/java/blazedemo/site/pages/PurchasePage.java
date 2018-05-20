package blazedemo.site.pages;

import blazedemo.site.sections.PurchaseForm;
import com.epam.jdi.uitests.core.interfaces.base.IElement;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

@JPage(url = "/purchase.php", title = "BlazeDemo Purchase")
public class PurchasePage extends WebPage {
    public final String REPLACED_PRICE_COST_TEXT = "Price: ";
    public final String REPLACED_TAXES_TEXT = "Arbitrary Fees and Taxes: ";
    public final String REPLACED_TOTAL_COST_TEXT = "Total Cost: ";

    @FindBy(tagName = "h2")
    public IElement title;

    @FindBy(xpath = "//p[contains(text(), 'Flight Number')]")
    public IText flightNumber;

    @FindBy(xpath = "//p[contains(text(), 'Airline')]")
    public IText airlineCompany;

    @FindBy(xpath = "//p[contains(text(), 'Price')]")
    public IText priceCost;

    @FindBy(xpath = "//p[contains(text(), 'Arbitrary Fees and Taxes')]")
    public IText arbitraryFeesAndTaxes;

    @FindBy(xpath = "//p[contains(text(), 'Total Cost')]")
    public IText totalCost;

    @FindBy()
    public PurchaseForm purchaseForm;

    @Step
    public void compareCostsAndVerify(String flightPrice){
        String priceCost = this.priceCost.getText().
                replace(REPLACED_PRICE_COST_TEXT, "");
        String feesAndTaxes = this.arbitraryFeesAndTaxes.getText().
                replace(REPLACED_TAXES_TEXT,"");
        String totalCost = this.totalCost.getText().
                replace(REPLACED_TOTAL_COST_TEXT,"");

        float priceCostValue = Float.parseFloat(priceCost);
        float arbitraryFeesAndTaxesValue = Float.parseFloat(feesAndTaxes);
        float totalCostValue = Float.parseFloat(totalCost);

        float totalCostResult = priceCostValue + arbitraryFeesAndTaxesValue;

        Assert.assertEquals(priceCost, flightPrice.replace("$",""));
        Assert.assertEquals(totalCostValue, totalCostResult);
    }
}
