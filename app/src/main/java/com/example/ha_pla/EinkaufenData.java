package com.example.ha_pla;

public class EinkaufenData {
    private String haushalt;
    private String pos;
    private String einkaufsobjekt;


    public EinkaufenData(String haushalt, String pos, String einkaufsobjekt) {
        this.haushalt = haushalt;
        this.pos = pos;
        this.einkaufsobjekt = einkaufsobjekt;
    }

    public EinkaufenData(String einkaufsobjekt) {
        this.einkaufsobjekt = einkaufsobjekt;
    }

    public String getHaushalt() {
        return haushalt;
    }

    public String getPos() {
        return pos;
    }

    public String getEinkaufsobjekt() {
        return einkaufsobjekt;
    }
}
