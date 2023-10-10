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
import modelo.Plato;
import util.MySQLConexion;

/**
 *
 * @author HJVM
 */
public class DaoPlato {

    public List<Plato> getListarPlatosActivos() {
        List<Plato> platos = new ArrayList<>();

        String sql = "call mostrarTodosLosDatosDePlatosActivos();";

        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Plato plato = new Plato();
                plato.setCodPlato(rs.getInt(1));
                plato.setNombrePlato(rs.getString(2));
                plato.setPrecioPlato(rs.getDouble(3));
                plato.setCodCategoriaPlato(rs.getInt(4));
                plato.setEstadoPlato(rs.getInt(5));
                plato.setImagenPlato(rs.getString(6));
                //plato.setCodCategoriaPlato(rs.getInt(7));
                plato.setNombreCategoria(rs.getString(8));
                plato.setEstadoCategoria(rs.getInt(9));

                platos.add(plato);
            }
        } catch (Exception e) {
        }

        return platos;
    }

    public List<Plato> getListarPlatosTotal() {
        List<Plato> platos = new ArrayList<>();

        String sql = "call mostrarTodosLosDatosDePlatos();";

        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Plato plato = new Plato();
                plato.setCodPlato(rs.getInt(1));
                plato.setNombrePlato(rs.getString(2));
                plato.setPrecioPlato(rs.getDouble(3));
                plato.setCodCategoriaPlato(rs.getInt(4));
                plato.setEstadoPlato(rs.getInt(5));
                plato.setImagenPlato(rs.getString(6));
                //plato.setCodCategoriaPlato(rs.getInt(7));
                plato.setNombreCategoria(rs.getString(8));
                plato.setEstadoCategoria(rs.getInt(9));

                platos.add(plato);
            }
        } catch (Exception e) {
        }

        return platos;
    }

    public int getSiguienteCodigoPlato() {
        String sql = "select max(codPlato) + 1 from plato;";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public void registrarPlato(Plato p) {
        String sql = "insert into plato values (null, ?, ?, ?, default, ?);";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, p.getNombrePlato());
            st.setDouble(2, p.getPrecioPlato());
            st.setInt(3, p.getCodCategoriaPlato());
            st.setString(4, p.getImagenPlato());

            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void eliminarPlato(int _codPlato) {
        String sql = "call eliminarPlato(?)";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, _codPlato);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Plato getDatosPlato(int _codPlato) {
        String sql = "call mostrarTodosLosDatosDeUnPlato(?)";
        Connection cn = null;
        Plato plato = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, _codPlato);
            ResultSet rs = st.executeQuery();
            if  (rs.next()) {
                plato = new Plato();
                plato.setCodPlato(rs.getInt(1));
                plato.setNombrePlato(rs.getString(2));
                plato.setPrecioPlato(rs.getDouble(3));
                plato.setCodCategoriaPlato(rs.getInt(4));
                plato.setEstadoPlato(rs.getInt(5));
                plato.setImagenPlato(rs.getString(6));
                //plato.setCodCategoriaPlato(rs.getInt(7));
                plato.setNombreCategoria(rs.getString(8));
                plato.setEstadoCategoria(rs.getInt(9));

            }
        } catch (Exception e) {
        }
        return plato;
    }
    
    public void actualizarPlato(Plato p){
        String sql = "call actualizarPlato(?, ?, ?, ?)";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setString(1, p.getNombrePlato());
            st.setDouble(2, p.getPrecioPlato());
            st.setInt(3, p.getCodCategoriaPlato());
            st.setInt(4, p.getCodPlato());
            
            st.executeUpdate();
            
        } catch (Exception e) {
        }
    }

}
