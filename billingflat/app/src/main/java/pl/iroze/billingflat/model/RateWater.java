package pl.iroze.billingflat.model;

import java.time.LocalDate;

public class RateWater extends Rate {

    private int id;
    private LocalDate date;
    private double supplying; //supplying dostarczenieWody i Scieki
    private double heating; //heating podgrzania
    private double circulation; //Circulation oplataCyrkulacyjna
    private double constant; //constant oplataStala

    public RateWater(int id, LocalDate date, double supplying, double heating, double circulation, double constant) {
        this.id = id;
        this.date = date;
        this.circulation = circulation;
        this.constant = constant;
        this.heating = heating;
        this.supplying = supplying;
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

    public double getCirculation() {
        return circulation;
    }

    public void setCirculation(double circulation) {
        this.circulation = circulation;
    }

    public double getConstant() {
        return constant;
    }

    public void setConstant(double constant) {
        this.constant = constant;
    }

    public double getHeating() {
        return heating;
    }

    public void setHeating(double heating) {
        this.heating = heating;
    }

    public double getSupplying() {
        return supplying;
    }

    public void setSupplying(double supplying) {
        this.supplying = supplying;
    }

    

}
