package blazedemo.enums;

public enum FlightTableColumns {
    CHOOSE("choose"),
    NUMBER("number"),
    AIRLINE("airline"),
    DEPARTS("departs"),
    ARRIVES("arrives"),
    PRICE("price");

    public String value;

    FlightTableColumns(String value) { this.value = value;}

    public String toString() { return this.value; }
}
