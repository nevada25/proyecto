<%@page import="proy.modelo.entidad.Conductor"%>
<%@page import="proy.modelo.entidad.*"%>
<%@page import="proy.modelo.entidad.Pasajero"%>
<%@page import="proy.modelo.entidad.Usuario"%>
<%@page import="proy.modelo.dao.Impl.PersonaDaoImpl"%>
<%@page import="proy.modelo.entidad.Persona"%>
<%@page import="proy.modelo.dao.personaDao"%>
<%@include file="WEB-INF/jspf/top.jsp" %>
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<%
    personaDao dao = new PersonaDaoImpl();
    out.println(mensaje);
 %>
<style>

    div#total{
        background: #fff;
        padding:2%;
        margin:2%;
        width:500px;
        border-radius:1.5em;
    }
</style>
<center>
    <div id="total" align="center">
        <div >
            <div>
                <h1>REGISTRO PERSONA</h1>
                <div class="container" align="center"></div>

                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#persona"><center><img src="file/img/user1.png" class="img-responsive" /></center></button>
                <div class="modal fade" id="persona">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button class="close" aria-hidden="true" data-dismiss="modal"  >&times;</button>
                                <h1 class="modal-title" align="center"><b>REGISTRAR PERSONA</b></h1>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" method="POST"  action="registro">
                                    <div class="form-group">
                                        <label class="control-label col-xs-3">Nombres:</label>
                                        <div class="col-xs-8">
                                           
                                                <input type="text" class="form-control" placeholder="nombres" name="nombres">
                                                <input type="hidden" class="form-control" name="action" value="registrarpersona">
                                            
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-xs-3">Apellidos:</label>
                                        <div class="col-xs-8">
                                            <input type="text" class="form-control" placeholder="apellidos" name="apellidos">
                                            <input type="hidden" class="form-control" name="action" value="registrarpersona">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-xs-3">N&deg;dni:</label>
                                        <div class="col-xs-8">
                                            <input type="text" class="form-control" required="required" placeholder="dni" name="dni">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-xs-3">G&eacute;nero:</label>
                                        <div class="col-xs-3">
                                            <label class="radio-inline">
                                                <input type="radio" name="genero" value="M">Masculino
                                            </label>
                                        </div>
                                        <div class="col-xs-3">
                                            <label class="radio-inline">
                                                <input type="radio" name="genero" value="F">Femenino
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-xs-3" >F.Nacimiento:</label>
                                        <div class="col-xs-8">
                                            <input type="date" class="form-control" name="fecNacimiento">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-xs-3">Direccion:</label>
                                        <div class="col-xs-8">
                                            <textarea rows="3" class="form-control" placeholder="direccion" name="direccion"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-xs-3" >Telefono:</label>
                                        <div class="col-xs-8">
                                            <input type="text" class="form-control" placeholder="Telefono" name="telefono">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-xs-3" >Licencia: </label>
                                        <div class="col-xs-8">
                                            <input type="text" class="form-control" placeholder="numero licencia" name="licencia">
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <a  href="#tipo"><button class="btn btn-primary glyphicon glyphicon-floppy-saved" name="button" id="button" type="submit"  style="background:#000000;"></button></a>	
                                        <button class="btn btn-primary glyphicon glyphicon-floppy-remove" data-dismiss="modal" style="background: #9C9C9C;"></button>	
                                    </div>

                                </form>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
        <%-- FIN DE PRIMER MODAL--%>


        <%-- INICIO DE SEGUNDO MODAL--%>


        <div>
            <h1>REGISTRO VEHICULO</h1>
            <div class="container" align="center"></div>

            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#vehiculo"><center><img  src="file/img/car2.png" class="img-responsive" /></center></button>
            <div class="modal fade" id="vehiculo">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button class="close" aria-hidden="true" data-dismiss="modal"  >&times;</button>
                            <h1 class="modal-title" align="center"><b>REGISTRAR VEHICULO</b></h1>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" method="POST" action="registro">
                                <div class="form-group">
                                    <label class=" control-label col-xs-3">Modelo:</label>
                                    <div class="col-xs-8">
                                        <select class="form-control" name="modelo">
                                            <option>Seleccione Modelo</option>
                                            <%
                                                for (Modelo modelo : dao.listarModelo()) {
                                            %>
                                            <option value="<%=modelo.getIdModelo()%>"><%=modelo.getNombre()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-xs-3 ">Color:</label>
                                    <div class="col-xs-8">
                                        <select class="form-control" name="color">
                                            <option>Seleccione color</option>
                                            <%
                                                for (Color color : dao.listarColor()) {
                                            %>
                                            <option value="<%=color.getIdColor()%>"><%=color.getNombre()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-xs-3">Marca:</label>
                                    <div class="col-xs-8">
                                        <select class="form-control"  name="marca">
                                            <option>Seleccione Marca</option>
                                            <%
                                                for (Marca marca : dao.listarMarca()) {
                                            %>
                                            <option value="<%=marca.getIdMarca()%>"><%=marca.getNombre()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-xs-3" >N° Placa:</label>
                                    <div class="col-xs-8">
                                         <input type="hidden" class="form-control" name="action" value="registrarvehiculo">
                                        <input type="text" name="nplaca"  >
                                    </div> 
                                </div>

                                <div class="modal-footer">
                                    <button class="btn btn-primary glyphicon glyphicon-floppy-saved" name="button" id="button" type="submit"  style="background:#000000;"></button>	
                                    <button class="btn btn-primary glyphicon glyphicon-floppy-remove" data-dismiss="modal" style="background: #9C9C9C;"></button>	
                                </div>

                            </form>
                        </div>

                    </div>
                </div>

            </div>
            <%-- FIN DE SEGUNDO MODAL--%>
        </div>
        <%--INICIO TERCER MODAL---%>

    </div>
</div >
</div>
</center>

<%@include file="WEB-INF/jspf/bottom.jsp" %>