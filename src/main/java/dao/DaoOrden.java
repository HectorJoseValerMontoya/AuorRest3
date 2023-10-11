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
import javax.swing.JOptionPane;
import modelo.Orden;
import util.MySQLConexion;

/**
 *
 * @author HJVM
 */
public class DaoOrden {

    public boolean existeOrden(Orden o) {
        String sql = "select * from orden where codOrden = ?;";

        Connection cn = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, o.getCodOrden());
            if (st.executeQuery().next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public int siguienteOrden() {
        String sql = "select max(codOrden) + 1 from orden;";

        Connection cn = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return 1;
                } else {
                    return rs.getInt(1);

                }
            }
        } catch (Exception e) {

        }
        return 1;
    }

    public void setCrearOrden(Orden o) {
        String sql = "insert into orden values (null, ?, ?, default);";//codMesa  & codEmpleado
        Connection cn = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, o.getCodMesa());
            st.setInt(2, o.getCodEmpleado());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public List<Orden> getListarOrdenes(int codOrden){
        List<Orden> ordenes = new ArrayList<>();
        Connection cn = null;
        String sql = "select * from orden o inner join detalleOrden _do on o.codOrden = _do.codOrden where _do.codOrden = ?;";
        
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, codOrden);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Orden o = new Orden();
                o.setCodOrden(rs.getInt(1));
                o.setCodMesa(rs.getInt(2));
                o.setCodEmpleado(rs.getInt(3));
                o.setEstadoOrden(rs.getInt(4));
                o.setCodDetalleOrden(rs.getInt(5));
                //o.setCodOrden(rs.getInt(6));
                o.setCodPlato(rs.getInt(7));
                o.setCantidad(rs.getInt(8));
                o.setEstadoDetalleOrden(rs.getInt(9));
                ordenes.add(o);
            }

        } catch (Exception e) {
        }
        
        return ordenes;
    }
    
    public int getCodOrden(int codMesa){
        String sql="select o.codOrden from orden o inner join detalleOrden _do on o.codOrden = _do.codOrden  where codMesa = ? order by o.codOrden desc limit 1;";
        Connection cn = null;
        
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, codMesa);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()){
                return rs.getInt(1);
            }

        } catch (Exception e) {
        }
        return -1;
    }
}
