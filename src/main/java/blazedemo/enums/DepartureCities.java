package blazedemo.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum DepartureCities {
    PARIS("Paris"),
    PHILADELPHIA("Philadelphia"),
    BOSTON("Boston"),
    PORTLAND("Portland"),
    SAN_DIEGO("San Diego"),
    MEXICO_CITY("Mexico City"),
    SAO_PAOLO("São Paolo");

    public String value;

    DepartureCities(String value) { this.value = value;}

    public String toString() { return this.value; }


    private static final List<DepartureCities> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private  static final Random RANDOM = new Random();

    public static DepartureCities randomCity(){
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
