/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author HJVM
 */
public class PerfilEmpleado {
    private int codPerfilEmpleado;
    private String cargoPerfilEmpleado;
    private int estadoPerfilEmpleado;

    public int getCodPerfilEmpleado() {
        return codPerfilEmpleado;
    }

    public void setCodPerfilEmpleado(int codPerfilEmpleado) {
        this.codPerfilEmpleado = codPerfilEmpleado;
    }

    public String getCargoPerfilEmpleado() {
        return cargoPerfilEmpleado;
    }

    public void setCargoPerfilEmpleado(String cargoPerfilEmpleado) {
        this.cargoPerfilEmpleado = cargoPerfilEmpleado;
    }

    public int getEstadoPerfilEmpleado() {
        return estadoPerfilEmpleado;
    }

    public void setEstadoPerfilEmpleado(int estadoPerfilEmpleado) {
        this.estadoPerfilEmpleado = estadoPerfilEmpleado;
    }
   public String getTipoEstado(){
        return estadoPerfilEmpleado == 1 ? "Activo" : estadoPerfilEmpleado == 2 ? "Inactivo" : "DESCONOCIDO";
    }
}
