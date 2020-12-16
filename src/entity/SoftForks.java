package entity;

import entity.Bip;

public class SoftForks {
    private Bip bip34;
    private Bip bip66;
    private Bip bip65;
    private Bip csv;
    private Bip segwit;

    public Bip getBip34() {
        return bip34;
    }

    public void setBip34(Bip bip34) {
        this.bip34 = bip34;
    }

    public Bip getBip66() {
        return bip66;
    }

    public void setBip66(Bip bip66) {
        this.bip66 = bip66;
    }

    public Bip getBip65() {
        return bip65;
    }

    public void setBip65(Bip bip65) {
        this.bip65 = bip65;
    }

    public Bip getCsv() {
        return csv;
    }

    public void setCsv(Bip csv) {
        this.csv = csv;
    }

    public Bip getSegwit() {
        return segwit;
    }

    public void setSegwit(Bip segwit) {
        this.segwit = segwit;
    }
}
