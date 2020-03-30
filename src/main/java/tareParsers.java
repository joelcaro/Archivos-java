/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joel Caro G
 */
public class tareParsers {
    private String marca;
    private String modelo;
    private String cilindrada;
    private String id;

    @Override
    public String toString() {
        return "tareParsers{" + "marca=" + marca + ", modelo=" + modelo + ", cilindrada=" + cilindrada + ", id=" + id + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }


    public tareParsers(String marca, String modelo, String cilindrada) {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
    }

    public tareParsers() {
    }
    
}
