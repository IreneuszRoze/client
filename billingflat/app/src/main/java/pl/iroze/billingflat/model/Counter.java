package pl.iroze.billingflat.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Counter {

    private int id;
    private String number;
    private List<State> state = new ArrayList();
    private String description;
    private State settledState; // rozliczony odczyt
    private State lastState; // ostatni odczyt
    private double arrears; // zaległosc róznica miedzy statted a last stanami

    public double getArrears() {
        return arrears;
    }

    public void setArrears(double arrears) {
        this.arrears = arrears;
    }

    public Counter(int id, String number, String description) {
        this.id = id;
        this.number = number;
        this.description = description;
    }

    public void addState(State state) {
        this.state.add(state);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<State> getState() {
        return state;
    }

    public void setState(List<State> state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract  Type getType();

    public State getLastState() {
        return lastState;
    }

    public void setLastState(State lastState) {
        this.lastState = lastState;
    }

    public State getSettledState() {
        return settledState;
    }

    public void setSettledState(State settledState) {
        this.settledState = settledState;
    }
}


