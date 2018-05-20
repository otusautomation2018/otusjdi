package blazedemo.site.pages;

import blazedemo.enums.FlightTableColumns;
import blazedemo.site.customElements.FlightRecord;
import blazedemo.site.entities.Flight;
import com.epam.commons.map.MapArray;
import com.epam.jdi.uitests.core.interfaces.complex.tables.interfaces.ICell;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.EntityTable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JPage(url = "/reserve.php", title = "BlazeDemo - reserve")
public class ReservePage extends WebPage {

    @JTable(
            root = @FindBy(xpath = "//tbody"),
            row = @FindBy(xpath = ".//tr[%s]//td"),
            column = @FindBy(xpath = ".//tr//td[%s]"),
            header = {"choose", "number", "airline", "departs", "arrives", "price"})
    public EntityTable<Flight, FlightRecord> flights;

    private Integer numEntityWithMinPrice;

    @Step
    public MapArray<String, ICell> flightRowWithMinPrice(){
        setNumEntityWithMinPriceIfNeeded();
        /* increase by 1 because in the table the numbering is from 1 and not from 0  */
        return this.flights.row(numEntityWithMinPrice + 1);
    }

    @Step
    public Flight flightEntityWithMinPrice(){
        setNumEntityWithMinPriceIfNeeded();
        return this.flights.entities().get(numEntityWithMinPrice);
    }

    @Step
    private void setNumEntityWithMinPriceIfNeeded(){
        /* numbering of the list starts from 0 */
        if (numEntityWithMinPrice == null) {
            ArrayList list = pricesLIst();
            numEntityWithMinPrice = minIndex(list);
        }
    }

    @Step
    private ArrayList pricesLIst(){
        List<String> prices = this.flights.columnValue(FlightTableColumns.PRICE.toString());
        ArrayList arr = new ArrayList();
        for (String price: prices){
            arr.add(Float.parseFloat(price.substring(1)));
        }
        return arr;
    }

    @Step
    private int minIndex (ArrayList<Float> list) { return list.indexOf (Collections.min(list)); }
}
