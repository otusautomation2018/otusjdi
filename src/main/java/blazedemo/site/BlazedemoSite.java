package blazedemo.site;

import blazedemo.site.pages.ConfirmationPage;
import blazedemo.site.pages.HomePage;
import blazedemo.site.pages.PurchasePage;
import blazedemo.site.pages.ReservePage;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;

@JSite("http://blazedemo.com")
public class BlazedemoSite extends WebSite {
    @JPage
    public static HomePage homePage;

    @JPage
    public static ReservePage reservePage;

    @JPage
    public static PurchasePage purchasePage;

    @JPage
    public static ConfirmationPage confirmationPage;

    @JPage
    public static NavigationThroughSite navigationThroughSite;
}
