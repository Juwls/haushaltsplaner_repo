package com.example.ha_pla;

public class EinkaufenData {
    private String haushalt;
    private String pos;
    private String einkaufsobjekt;




    public EinkaufenData(String einkaufsobjekt) {
        this.einkaufsobjekt = einkaufsobjekt;
    }


    public String getEinkaufsobjekt() {
        return einkaufsobjekt;
    }
}
