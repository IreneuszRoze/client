package pl.iroze.billingflat.model;

import java.time.LocalDate;

public class RateElectriocity extends Rate {

    private int id;
    private LocalDate date;
    private double active; // energia czynna
    private double trade; // opłata handlowa
    private double quality; // opłata jakościowa
    private double variablel; // opłata sieciowa zmienna
    private double OZE; // opłata oze;
    private double network;  // opłata sieciowa stała
    private double transitional; // opłata przejsciowa
    private double subscription; // opłata abonamentowa
    private double VAT; // Vat

    public RateElectriocity(int id, LocalDate date, double active, double trade, double quality, double variablel, double OZE, double network, double transitional, double subscription, double VAT) {
        this.id = id;
        this.date = date;
        this.active = active;
        this.trade = trade;
        this.quality = quality;
        this.variablel = variablel;
        this.OZE = OZE;
        this.network = network;
        this.transitional = transitional;
        this.subscription = subscription;
        this.VAT = VAT;
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

    public double getActive() {
        return active;
    }

    public void setActive(double active) {
        this.active = active;
    }

    public double getTrade() {
        return trade;
    }

    public void setTrade(double trade) {
        this.trade = trade;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public double getVariablel() {
        return variablel;
    }

    public void setVariablel(double variablel) {
        this.variablel = variablel;
    }

    public double getOZE() {
        return OZE;
    }

    public void setOZE(double OZE) {
        this.OZE = OZE;
    }

    public double getNetwork() {
        return network;
    }

    public void setNetwork(double network) {
        this.network = network;
    }

    public double getTransitional() {
        return transitional;
    }

    public void setTransitional(double transitional) {
        this.transitional = transitional;
    }

    public double getSubscription() {
        return subscription;
    }

    public void setSubscription(double subscription) {
        this.subscription = subscription;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }
}
