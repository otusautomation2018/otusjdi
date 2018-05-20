package blazedemo.site.entities;

public class Flight {
    public String number, airline, departs, arrives, price;

    public Flight(){}
    public Flight(String number, String airline, String departs, String arrives, String price){
        this.number = number;
        this.airline = airline;
        this.departs = departs;
        this.arrives = arrives;
        this.price = price;
    }

    public Flight(String number, String airline, String price){
        this.number = number;
        this.airline = airline;
        this.price = price;
    }
}
