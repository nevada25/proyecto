<%-- 

    Document   : repConductor
    Created on : 29/06/2015, 03:39:15 PM
    Author     : Windows 8.1
--%>

<%@page import="proy.modelo.entidad.Conductor"%>
<%@page import="proy.modelo.dao.Impl.ConductorDaoImpl"%>
<%@page import="proy.modelo.dao.conductorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/top.jsp" %>
<h1 class="sub-header">Lista de Conductores y sus viajes</h1>
<div class="table-responsive">
    <table class="table table-striped well">
        <thead>
            <tr>
                <th>#</th>
                <th>Nombres</th>
                <th>Fecha</th>
                <th>Hora de Salida</th>
                <th>N° Licencia</th>
                <th>N° Placa</th>
                <th>Cuidad de Salida</th>
                <th>Ciudad de Destino</th>
            </tr>
        </thead>
        <tbody>
            <%                   
                conductorDao dao = new ConductorDaoImpl();
                int count = 0;
                for (Conductor listar : dao.ListarConductor()) {
                    count++;
                    
                    
            %>
            <tr>
                <td><%=count%></td>
                <td><%=listar.getNombres()%>&nbsp;<%=listar.getApellidos()%></td>
                <td><%=listar.getFecha_viaje()%></td>
                <td><%=listar.getHora_viaje()%></td>
                <td><%=listar.getNroLicencia()%></td>
                <td><%=listar.getNro_placa()%></td>
                <td><%=listar.getCiudadSalida()%></td>
                <td><%=listar.getCiudadDestino()%></td>
            </tr>
            <%}%>
        </tbody>
    </table>
</div>
<%@include file="WEB-INF/jspf/bottom.jsp" %>
