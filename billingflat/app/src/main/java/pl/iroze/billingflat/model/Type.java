package pl.iroze.billingflat.model;

public enum Type {
    COLD_WATER("Zimna woda"),
    HOT_WATER("Ciepla woda"),
    ELECTRIOCITY("Prąd"),
    GAS("Gas");

    private String stringValue;

    Type(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getName() {
        return stringValue;
    }
}