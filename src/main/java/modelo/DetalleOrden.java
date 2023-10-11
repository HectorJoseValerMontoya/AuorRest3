/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HJVM
 */
public class DetalleOrden {

    private int codDetalleOrden;
    private int codOrden;
    private int codPlato;
    private int cantidad;

    public int getCodDetalleOrden() {
        return codDetalleOrden;
    }

    public void setCodDetalleOrden(int codDetalleOrden) {
        this.codDetalleOrden = codDetalleOrden;
    }

    public int getCodOrden() {
        return codOrden;
    }

    public void setCodOrden(int codOrden) {
        this.codOrden = codOrden;
    }

    public int getCodPlato() {
        return codPlato;
    }

    public void setCodPlato(int codPlato) {
        this.codPlato = codPlato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
