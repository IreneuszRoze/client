package pl.iroze.billingflat.model;

public class Gas extends Counter {


    public Gas(int id, String number, String description) {
        super(id, number, description);
    }

    @Override
    public Type getType() {
        return Type.GAS;
    }
}
