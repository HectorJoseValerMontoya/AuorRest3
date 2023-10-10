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
import modelo.CategoriaPlato;
import util.MySQLConexion;

/**
 *
 * @author HJVM
 */
public class DaoCategoriaPlato {

    public List<CategoriaPlato> getListarCategoriaPlatosActivos() {
        List<CategoriaPlato> categoriaPlatos = new ArrayList<>();

        String sql = "call mostrarTodosLosDatosDeCategoriaPlatosActivos();";

        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoriaPlato categoriaPlato = new CategoriaPlato();

                categoriaPlato.setCodCategoriaPlato(rs.getInt(1));
                categoriaPlato.setNombreCategoria(rs.getString(2));
                categoriaPlato.setEstadoCategoria(rs.getInt(3));

                categoriaPlatos.add(categoriaPlato);
            }
        } catch (Exception e) {
        }

        return categoriaPlatos;
    }

    public List<CategoriaPlato> getListarCategoriaPlatosTotal() {
        List<CategoriaPlato> categoriaPlatos = new ArrayList<>();

        String sql = "call mostrarTodosLosDatosDeCategoriaPlatos();";

        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoriaPlato categoriaPlato = new CategoriaPlato();

                categoriaPlato.setCodCategoriaPlato(rs.getInt(1));
                categoriaPlato.setNombreCategoria(rs.getString(2));
                categoriaPlato.setEstadoCategoria(rs.getInt(3));

                categoriaPlatos.add(categoriaPlato);
            }
        } catch (Exception e) {
        }

        return categoriaPlatos;
    }

    public int getSiguienteCodigoPlato() {
        String sql = "select max(codCategoriaPlato) + 1 from categoriaPlato;";
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

    public void registrarPlato(CategoriaPlato p) {
        String sql = "insert into categoriaPlato values (null, ?, default);";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, p.getNombreCategoria());

            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void eliminarCategoriaPlato(int _codCategoriaPlato) {
        String sql = "call eliminarCategoriaPlato(?);";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, _codCategoriaPlato);

            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public String getNombreTipoCategoria(int codCategoriaPlato) {
        Connection cn = null;
        String sql = "call nombreTipoCategoria(?);";
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, codCategoriaPlato);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public CategoriaPlato getCategoriaPlato(int _codCategoriaPlato){
        Connection cn = null;
         CategoriaPlato cp = null;
        String sql = "select * from categoriaPlato where codCategoriaPlato = " + _codCategoriaPlato;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cp = new CategoriaPlato();
                cp.setCodCategoriaPlato(rs.getInt(1));
                cp.setNombreCategoria(rs.getString(2));
                cp.setEstadoCategoria(rs.getInt(3));
                
            }
        } catch (Exception e) {
        }
        return cp;
    }
    
    public void actualizarCategoriaPlato(CategoriaPlato cp){
        String sql = "update categoriaPlato set nombreCategoria = ? where codCategoriaPlato = ?;";
        Connection cn = null;
        try {
            cn = MySQLConexion.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, cp.getNombreCategoria());
            st.setInt(2, cp.getCodCategoriaPlato());
            
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
}
