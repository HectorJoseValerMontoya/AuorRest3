/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.DaoMesa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HJVM
 */
public class SMesa extends HttpServlet {

    DaoMesa daoMesa = new DaoMesa();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("op"));

        switch (op) {
            case 1:
                ocuparMesa(request, response);
                break;
            case 2:
                cambiarEstadoMesa(request, response);
                break;
        }
    }

    protected void ocuparMesa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codMesa = Integer.parseInt(request.getParameter("codMesa"));
        int siguienteCodOrden = Integer.parseInt(request.getParameter("codOrden"));
        daoMesa.setOcuparMesa(codMesa);

        request.getRequestDispatcher("pagOrdenarPedido.jsp?codMesa=" + codMesa +"&codOrden=" + siguienteCodOrden).forward(request, response);
    }

    protected void cambiarEstadoMesa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codMesa = Integer.parseInt(request.getParameter("codMesa"));
        daoMesa.setCambiarEstadoMesa(codMesa);

        request.getRequestDispatcher("pagAdministrarMesa.jsp").forward(request, response);
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
