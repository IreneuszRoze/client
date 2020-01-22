package pl.iroze.billingflat.model;

public class Electricity extends Counter {

    public Electricity(int id, String number, String description) {
        super(id, number, description);
    }

    @Override
    public Type getType() {
        return Type.ELECTRIOCITY;
    }

}
