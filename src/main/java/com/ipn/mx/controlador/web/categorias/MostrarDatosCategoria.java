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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author J.Perez
 */
@WebServlet(name = "MostrarDatosCategoria", urlPatterns = {"/MostrarDatosCategoria"})
public class MostrarDatosCategoria extends HttpServlet {

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
            out.println("<title>Lista de Categorias</title>");

            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js'></script>");

            out.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js'></script>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js'></script>");

            out.println("</head>");
            out.println("<body>");

            out.println("<center>");
            out.println("<div class='container'>");

            out.println("<br/>");
            out.println(" <div class=\"nav nav-pills nav-fill\">\n"
                    + "            <ul class=\"nav justify-content-end\">\n"
                    + "                <li class=\"nav-item\">\n"
                    + "                    <a class=\"nav-link \"  href=\"index.html\">Inicio</a>\n"
                    + "                </li>\n"
                    + "                <li class=\"nav-item\">\n"
                    + "                    <a class=\"nav-link \"  href=\"TablasDeMultiplicar\">Tablas de Multiplicar</a>\n"
                    + "                </li>\n"
                    + "                <li class=\"nav-item\">\n"
                    + "                    <a class=\"nav-link active\" aria-current=\"page\" href=\"MostrarDatosCategoria\">Listado de Categorias</a>\n"
                    + "                </li>\n"
                    + "                \n"
                    + "                <li class=\"nav-item\">\n"
                    + "                    <a class=\"nav-link\" href=\"categoriaForm.html\">Crear Categoria</a>\n"
                    + "                </li>\n"
                    + "                \n"
                    + "                <li class=\"nav-item\">\n"
                    + "                    <a class=\"nav-link\" href=\"ProductoController?accion=listaDeProductos\">Listado de Productos</a>\n"
                    + "                </li>\n"
                    + "                \n"
                    + "                <li class=\"nav-item\">\n"
                    + "                    <a class=\"nav-link\" href=\"ProductoController?accion=nuevo\">Crear Producto</a>\n"
                    + "                </li>\n"
                    + "                \n"
                    + "            </ul>\n"
                    + "        </div>");
            out.println("<br/>");
            out.println("<br/>");

            out.println("<h1>Lista de Categorias</h1>");

            out.println("<table class=\"table table-bordered border-primary\">");

            out.println("<tr>");
            out.println("<th>Clave</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Descripcion</th>");
            out.println("<th>Eliminar</th>");
            out.println("<th>Actualizar</th>");
            out.println("</tr>");

            CategoriaDAO dao = new CategoriaDAO();
            try {
                List lista = dao.readAll();
                for (int i = 0; i < lista.size(); i++) {

                    CategoriaDTO dto = (CategoriaDTO) lista.get(i);

                    out.println("<tr>");

                    out.println("<td>");
                    out.println("<a href='VerCategoria?id=" + dto.getEntidad().getIdCategoria() + "' class='btn btn-warning'> " + dto.getEntidad().getIdCategoria() + " </a>");
                    out.println("</td>");

                    out.println("<td>" + dto.getEntidad().getNombreCategoria() + "</td>");
                    out.println("<td>" + dto.getEntidad().getDescripcionCategoria() + "</td>");

                    out.println("<td>");
                    out.println("<a href='EliminarCategoria?id=" + dto.getEntidad().getIdCategoria() + "' class='btn btn-danger'> Eliminar </a>");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("<a href='ActualizarCategoria?id=" + dto.getEntidad().getIdCategoria() + "' class='btn btn-success'> Actualizar </a>");
                    out.println("</td>");

                    out.println("</tr>");
                }

            } catch (SQLException ex) {
                Logger.getLogger(VerCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("</table>");
            out.println("<a href='categoriaForm.html' class='btn btn-primary'> Agregar Categoria </a>");
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
