<%-- 
    Document   : productoForm
    Created on : 29 oct. 2021, 13:06:58
    Author     : leoj_
--%>

<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crear Producto</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js"></script>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <div class="container">
            <center>

                <br/>
                <div class="nav nav-pills nav-fill">
                    <ul class="nav justify-content-end">
                        <li class="nav-item">
                            <a class="nav-link"  href="index.html">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="TablasDeMultiplicar">Tablas de Multiplicar</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="MostrarDatosCategoria">Listado de Categorias</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link "  href="categoriaForm.html">Crear Categoria</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="ProductoController?accion=listaDeProductos">Listado de Productos</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="ProductoController?accion=nuevo">Crear Producto</a>
                        </li>

                    </ul>
                </div>

                <br/>
                <br/>


                <h1>Crear Producto</h1>

                <form name="frmDatos" method="post" action="ProductoController?accion=guardar"> 

                    <div class="col-sm-6">
                        <div class="card">
                            <h5 class="card-header">Datos Producto</h5>
                            <div class="card-body">



                                <div class="mb-3">
                                    <label for="txtNombreProducto" class="form-label">Nombre Producto: </label>
                                    <input type="text" name="txtNombreProducto"  id="txtNombreProducto" placeholder="Nombre del producto" required/>
                                </div>

                                <div class="mb-3">
                                    <label for="txtDescripcion" class="form-label">Descripcion: </label>
                                    <input type="text" name="txtDescripcion"  id="txtDescripcion" placeholder="Descrpcion del producto" required/>
                                </div>

                                <div class="mb-3">
                                    <label for="txtPrecio" class="form-label">Precio: </label>
                                    <input type="number" name="txtPrecio"  id="txtPrecio" placeholder="Precio del producto" required/>
                                </div>

                                <div class="mb-3">
                                    <label for="txtExistencia" class="form-label">Existencia: </label>
                                    <input type="number" name="txtExistencia" id="txtExistencia" step="1" min="1" max="100"
                                           placeholder="Cantidad disponible del producto" required/>
                                </div>

                                <div class="mb-3">
                                    <label for="txtStockMinimo" class="form-label">Stock Minimo: </label>
                                    <input type="number" id="txtStockMinimo" name="txtStockMinimo" step="1" min="10" max="100"
                                           placeholder="Cantidad minima en stock del producto" required/>
                                </div>

                                <div class="mb-3">
                                    <label for="txtClaveCategoria" class="form-label">Clave Categoria: </label>
                                    <select name="txtClaveCategoria" id="txtClaveCategoria" placeholder="Clave de la categoria" required>
                                        <%
                                            CategoriaDAO dao = new CategoriaDAO();
                                            List lista = dao.readAll();

                                            for (int i = 0; i < lista.size(); i++) {
                                                CategoriaDTO cat = (CategoriaDTO) lista.get(i);


                                        %>
                                        <option value="<%= cat.getEntidad().getIdCategoria()%>"><%= cat.getEntidad().getNombreCategoria()%></option>
                                        <!--                                <input name="txtClaveCategoria" type="number" id="txtClaveCategoria"
                                                                               placeholder="Clave de la categoria" required/>-->

                                        <%}%>
                                    </select>
                                </div>

                                <button type="submit" class="btn btn-primary">Enviar</button>
                            </div>
                        </div> 
                    </div>
                </form>
            </center>
        </div>
    </body>
</html>
