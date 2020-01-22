package pl.iroze.billingflat.model;

import java.util.ArrayList;
import java.util.List;

public class Flat {

    private int id;
    private String adress;

    private Role role;

    private List<Counter> counters = new ArrayList<>();
    private RateWater rateWater;
    private RateElectriocity rateElectriocity;
    private RateGas rateGas;

    public Flat(int id, String adress) {
        this.id = id;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }

    public void addCounter(Counter counter) {
        counters.add(counter);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public RateWater getRateWater() {
        return rateWater;
    }

    public void setRateWater(RateWater rateWater) {
        this.rateWater = rateWater;
    }

    public RateElectriocity getRateElectriocity() {
        return rateElectriocity;
    }

    public void setRateElectriocity(RateElectriocity rateElectriocity) {
        this.rateElectriocity = rateElectriocity;
    }

    public RateGas getRateGas() {
        return rateGas;
    }

    public void setRateGas(RateGas rateGas) {
        this.rateGas = rateGas;
    }
}
