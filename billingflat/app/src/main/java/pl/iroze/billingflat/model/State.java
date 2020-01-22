package pl.iroze.billingflat.model;

import java.time.LocalDate;

public class State {

    private int id;
    private LocalDate date;
    private double state;

    public State(int id, LocalDate date, double state) {
        this.id = id;
        this.date = date;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getState() {
        return state;
    }

    public void setState(double state) {
        this.state = state;
    }

    public State(double state, LocalDate date) {
        this.date = date;
        this.state = state;
    }

}
