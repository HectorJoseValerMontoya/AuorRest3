/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.DaoDetalleOrden;
import dao.DaoMesa;
import dao.DaoOrden;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.DetalleOrden;
import modelo.Orden;
import modelo.ValoresGlobales;

/**
 *
 * @author HJVM
 */
public class SDetalleOrden extends HttpServlet {

    DaoDetalleOrden daoDO = new DaoDetalleOrden();
    DaoOrden daoO = new DaoOrden();
    DaoMesa daoM = new DaoMesa();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("op"));

        switch (op) {
            case 1:
                agregarADetalleOrden(request, response);
                break;
            case 2:
                cobrarDetalleOrden(request, response);
                break;
            case 3:
                anadirPedido(request, response);
                break;
        }
    }

    protected void agregarADetalleOrden(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codMesa = Integer.parseInt(request.getParameter("codMesa"));
        int codPlato = Integer.parseInt(request.getParameter("codPlato"));
        int cantidadDePlato = Integer.parseInt(request.getParameter("cantidadDePlato"));
        int codOrden = Integer.parseInt(request.getParameter("codOrden"));

        Orden orden = new Orden();
        orden.setCodMesa(codMesa);
        orden.setCodPlato(codPlato);
        orden.setCantidad(cantidadDePlato);
        orden.setCodEmpleado(ValoresGlobales.codEmpleado);
        orden.setCodOrden(codOrden);

        if (cantidadDePlato > 0) {
            if (!daoO.existeOrden(orden.getCodOrden())) {
                daoO.setCrearOrden(orden);
            }
            if (daoDO.existePlatoAgregadoEnDetalleOrden(orden)) {
                daoDO.actualizarPlatoAgregadoEnDetalleOrden(orden);
            } else {
                daoDO.agregarPlatoEnDetalleOrden(orden);
            }
        }
        request.getRequestDispatcher("pagOrdenarPedido.jsp?codMesa=" + codMesa).forward(request, response);

    }

    protected void cobrarDetalleOrden(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Al pagar, cambiar de estado de mesa, y de orden (NO!! de ordenDETALLE)
        double montoTotal = Double.parseDouble(request.getParameter("montoTotal"));
        double montoDeCobro = Double.parseDouble(request.getParameter("montoDeCobro"));
        int codMesa = Integer.parseInt(request.getParameter("codMesa"));

        if (montoDeCobro < montoTotal) {
            String error = "El monto es inferior al monto total.";
            request.getRequestDispatcher("pagDetalleCobrar.jsp?error=" + error + "&codMesa=" + codMesa).forward(request, response);
        } else {
            daoDO.Cobrar(codMesa);
            request.getRequestDispatcher("pagCobrarMesa.jsp").forward(request, response);
        }
    }
    
      protected void anadirPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          int codMesa = Integer.parseInt(request.getParameter("codMesa"));
          int codOrden = daoM.getCodigoOrdenPorMesaOcupada(codMesa);
          
          request.getRequestDispatcher("pagOrdenarPedido.jsp?codMesa="+codMesa+"&codOrden="+codOrden).forward(request, response);
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
