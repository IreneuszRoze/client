package pl.iroze.billingflat.model;

public enum Role {

        OWNER ("Właściciel"),
        TENANT("Najemca");
        private String stringValue;

        Role(String stringValue) {
            this.stringValue = stringValue;
        }

        public String getName() {
            return stringValue;
        }
    }