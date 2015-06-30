
<%@page import="java.util.List"%>
<%@page import="proy.modelo.dao.Impl.listasDaoImpl"%>
<%@page import="proy.modelo.dao.Impl.PersonaDaoImpl"%>
<%@page import="proy.modelo.dao.*,proy.modelo.entidad.*,proy.modelo.util.*" %>

<%@page import="proy.modelo.entidad.Persona"%>

<%@include file="WEB-INF/jspf/top.jsp" %>

<div class="container">
    
<% 
        
        String opcion = request.getParameter("opcion"); opcion = opcion == null?"":opcion;
        String alert = "";
        String mensaje = "";

        if (opcion.equals("delete")) {
    
        String idconductor = request.getParameter("idconductor"); idconductor = idconductor == null ? "" : idconductor;
    
        listasDao listaDao = new listasDaoImpl();
        
        if (listaDao.eliminarConductor(idconductor)) {
            alert = "info";
            mensaje = "Se eliminó correctamente.";
        } else {
            alert = "danger";
            mensaje = "No se puede eliminar. ";
        }
    }
%>
<div class="row">
    <div class="col-md-6" id="aler">
        <br>
        <%
            if(!mensaje.equals("")){
        %>
        <div class="alert alert-<%=alert%>"><%=mensaje%></div>
        <%}%>
    </div>
</div>
<div class="container-fluid">
    <h1 class="sub-header">Lista de conductores<label class="col-lg-offset-0"></label>&nbsp;&nbsp;<label class="col-lg-offset-6"></label><a href="pensionistasinactivos.jsp" class="btn btn-primary right">Pensionistas Inactivos</a></h1>
    <div class="table-responsive">
        <table id="tj" class="table table-striped well">
            <thead>
                <tr>
                    <th>#</th>
                    <th hidden>ID</th>
                    <th>Nombres y Apellidos</th>
                    <th>Dni</th> 
                    <th>N_Celular</th> 
                    <th>Direccion</th> 
                    <th>Genero</th>
                    <th>fecha nacimiento</th>  
                                                       
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    listasDao dao = new listasDaoImpl();
                    List<Conductor> lista = dao.ListarConductor();
                    for (Conductor conductor : lista) {
                        count++;
                        
                %>
                <tr>
                    <td><%=count%></td>
                    <td hidden><%=conductor.getIdConductor()%></td>
                    <td><%=conductor.getNombres()%>&nbsp;<%=conductor.getApellidos()%></td>
                    <td><%=conductor.getDni()%></td>
                    <td><%=conductor.getTelefono()%></td>
                    <td><%=conductor.getDireccion()%></td>
                    <td><%=conductor.getGenero().substring(0,10)%></td>
                    <td><%=conductor.getFec_nacimiento().substring(0,10)%></td>
                  
                    <td><p><a class="btn btn-primary" title="Modificar Contrato del Pencionista" href="modificarpen.jsp role="button><i class="glyphicon glyphicon-pencil"></i></a></p></td>
                    <td><p><a class="btn btn-danger" title="Eliminar" onclick="if(!confirm('Esta seguro de eliminar a <%=conductor.getNombres()%> <%=conductor.getApellidos()%> y todos sus registros'))return false" role="button" href="pensionistas.jsp?opcion=delete&idcontrato=<%=conductor.getIdConductor()%>"><i class="glyphicon glyphicon-trash"></i></a></p></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>    
</div>
</body>
<%@include file="WEB-INF/jspf/bottom.jsp" %>