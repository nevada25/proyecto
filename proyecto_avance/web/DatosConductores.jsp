<%-- 
    Document   : DatosConcuctores
    Created on : 29/06/2015, 04:52:45 PM
    Author     : Windows 8.1
--%>

<%@page import="proy.modelo.entidad.Conductor"%>
<%@page import="proy.modelo.dao.Impl.ConductorDaoImpl"%>
<%@page import="proy.modelo.dao.conductorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/top.jsp" %>
<%
conductorDao dao = new ConductorDaoImpl();

String idc = request.getParameter("idc"); idc = idc == null ? "" : idc;
String opcion = request.getParameter("opcion"); opcion = opcion == null ? "" : opcion;
String mensaje = "";

if(opcion.equals("delete")){
    if(dao.EliminarConductor(idc)){
     mensaje = "se elimino";
    }else{mensaje = "no se pudo eliminar";}

}
%>
        <h1 class="sub-header">Lista de conductores en la empresa</h1>
        <div class="table-responsive">
        <table class="table table-striped well">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nombres</th>
                    <th>DNI</th>
                    <th>F Nacimiento</th>
                    <th>Dirección</th>
                    <th>Celular</th>
                      <th>N° Licencia</th>
                </tr>
            </thead>
            <tbody>
                <%
                   
                    int count = 0;
                    for (Conductor listar : dao.ListaDatosConductor()) {
                        count++;;;;
                %>
                <tr>
                    <td><%=count%></td>
                    <td><%=listar.getNombres()%>&nbsp;<%=listar.getApellidos()%></td>
                    <td><%=listar.getDni()%></td>
                    <td><%=listar.getFec_nacimiento()%></td>
                    <td><%=listar.getDireccion()%></td>
                    <td><%=listar.getTelefono()%></td>
                    <td><%=listar.getNroLicencia()%></td>
                    
                     
                   <td><center><a href="DatosConductores.jsp"><span class="glyphicon glyphicon-edit" aria-hidden="true" title="Modificar"></span></a></center></td>
                    <td><center><a href=""><span class="glyphicon glyphicon-trash" aria-hidden="true" title="Eliminar" onclick="if(!confirm('Esta seguro de eliminar a <%=listar.getNombres()%> y todos sus registros'))return false" role="button" href="DatosConductores.jsp?opcion=delete&idc=<%=listar.getIdConductor()%>"></span></a></center></td>
                </tr>
                <%}%>
                <%
                mensaje = "mensaje";
                %>
            </tbody>
        </table>
        </div>
    <%@include file="WEB-INF/jspf/bottom.jsp" %>
