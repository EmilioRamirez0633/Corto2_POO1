/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Estudiante
 */
public class SeresVivos {
    private int idSerVivo;
    private String nombreSerVivo;
    private String desSerVivo;
    private int refSerVivo;
    private String refNomSerVivo;


    @Override
    public String toString() {
        return this.nombreSerVivo;
    }

    public SeresVivos(int idSerVivo,int refSerVivo, String refNomSerVivo, String nombreSerVivo, String desSerVivo) {
        this.idSerVivo = idSerVivo;
        this.nombreSerVivo = nombreSerVivo;
        this.desSerVivo = desSerVivo;
        this.refSerVivo = refSerVivo;
        this.refNomSerVivo = refNomSerVivo;
    }

    public SeresVivos() {
    }

    public int getIdSerVivo() {
        return idSerVivo;
    }

    public void setIdSerVivo(int idSerVivo) {
        this.idSerVivo = idSerVivo;
    }

    public String getNombreSerVivo() {
        return nombreSerVivo;
    }

    public void setNombreSerVivo(String nombreSerVivo) {
        this.nombreSerVivo = nombreSerVivo;
    }

    public String getDesSerVivo() {
        return desSerVivo;
    }

    public void setDesSerVivo(String desSerVivo) {
        this.desSerVivo = desSerVivo;
    }

    public int getRefSerVivo() {
        return refSerVivo;
    }

    public void setRefSerVivo(int refSerVivo) {
        this.refSerVivo = refSerVivo;
    }

    public String getRefNomSerVivo() {
        return refNomSerVivo;
    }

    public void setRefNomSerVivo(String refNomSerVivo) {
        this.refNomSerVivo = refNomSerVivo;
    }

    
}
