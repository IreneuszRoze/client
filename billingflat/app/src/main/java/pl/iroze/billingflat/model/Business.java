package pl.iroze.billingflat.model;

import java.util.ArrayList;
import java.util.List;

public class Business {

    private List<Flat> flat = new ArrayList();


    public void addFlat(Flat flat) {
        this.flat.add(flat);
    }

    public List<Flat> getFlat() {
        return flat;
    }

    public void setFlat(List<Flat> flat) {
        this.flat = flat;
    }

}
