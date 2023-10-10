/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;
import util.MySQLConexion;

/**
 *
 * @author HJVM
 */
public class DaoEmpleado {

    //-------------------------------- PROCESO REGISTRARSE EMPLEADO --------------------------------
    public void registrarEmpleado(Empleado empleado) {
        /*
        create table empleado(
            codEmpleado int not null auto_increment,
            nombreEmpleado varchar(100) not null,
            apellidoEmpleado varchar(100) not null,
            contra varchar(20) not null,
            codPerfil int not null,
            estado int default 1,
            primary key(codEmpleado),
            foreign key(codPerfil) references perfilEmpleado(codPerfil)
        ) auto_increment = 1001;

         */
        String sql = "call registrarEmpleado(?,?,?,?);";

        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setString(1, empleado.getNombreEmpleado());
            st.setString(2, empleado.getApellidoEmpleado());
            st.setString(3, empleado.getContrasenaEmpleado());
            st.setInt(4, empleado.getCodPerfilEmpleado());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    //-------------------------------- FIN PROCESO REGISTRARSE EMPLEADO --------------------------------
    //-------------------------------- PROCESO RECOLECTAR DATOS EMPLEADO --------------------------------
    public List<Empleado> getDatosEmpleadoYPerfilCompleto() {
        List<Empleado> empleados = new ArrayList<>();

        String sql = "call mostrarTodosLosDatosDeEmpleadoYPerfil();";

        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();

                empleado.setCodEmpleado(rs.getInt(1));
                empleado.setNombreEmpleado(rs.getString(2));
                empleado.setApellidoEmpleado(rs.getString(3));
                empleado.setContrasenaEmpleado(rs.getString(4));
                empleado.setCodPerfilEmpleado(rs.getInt(5));
                empleado.setEstadoEmpleado(rs.getInt(6));
                //empleado.setCodPerfilEmpleado(rs.getInt(7)); -> Ya está incluido en la parte anterior
                empleado.setCargoPerfilEmpleado(rs.getString(8));
                empleado.setEstadoPerfilEmpleado(rs.getInt(9));

                empleados.add(empleado);
            }
        } catch (Exception e) {
        }

        return empleados;
    }
    
    public Empleado getDatosEmpleadoConPerfilEmpleado(int codEmpleado){
        Empleado empleado = new Empleado();
        Connection cn = null;
        String sql = "call DatosEmpleadoConPerfilEmpleado(?);";
        
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, codEmpleado);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                empleado.setCodEmpleado(rs.getInt(1));
                empleado.setNombreEmpleado(rs.getString(2));
                empleado.setApellidoEmpleado(rs.getString(3));
                empleado.setContrasenaEmpleado(rs.getString(4));
                empleado.setCodPerfilEmpleado(rs.getInt(5));
                empleado.setEstadoEmpleado(rs.getInt(6));
                //empleado.setCodPerfilEmpleado(rs.getInt(7)); -> Ya está incluido en la parte anterior
                empleado.setCargoPerfilEmpleado(rs.getString(8));
                empleado.setEstadoPerfilEmpleado(rs.getInt(9));
            }
        } catch (Exception e) {
        }
        
        return empleado;
    }
    
    //-------------------------------- FIN PROCESO RECOLECTAR DATOS EMPLEADO --------------------------------
    
    
    //-------------------------------- PROCESO SIGUIENTE DATOS EMPLEADO --------------------------------
    
    public int getSiguienteCodEmpleado(){
        String sql = "select max(codEmpleado) + 1 from empleado;";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        
        return -1;
    }
    
    //-------------------------------- FIN PROCESO SIGUIENTE DATOS EMPLEADO --------------------------------
    
    
    public void eliminarEmpleado(int codEmpleado){
        String sql = "call eliminarEmpleado(?)";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, codEmpleado);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    public void actualizarEmpleado(Empleado emp){
        String sql = "call actualizarEmpleado(?, ?, ?, ?, ?,?)";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setString(1, emp.getNombreEmpleado());
            st.setString(2,emp.getApellidoEmpleado());
            st.setString(3, emp.getContrasenaEmpleado());
            st.setInt(4, emp.getCodPerfilEmpleado());
            st.setInt(5, emp.getEstadoEmpleado());
            st.setInt(6, emp.getCodEmpleado());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
}
