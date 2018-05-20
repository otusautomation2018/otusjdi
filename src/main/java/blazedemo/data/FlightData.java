package blazedemo.data;


import blazedemo.enums.DepartureCities;
import blazedemo.enums.DestinationCities;

public class FlightData {

    private static Enum departureCity, destinationCity;

    public static Enum departureCity() {
        if (departureCity == null){
            departureCity = DepartureCities.randomCity();
        }
        return departureCity;
    }

    public static Enum destinationCity() {
        if (destinationCity == null){
            destinationCity = DestinationCities.randomCity();
        }
        return destinationCity;
    }
}
