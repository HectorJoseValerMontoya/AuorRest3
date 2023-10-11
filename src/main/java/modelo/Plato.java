/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.DaoCategoriaPlato;

/**
 *
 * @author HJVM
 */
public class Plato extends CategoriaPlato{

    private int codPlato;
    private String nombrePlato;
    private double precioPlato;
    private int estadoPlato;
    private String imagenPlato;

    public int getCodPlato() {
        return codPlato;
    }

    public void setCodPlato(int codPlato) {
        this.codPlato = codPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }

    public int getEstadoPlato() {
        return estadoPlato;
    }

    public void setEstadoPlato(int estadoPlato) {
        this.estadoPlato = estadoPlato;
    }

    public String getImagenPlato() {
        return imagenPlato;
    }

    public void setImagenPlato(String imagenPlato) {
        this.imagenPlato = imagenPlato;
    }

    public String getTipoEstado() {
        return estadoPlato == 1 ? "Activo" : estadoPlato == 2 ? "Inactivo" : "DESCONOCIDO";
    }
    
    public String getNombreTipoCategoria(){
        DaoCategoriaPlato dao = new DaoCategoriaPlato();
        return dao.getNombreTipoCategoria(getCodCategoriaPlato());
    }
    
    public String getImgPlato(){
        return "falta";
    }
}
