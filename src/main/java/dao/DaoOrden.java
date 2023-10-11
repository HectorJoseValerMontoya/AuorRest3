/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Orden;
import util.MySQLConexion;

/**
 *
 * @author HJVM
 */
public class DaoOrden {
    
    public boolean existeOrden(Orden o){
        String sql = "select * from orden where codOrden = ?;";
        
        Connection cn = null;
        
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, o.getCodOrden());
            if (st.executeQuery().next()){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public int siguienteOrden(){
        String sql = "select max(codOrden) + 1 from orden;";
        
        
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
        return 1;
        
    }
}
