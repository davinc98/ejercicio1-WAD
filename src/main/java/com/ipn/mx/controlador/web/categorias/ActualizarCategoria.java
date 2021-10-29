/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador.web.categorias;

import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leoj_
 */
@WebServlet(name = "ActualizarCategoria", urlPatterns = {"/ActualizarCategoria"})
public class ActualizarCategoria extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Actualizar Categoria Form</title>");
            
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js'></script>");

            out.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js'></script>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js'></script>");

            out.println("</head>");
            out.println("<body>");

            out.println("<center>");
            out.println("<div class='container'");
            
            out.println("<br/>");
            out.println("<div class=\"nav nav-pills nav-fill\">\n" +
"                    <ul class=\"nav justify-content-end\">\n" +
"                        <li class=\"nav-item\">\n" +
"                            <a class=\"nav-link\"  href=\"index.html\">Inicio</a>\n" +
"                        </li>\n" +
"                        <li class=\"nav-item\">\n" +
"                            <a class=\"nav-link\" href=\"TablasDeMultiplicar\">Tablas de Multiplicar</a>\n" +
"                        </li>\n" +
"                        <li class=\"nav-item\">\n" +
"                            <a class=\"nav-link\" href=\"MostrarDatosCategoria\">Listado de Categorias</a>\n" +
"                        </li>\n" +
"\n" +
"                        <li class=\"nav-item\">\n" +
"                            <a class=\"nav-link\" href=\"categoriaForm.html\">Crear Categoria</a>\n" +
"                        </li>\n" +
"\n" +
"                        <li class=\"nav-item\">\n" +
"                            <a class=\"nav-link\" href=\"ProductoController?accion=listaDeProductos\">Listado de Productos</a>\n" +
"                        </li>\n" +
"\n" +
"                        <li class=\"nav-item\">\n" +
"                            <a class=\"nav-link\" href=\"ProductoController?accion=nuevo\">Crear Producto</a>\n" +
"                        </li>\n" +
"\n" +
"                    </ul>\n" +
"                </div>");
            out.println("<br/>");
            out.println("<br/>");
            
            out.println("<h1>Actualizar Categoria</h1>");
            
            CategoriaDAO dao = new CategoriaDAO();
            CategoriaDTO dto = new CategoriaDTO();
            
            dto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("id")));

            try {
                dto = dao.read(dto);
            } catch (SQLException ex) {
                Logger.getLogger(ActualizarCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (dto != null) {          

                out.println("<div class=\"card\" style=\"width: 30rem;\">\n" +
"                    <div class=\"card-header\">\n" +
"                        Datos categoria\n" +
"                    </div>\n" +
"                    <div class=\"card-body\">"
                        + "<form name=\"frmDatos\" method=\"post\" action=\"ActualizaCategoria\"> \n"
                        + "                Clave: \n"
                        + "                <input type=\"text\" name=\"txtClave\" value='"+dto.getEntidad().getIdCategoria()+"' readonly/><br/>\n"
                        + "                Nombre Categoria: \n"
                        + "                <input type=\"text\" name=\"txtNombre\" placeholder=\"Pon tu nombre aqui\" value='"+dto.getEntidad().getNombreCategoria()+"' required/><br/>\n"
                        + "                Descripción de la categoria: \n"
                        + "                <input type=\"text\" name=\"txtDescripcion\" placeholder=\"Agrega una descripción\" value='"+dto.getEntidad().getDescripcionCategoria()+"' required/><br/>\n"
                        + "                <input type=\"submit\" value=\"Enviar\" name=\"btnEnviar\"/>\n"
                        + "            </form>\n"
                                + ""
                                + "</div>\n" +
"                </div>");
                
                
                
            } else {
                out.println("Sin conincidencias.");
            }

            out.println("</div>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
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
