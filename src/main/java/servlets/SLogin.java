
package servlets;

import dao.DaoLogin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ValoresGlobales;

public class SLogin extends HttpServlet {

    DaoLogin daoLogin = new DaoLogin();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int op = Integer.parseInt(request.getParameter("op"));

        switch (op) {
            case 1:
                loguearse(request, response);
                break;

        }
            
            
    }
    
    
    protected void loguearse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int usuario = Integer.parseInt(request.getParameter("user"));
        String contra = request.getParameter("contra");

        if (daoLogin.existeCodigoUsuario(usuario)) {
            if (contra.equals(daoLogin.ContraUsuario(usuario))) {
                ValoresGlobales.codEmpleado = usuario;
                request.getRequestDispatcher("pagEmpleado.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("pagLogin.jsp?error=2").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("pagLogin.jsp?error=1").forward(request, response);
        }
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
