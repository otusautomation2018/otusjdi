package blazedemo.tests;

import blazedemo.site.BlazedemoSite;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class BlazedemoTestInit extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp(){
        WebSite.init(BlazedemoSite.class);
        logger.info("Run test");
    }
}
