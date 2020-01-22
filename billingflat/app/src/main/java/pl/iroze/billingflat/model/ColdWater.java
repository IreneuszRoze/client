package pl.iroze.billingflat.model;

public class ColdWater extends Water {

    public ColdWater(int id, String number, String description) {
        super(id, number, description);
    }

    @Override
    public Type getType() {
        return Type.COLD_WATER;
    }
}
