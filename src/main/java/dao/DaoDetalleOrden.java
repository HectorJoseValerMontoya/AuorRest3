/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.DetalleOrden;
import modelo.Orden;
import util.MySQLConexion;

/**
 *
 * @author HJVM
 */
public class DaoDetalleOrden {

    public boolean existePlatoAgregadoEnDetalleOrden(Orden o) {
        String sql = "call mostrarPlatoAgregadoEnDetalleOrden(?, ?, ?);";
        Connection cn = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, o.getCodMesa());
            st.setInt(2, o.getCodPlato());
            st.setInt(3, o.getCodOrden());
            if (st.executeQuery().next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void agregarPlatoEnDetalleOrden(Orden do_) {
        String sql = "insert into detalleOrden values (null, ?, ?, ?, default);";
        Connection cn = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, do_.getCodOrden());
            st.setInt(2, do_.getCodPlato());
            st.setInt(3, do_.getCantidad());
            st.executeUpdate();

        } catch (Exception e) {
        }
    }

    public int cantidadAnterior(DetalleOrden do_) {
        String sql = "select cantidad from detalleOrden where codOrden = ? and codPlato = ?;";
        Connection cn = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, do_.getCodOrden());
            st.setInt(2, do_.getCodPlato());
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }

        } catch (Exception e) {
        }
        
        return 0;
    }

    public void actualizarPlatoAgregadoEnDetalleOrden(DetalleOrden do_) {
        int cantidad = do_.getCantidad() + cantidadAnterior(do_);
        String sql = "update detalleOrden set cantidad = ? where codOrden = ? and codPlato = ?;";
        Connection cn = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, cantidad);
            st.setInt(2, do_.getCodOrden());
            st.setInt(3, do_.getCodPlato());
            st.executeUpdate();

        } catch (Exception e) {
        }
    }
    
    public void Cobrar(int codMesa){
        //Actualizar el estado de la mesa y orden
        String sql = "call cobrarDetalleOrden(?);";//_codMesa int, _codDetalleOrden int
        Connection cn = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, codMesa);
            st.executeUpdate();

        } catch (Exception e) {
        }
    }
}
