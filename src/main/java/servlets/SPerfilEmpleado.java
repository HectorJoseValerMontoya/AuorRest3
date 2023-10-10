/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.DaoPerfilEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;
import modelo.PerfilEmpleado;

public class SPerfilEmpleado extends HttpServlet {

    DaoPerfilEmpleado dao = new DaoPerfilEmpleado();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("op"));

        switch (op) {
            case 1:
                registrarPerfil(request, response);
                break;
            case 2:
                editarPerfil(request, response);
                break;
            case 3:
                eliminarPerfil(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    protected void registrarPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreCargo = request.getParameter("nombrePerfilEmpleado");
        
        PerfilEmpleado perfilEmp = new Empleado();
        perfilEmp.setCargoPerfilEmpleado(nombreCargo);
        
        dao.registrarPerfilEmpleado(perfilEmp);
        
        request.getRequestDispatcher("pagEmpleado.jsp").forward(request, response);
                
    }
    
    protected void editarPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codPerfil = Integer.parseInt(request.getParameter("codPerfil"));
        String cargo = request.getParameter("nombrePerfil");
        int estado = Integer.parseInt(request.getParameter("estado"));
        
        PerfilEmpleado pe = new PerfilEmpleado();
        pe.setCodPerfilEmpleado(codPerfil);
        pe.setCargoPerfilEmpleado(cargo);
        pe.setEstadoPerfilEmpleado(estado);
        
        dao.actualizarPerfilEmpleado(pe);
        
        request.getRequestDispatcher("pagEmpleado.jsp").forward(request, response);
         
    }
    
    protected void eliminarPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codPerfilEmpleado = Integer.parseInt(request.getParameter("cod"));
        dao.eliminarPerfilEmpleado(codPerfilEmpleado);
        request.getRequestDispatcher("pagEmpleado.jsp").forward(request, response);
         
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
