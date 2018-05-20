package blazedemo.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum DestinationCities {
    BUENOS_AIRES("Buenos Aires"),
    ROME("Rome"),
    LONDON("London"),
    BERLIN("Berlin"),
    NEW_YORK("New York"),
    DUBLIN("Dublin"),
    CAIRO("Cairo");

    public String value;

    DestinationCities(String value) { this.value = value;}

    public String toString() { return this.value; }


    private static final List<DestinationCities> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private  static final Random RANDOM = new Random();

    public static DestinationCities randomCity(){
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
