/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Plato;
import util.MySQLConexion;

/**
 *
 * @author HJVM
 */
public class DaoGrafico {

    public String getLabels() {
        String lbl = "";
        DaoPlato daoP = new DaoPlato();
        for (Plato plato : daoP.getListarPlatosTotal()) {
            lbl += "'" + plato.getNombrePlato() + "',";
        }

        lbl = lbl.substring(0, lbl.length() - 1);
        return lbl;
    }

    public String getDataSets() {
        String ds = "";
        DaoPlato daoP = new DaoPlato();
        Connection cn = null;
        PreparedStatement st;
        ResultSet rs;
        try {
            cn = MySQLConexion.getConexion();
            for (Plato p : daoP.getListarPlatosTotal()) {
                int codP = p.getCodPlato();
                String sql = "select sum(cantidad) from detalleOrden where codPlato = ?;";
                st = cn.prepareStatement(sql);
                st.setInt(1, codP);
                rs = st.executeQuery();
                if (rs.next()){
                    ds += String.valueOf(rs.getInt(1)) + ",";
                }else{
                    ds += 0 + ", ";
                }
            }
        } catch (Exception e) {
        }
        ds = ds.substring(0, ds.length() - 1);
        return ds;
    }
}
