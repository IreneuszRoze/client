package pl.iroze.billingflat.model;

import java.time.LocalDate;

public class RateGas extends Rate {

    private int id;
    private LocalDate date;
    private double use; //use zużycie
    private double constant; //constant oplataStala

    public RateGas(int id, LocalDate date, double use, double constant) {
        this.id = id;
        this.date = date;
        this.use = use;
        this.constant = constant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getUse() {
        return use;
    }

    public void setUse(double use) {
        this.use = use;
    }

    public double getConstant() {
        return constant;
    }

    public void setConstant(double constant) {
        this.constant = constant;
    }
}
