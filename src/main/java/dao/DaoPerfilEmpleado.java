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
import modelo.PerfilEmpleado;
import util.MySQLConexion;

public class DaoPerfilEmpleado {

    //-------------------------------- PROCESO RECOLECTAR PERFIL EMPLEADO --------------------------------
    public List<PerfilEmpleado> getPerfilesEmpleado() {
        List<PerfilEmpleado> perfiles = new ArrayList<>();

        String sql = "select * from perfilEmpleado";

        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PerfilEmpleado pe = new PerfilEmpleado();
                pe.setCodPerfilEmpleado(rs.getInt(1));
                pe.setCargoPerfilEmpleado(rs.getString(2));
                pe.setEstadoPerfilEmpleado(rs.getInt(3));
                perfiles.add(pe);
            }
        } catch (Exception e) {
        }

        return perfiles;
    }

    public PerfilEmpleado getPerfilEmpleado(int codPerfilEmpleado) {
        PerfilEmpleado pe = new PerfilEmpleado();
        String sql = "select * from perfilEmpleado where codPerfilEmpleado = " + codPerfilEmpleado;

        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                pe.setCodPerfilEmpleado(rs.getInt(1));
                pe.setCargoPerfilEmpleado(rs.getString(2));
                pe.setEstadoPerfilEmpleado(rs.getInt(3));

            }
        } catch (Exception e) {
        }

        return pe;
    }

    //-------------------------------- FIN PROCESO RECOLECTAR PERFIL EMPLEADO --------------------------------
    //-------------------------------- PROCESO REGISTRAR PERFIL EMPLEADO --------------------------------
    public void registrarPerfilEmpleado(PerfilEmpleado perfilEmp) {
        String sql = "call registrarPerfilEmpleado(?);";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setString(1, perfilEmp.getCargoPerfilEmpleado());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    //-------------------------------- FIN PROCESO REGISTRAR PERFIL EMPLEADO --------------------------------

    public String cargoEmpleado(int codEmpleado) {
        Connection cn = null;
        String sql = "call cargoEmpleado(?);";
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, codEmpleado);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }
//actualizarPerfilEmpleado
    public void actualizarPerfilEmpleado(PerfilEmpleado pe){
        String sql = "call actualizarPerfilEmpleado(?, ?, ?)";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setString(1, pe.getCargoPerfilEmpleado());
            st.setInt(2, pe.getEstadoPerfilEmpleado());
            st.setInt(3, pe.getCodPerfilEmpleado());
            
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
     public void eliminarPerfilEmpleado(int codPerfilEmpleado){
        String sql = "call eliminarPerfilEmpleado(?)";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, codPerfilEmpleado);
            
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
}
