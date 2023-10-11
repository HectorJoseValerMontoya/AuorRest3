/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.DaoPlato;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Plato;

public class SPlato extends HttpServlet {

    DaoPlato daoPlato = new DaoPlato();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("op"));

        switch (op) {
            case 1:
                registrase(request, response);
                break;
            case 2://Editar
                editar(request, response);
                break;

            case 3://Eliminar
                eliminar(request, response);
                break;
        }
    }
    
    protected void registrase(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //int codPlato = Integer.parseInt(request.getParameter("codPlato"));
        String nombrePlato = request.getParameter("nombrePlato");
        double precioPlato = Double.parseDouble(request.getParameter("precioPlato"));
        int codCategoria = Integer.parseInt(request.getParameter("categoriaDelPlato"));
        String img = request.getParameter("imagenPlato");
        
        Plato p = new Plato();
        
        p.setCodCategoriaPlato(codCategoria);
        p.setNombrePlato(nombrePlato);
        p.setPrecioPlato(precioPlato);
        p.setImagenPlato(img.trim().equals("") ? null : img);
        
        JOptionPane.showMessageDialog(null, img);
        daoPlato.registrarPlato(p);
        
        request.getRequestDispatcher("pagPlato.jsp").forward(request, response);
    }

    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigoPlato = Integer.parseInt(request.getParameter("codigoPlato"));
        String nombrePlato = request.getParameter("nombrePlato");
        double precioPlato = Double.parseDouble(request.getParameter("precioPlato"));
        int codCategoria = Integer.parseInt(request.getParameter("codCategoria"));
        
        Plato p = new Plato();
        p.setCodPlato(codigoPlato);
        p.setNombrePlato(nombrePlato);
        p.setPrecioPlato(precioPlato);
        p.setCodCategoriaPlato(codCategoria);
        
        
        daoPlato.actualizarPlato(p);
        
        request.getRequestDispatcher("pagPlato.jsp").forward(request, response);
        
        //categoria
    }
    
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codPlato = Integer.parseInt(request.getParameter("codigoPlato"));
        daoPlato.eliminarPlato(codPlato);
        
        request.getRequestDispatcher("pagPlato.jsp").forward(request, response);
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
