
<%@page import="proy.modelo.entidad.Conductor"%>
<%@page import="proy.modelo.entidad.Persona"%>
<%@page import="proy.modelo.dao.Impl.ViajeDaoImpl"%>
<%@page import="proy.modelo.dao.ViajeDao"%>
<%@page import="proy.modelo.entidad.Ciudad"%>
<%@page import="proy.modelo.entidad.Vehiculo"%>
<%@page import="proy.modelo.entidad.Viaje"%>
<%@page import="proy.modelo.dao.Impl.PersonaDaoImpl"%>
<%@page import="proy.modelo.dao.personaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/top.jsp" %>
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<%

    ViajeDao vd = new ViajeDaoImpl();
    out.println(mensaje);

%>



<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
        <div class="col-xs-12 col-sm-6 col-md-5 well well-sm">
            <form method="POST" action="viaje" >
                <table class="table table-condensed">
                    <tbody>
                        <tr>
                            <td><label class="col-sm-12">Conductor</label></td>
                            <td><select class="form-control" name="conductor">
                                    <option>Seleccione Conductor</option>
                                    <%                                for (Persona conductor : vd.listarConductor()) {

                                    %>
                                    <option value="<%=conductor.getIdPersona()%>"><%=conductor.getNombres()%><%=conductor.getApellidos()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Ciudad Salida:</label></td>
                            <td>
                                <select class="form-control" name="ciudadSalida">
                                    <option>Seleccionar ciudad de Salida</option>
                                    <%
                                        for (Ciudad ciudad : vd.listarCiudad()) {
                                    %>
                                    <option value="<%=ciudad.getIdCiudad()%>"><%=ciudad.getNombre()%></option>
                                    <%}%>
                                </select></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Ciudad Destino</label></td>
                            <td><select class="form-control" name="ciudaDestino">
                                    <option>Seleccionar ciudad de Destino</option>
                                    <%
                                        for (Ciudad ciudad : vd.listarCiudad()) {
                                    %>
                                    <option value="<%=ciudad.getIdCiudad()%>"><%=ciudad.getNombre()%></option>
                                    <%}%>
                                </select></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">N° Placa</label></td>
                            <td> <select class="form-control" name="vehiculo">
                                    <option>Seleccionar Vehiculo</option>
                                    <%
                                        for (Vehiculo vehiculo : vd.listarVehiPlaca()) {
                                    %>
                                    <option value="<%=vehiculo.getIdVehiculo()%>"><%=vehiculo.getNroPlaca()%></option>
                                    <%}%>
                                </select></td>
                        </tr>
                        <tr>
                            <td><label class="col-sm-12">Fecha</label></td>
                            <td><input type="date" class="form-control" name="fechaviaje"></td>
                        </tr>
                          <tr>
                            <td><label class="col-sm-12">Hora de salida:</label></td>
                            <td><input type="text" class="form-control" name="hora"></td>
                        </tr>
                          
                         <tr><td>
                                 <input type="submit" class="btn btn-primary" name="enviar" value="Guardar" > 
                            </td>
                            <td>
                                <input type="submit" class="btn btn-primary" name="enviar" value="Enviar" > 
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="col-xs-12 col-sm-3 col-md-3"></div>
    </div>
</div>
<%@include file="WEB-INF/jspf/bottom.jsp" %>