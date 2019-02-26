package com.example.appsqliteciudades.model;

public class Ciudad {

    private int id;
    private  String nombre;
    private  String provincia;
    private int numHab;

    public Ciudad(int id, String nombre, String provincia, int numHab) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.numHab = numHab;
    }

    public Ciudad(String nombre, String provincia, int numHab) {
        id=-1;
        this.nombre = nombre;
        this.provincia = provincia;
        this.numHab = numHab;
    }

    public int getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getNumHab() {
        return numHab;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }
}
