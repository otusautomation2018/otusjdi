package blazedemo.site.pages;

import blazedemo.data.CommonData;
import blazedemo.site.entities.Pay;
import com.epam.jdi.uitests.core.interfaces.base.IElement;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

@JPage(url = "/confirmation.php", title = "BlazeDemo Confirmation")
public class ConfirmationPage extends WebPage {
    public final String CURRENCY = "USD";

    @FindBy(tagName = "h1")
    public IElement title;

    @FindBy(xpath = "//td[contains(text(), 'Id')]/following-sibling::td")
    public IText id;

    @FindBy(xpath = "//td[contains(text(), 'Status')]/following-sibling::td")
    public IText status;

    @FindBy(xpath = "//td[contains(text(), 'Amount')]/following-sibling::td")
    public IText amount;

    @FindBy(xpath = "//td[contains(text(), 'Card Number')]/following-sibling::td")
    public IText cardNumber;

    @FindBy(xpath = "//td[contains(text(), 'Expiration')]/following-sibling::td")
    public IText expiration;

    @FindBy(xpath = "//td[contains(text(), 'Auth Code')]/following-sibling::td")
    public IText authCode;

    @Step
    public void verifyOrderData(Pay pay){
        String expirationExpectedText = pay.creditCardMonth + " /" + pay.creditCardYear;

        Assert.assertTrue(this.id.isDisplayed());
        Assert.assertTrue(this.status.isDisplayed());
        Assert.assertTrue(this.amount.isDisplayed());
        Assert.assertTrue(this.expiration.isDisplayed());
        Assert.assertTrue(this.authCode.isDisplayed());
        Assert.assertEquals(this.amount.getText(), this.CURRENCY);
        Assert.assertEquals(this.expiration.getText(), expirationExpectedText);
        compareLast4SymbolsOfBankCardAndVerify(pay.creditCardNumber);
    }

    @Step
    public void compareLast4SymbolsOfBankCardAndVerify(String creditCardNumber){
        String cardNumberOnPage = this.cardNumber.getText();
        String actualCardNumber = cardNumberOnPage
                .substring(cardNumberOnPage.length() - CommonData.INDEX_OF_LAST_FOUR_SYMBOL_CARD);
        String expectedCardNumber = creditCardNumber
                .substring(creditCardNumber.length() - CommonData.INDEX_OF_LAST_FOUR_SYMBOL_CARD);

        Assert.assertEquals(actualCardNumber, expectedCardNumber);
    }
}
