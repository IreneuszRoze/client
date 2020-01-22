package pl.iroze.billingflat.model;

public class HotWater extends Water {

    public HotWater(int id, String number, String description) {
        super(id, number, description);
    }

    @Override
    public Type getType() {
        return Type.HOT_WATER;
    }
}
