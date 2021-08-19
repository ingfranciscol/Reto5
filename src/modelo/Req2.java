/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Req2 {

    private int estrato;
    private String fechaInicio;
    private int financiable;
    private double porcetaje;

    public Req2(int estrato, String fechaInicio, int financiable, double porcetaje) {
        this.estrato = estrato;
        this.fechaInicio = fechaInicio;
        this.financiable = financiable;
        this.porcetaje = porcetaje;
    }

    @Override
    public String toString() {
        return "Req2 [" + "estrato=" + estrato + ", fechaInicio=" + fechaInicio + ", financiable=" + financiable + ", porcetaje=" + porcetaje + ']';
    }    
}
