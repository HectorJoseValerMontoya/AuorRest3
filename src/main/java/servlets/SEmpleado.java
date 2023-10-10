/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.DaoEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;

public class SEmpleado extends HttpServlet {

    DaoEmpleado daoEmpleado = new DaoEmpleado();

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
        String nombre = request.getParameter("nombreEmpleado");
        String apellido = request.getParameter("apellidoEmpleado");
        String contrasena = request.getParameter("contrasenaEmpleado");
        int codPerfil = Integer.parseInt(request.getParameter("codPerfilEmpleado"));

        Empleado empleado = new Empleado();
        empleado.setNombreEmpleado(nombre);
        empleado.setApellidoEmpleado(apellido);
        empleado.setContrasenaEmpleado(contrasena);
        empleado.setCodPerfilEmpleado(codPerfil);

        daoEmpleado.registrarEmpleado(empleado);

        request.getRequestDispatcher("pagEmpleado.jsp").forward(request, response);
    }

    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codEmpleado = Integer.parseInt(request.getParameter("codEmpleado"));
        String nombre = request.getParameter("nombreEmpleado");
        String apellido = request.getParameter("apellidoEmpleado");
        String contra = request.getParameter("contra");
        int nuevoPerfilEmpleado = Integer.parseInt(request.getParameter("nuevoPerfilEmpleado"));
        int estado = Integer.parseInt(request.getParameter("estado"));
        
        Empleado empleado = new Empleado();
        empleado.setCodEmpleado(codEmpleado);
        empleado.setNombreEmpleado(nombre);
        empleado.setApellidoEmpleado(apellido);
        empleado.setContrasenaEmpleado(contra);
        empleado.setCodPerfilEmpleado(nuevoPerfilEmpleado);
        empleado.setEstadoEmpleado(estado);
        
        daoEmpleado.actualizarEmpleado(empleado);
        
        request.getRequestDispatcher("pagEmpleado.jsp").forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codEmpleado = Integer.parseInt(request.getParameter("codEmpleado"));
        daoEmpleado.eliminarEmpleado(codEmpleado);

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
