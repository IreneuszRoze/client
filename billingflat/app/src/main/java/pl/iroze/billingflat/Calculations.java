package pl.iroze.billingflat;

import java.time.LocalDate;

import pl.iroze.billingflat.model.RateElectriocity;
import pl.iroze.billingflat.model.RateGas;
import pl.iroze.billingflat.model.RateWater;
import pl.iroze.billingflat.model.State;

import static java.time.temporal.ChronoUnit.DAYS;

public class Calculations {


    public static double calculationGas(State last, State now, RateGas rateGas) {

        long time = daysbetween(last.getDate(), now.getDate());
        double use = now.getState() - last.getState();

        double suma = time / 30 * rateGas.getConstant() + use * rateGas.getUse();
        return suma;

    }

    public static double calculationHotWater(State last, State now, RateWater rateWater) {

        long time = daysbetween(last.getDate(), now.getDate());
        double use = now.getState() - last.getState();


        double suma = (rateWater.getSupplying() + rateWater.getHeating()) * use;
        suma += (rateWater.getCirculation() + rateWater.getConstant()) * time / 12;
        return suma;
    }

    public static double calculationColdWater(State last, State now, RateWater rateWater) {

        long time = daysbetween(last.getDate(), now.getDate());
        double use = now.getState() - last.getState();

        double suma = rateWater.getSupplying() * use;
        suma += (rateWater.getCirculation() + rateWater.getConstant()) * time / 12;

        return suma;
    }

    public static double calculationElectriocity(State last, State now, RateElectriocity rateElectriocity) {

        long time = daysbetween(last.getDate(), now.getDate());
        double use = now.getState() - last.getState();

        double suma = rateElectriocity.getTrade();

        suma += (rateElectriocity.getNetwork() + rateElectriocity.getTransitional() + rateElectriocity.getSubscription()) * time / 30;
        suma += (rateElectriocity.getActive() + rateElectriocity.getQuality() + rateElectriocity.getVariablel() + rateElectriocity.getOZE()) * use;

        return suma;
    }

    private static long daysbetween(LocalDate last, LocalDate now) {
        return DAYS.between(last, now);
    }

}
