<%@page import="proy.modelo.entidad.Listar_Pasajeros"%>
<%@page import="proy.modelo.dao.Impl.PasajeroDaoImpl"%>
<%@page import="proy.modelo.dao.PasajeroDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/top.jsp" %>
        <h1 class="sub-header">Lista de Pasajeros</h1>
        <div class="table-responsive">
        <table class="table table-striped well">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nombres</th>
                    <th>Fecha</th>
                    <th>Hora de Salida</th>
                    <th>Cuidad de Salida</th>
                    <th>Destino</th>
                </tr>
            </thead>
            <tbody>
                <%
                    PasajeroDao dao = new PasajeroDaoImpl();
                    int count = 0;
                    for (Listar_Pasajeros listar : dao.ListarPasajero()) {
                        count++;;;;
                %>
                <tr>
                    <td><%=count%></td>
                    <td><%=listar.getNombres()%>&nbsp;<%=listar.getApellidos()%></td>
                    <td><%=listar.getFechaViaje()%></td>
                    <td><%=listar.getHoraSalida()%></td>
                    <td><%=listar.getCiudadSalida()%></td>
                    <td><%=listar.getCiudadDestino()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        </div>
    <%@include file="WEB-INF/jspf/bottom.jsp" %>
