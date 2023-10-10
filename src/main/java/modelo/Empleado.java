/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.DaoPerfilEmpleado;

/**
 *
 * @author HJVM
 */
public class Empleado extends PerfilEmpleado {

    private int codEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String contrasenaEmpleado;
    private int estadoEmpleado;

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getContrasenaEmpleado() {
        return contrasenaEmpleado;
    }

    public void setContrasenaEmpleado(String contrasenaEmpleado) {
        this.contrasenaEmpleado = contrasenaEmpleado;
    }

    public int getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(int estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }
    
    public String getTipoEstado(){
        return estadoEmpleado == 1 ? "Activo" : estadoEmpleado == 2 ? "Inactivo" : "DESCONOCIDO";
    }

    public String getNombreTipoPerfil(){
        DaoPerfilEmpleado dao = new DaoPerfilEmpleado();
        return dao.cargoEmpleado(codEmpleado);
    }
    
}
