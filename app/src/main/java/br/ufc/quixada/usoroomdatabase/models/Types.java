package br.ufc.quixada.usoroomdatabase.models;

public class Types {
    private String normal;
    private String fire;
    private String Eletric;
    private String Ice;

    public Types(String normal, String fire, String eletric, String ice) {
        this.normal = normal;
        this.fire = fire;
        Eletric = eletric;
        Ice = ice;
    }

    public Types(String normal) {
    }
}
