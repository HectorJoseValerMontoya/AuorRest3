/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HJVM
 */
public class Orden extends DetalleOrden {

    private int codMesa;
    private int codEmpleado;
    private int estadoOrden;

    public int getCodMesa() {
        return codMesa;
    }

    public void setCodMesa(int codMesa) {
        this.codMesa = codMesa;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public int getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(int estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

}
