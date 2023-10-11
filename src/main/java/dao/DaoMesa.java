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
import modelo.Mesa;
import util.MySQLConexion;

/**
 *
 * @author HJVM
 */
public class DaoMesa {

    public List<Mesa> getMesas() {
        List<Mesa> mesas = new ArrayList<>();
        String sql = "select * from mesa;";
        Connection cn = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setCodMesa(rs.getInt(1));
                mesa.setDescripcion(rs.getString(2));
                mesa.setEstadoMesa(rs.getInt(3));

                mesas.add(mesa);
            }
        } catch (Exception e) {
        }
        return mesas;
    }

    public void setOcuparMesa(int codMesa) {
        String sql = "update mesa set estadoMesa = 2 where codMesa = ?;";
        Connection cn = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, codMesa);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void setDesocuparMesa(int codMesa){
        String sql = "update mesa set estadoMesa = 1 where codMesa = ?;";
        Connection cn = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, codMesa);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    public void setMantenimientoMesa(int codMesa){
        String sql = "update mesa set estadoMesa = 3 where codMesa = ?;";
        Connection cn = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, codMesa);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Mesa getMesa(int codMesa) {
        String sql = "select * from mesa where codMesa = ?;";
        Connection cn = null;
        Mesa mesa = null;

        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, codMesa);
            ResultSet rs = st.executeQuery();
            if  (rs.next()) {
                mesa = new Mesa();
                mesa.setCodMesa(rs.getInt(1));
                mesa.setDescripcion(rs.getString(2));
                mesa.setEstadoMesa(rs.getInt(3));
            }
        } catch (Exception e) {
        }
        return mesa;
    }

    public void setCambiarEstadoMesa(int codMesa) {
        Mesa mesa = getMesa(codMesa);
        
        if (mesa.getEstadoMesa() == 1){
            setOcuparMesa(codMesa);
        }else{
            setDesocuparMesa(codMesa);
        }
    }
}
