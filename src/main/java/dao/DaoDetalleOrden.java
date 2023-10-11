/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.DetalleOrden;
import modelo.Orden;
import util.MySQLConexion;

/**
 *
 * @author HJVM
 */
public class DaoDetalleOrden {
    public void setAgregarPlato(DetalleOrden detalleOrden){
        
    }
    
    public boolean existePlatoAgregadoEnDetalleOrden(Orden o){
        String sql = "call mostrarPlatoAgregadoEnDetalleOrden(?, ?, ?);";
        Connection cn = null;
        
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, o.getCodMesa());
            st.setInt(2, o.getCodPlato());
            st.setInt(3, o.getCodOrden());
            if (st.executeQuery().next()){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public void agregarPlatoEnDetalleOrden(DetalleOrden do_){
        String sql = "insert into detalleOrden values (null, ?, ?, ?);";
        Connection cn = null;
        
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, do_.getCodDetalleOrden());
            st.setInt(2, do_.getCodPlato());
            st.setInt(3, do_.getCantidad());
            st.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
    public void actualizarPlatoAgregadoEnDetalleOrden(DetalleOrden do_){
        String sql = "update detalleOrden set cantidad = ? where codOrden = ? and codPlato = ?;";
        Connection cn = null;
        
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, do_.getCantidad());
            st.setInt(2, do_.getCodOrden());
            st.setInt(3, do_.getCodPlato());
            st.executeUpdate();
            
        } catch (Exception e) {
        }
    }
}
