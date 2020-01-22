package pl.iroze.billingflat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import pl.iroze.billingflat.model.Business;
import pl.iroze.billingflat.model.Counter;
import pl.iroze.billingflat.model.Example;
import pl.iroze.billingflat.model.Flat;
import pl.iroze.billingflat.model.Rate;
import pl.iroze.billingflat.model.RateGas;
import pl.iroze.billingflat.model.State;
import pl.iroze.billingflat.model.Type;

import static java.time.temporal.ChronoUnit.DAYS;
import static pl.iroze.billingflat.model.Type.ELECTRIOCITY;

public class Warehouse {

    private Business business;


    // pobiera listę biznesów
    public void init() {
        business = Example.generate();
    }


    // zwraca liste mieszkan (FlatList)
    public ArrayList<Flat> getFlats() {
        ArrayList<Flat> array = new ArrayList<>(business.getFlat());
        return array;
    }

    // zwraca liczbe biznesów
    public int countFlat() {
        return (business.getFlat().size());
    }

    // zwraca listę liczników dla mieszkania (CounterList)
    public ArrayList<Counter> getCounterList(Flat flat) {

        ArrayList<Counter> array = new ArrayList<>(flat.getCounters());
        return array;
    }

    // ustawia roliczony stan
    public void setSettled(Counter counter, State state) {
        counter.setSettledState(state);
    }


    // dodawnaie nowego stanu - formularz state (State)
    public void setNewState(Flat flat, Counter counter, State state) {
        counter.addState(state);
        counter.setLastState(state);
        calculation(flat, counter);
    }

    // zatwierdzenie płatnosci (Settlement)
    public void pay(Flat flat) {

        for (Counter counter : flat.getCounters()) {
            counter.setSettledState(counter.getLastState());
            calculation(flat, counter);
        }
    }

    private void calculation(Flat flat, Counter counter) {
        State stateLast = counter.getSettledState();
        State stateNow = counter.getLastState();

        double suma = 0;

        if ((stateLast != null) && (stateNow != null)) {
            switch (counter.getType()) {
                case COLD_WATER:
                    suma = Calculations.calculationColdWater(stateLast, stateNow, flat.getRateWater());
                    break;
                case HOT_WATER:
                    suma = Calculations.calculationHotWater(stateLast, stateNow, flat.getRateWater());
                    break;
                case ELECTRIOCITY:
                    suma = Calculations.calculationElectriocity(stateLast, stateNow, flat.getRateElectriocity());
                    break;
                case GAS:
                    suma = Calculations.calculationGas(stateLast, stateNow, flat.getRateGas());
                    break;
            }
        }
        counter.setArrears(suma);

    }

}
