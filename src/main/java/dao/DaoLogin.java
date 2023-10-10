/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Empleado;
import util.MySQLConexion;

/**
 *
 * @author HJVM
 */
public class DaoLogin {

    //-------------------------------- PROCESO LOGIN --------------------------------
    public boolean existeCodigoUsuario(int codigoEmpleado) {
        Connection con = null;
        try {
            con = MySQLConexion.getConexion();
            String sql = "select contra from empleado where CodEmpleado = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigoEmpleado);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public String ContraUsuario(int codigoEmpleado) {
        Connection con = null;
        try {
            con = MySQLConexion.getConexion();
            String sql = "select contra from empleado where CodEmpleado = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigoEmpleado);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    //-------------------------------- FIN PROCESO LOGIN --------------------------------
    /////////////////////////////////////// SEPARADOR /////////////////////////////////////
    
}
