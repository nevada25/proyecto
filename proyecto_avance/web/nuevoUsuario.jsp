<%-- 
    Document   : nuevoUsuario
    Created on : 29/06/2015, 06:03:58 PM
    Author     : Windows 8.1
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/top.jsp" %>
<jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
<%    
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
<div>
    <div>
        <h1>REGISTRAR USUARIO</h1>
        <div class="container" align="center"></div>

        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#persona"><center><img src="file/img/user1.png" class="img-responsive" /></center></button>
        <div class="modal fade" id="persona">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button class="close" aria-hidden="true" data-dismiss="modal"  >&times;</button>
                        <h1 class="modal-title" align="center"><b>REGISTRAR Usuario</b></h1>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" method="POST"  action="regusuario">
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
                            <center>
                                <div class="form-group">
                                    <label class="control-label col-xs-3" >Login:</label>
                                    <div class="col-xs-8">
                                        <input type="text" class="form-control" placeholder="Login" name="login">
                                    </div>
                                </div>
                            </center>
                            <center>
                                <div class="form-group">
                                    <label class="control-label col-xs-3" >Contraseña:</label>
                                    <div class="col-xs-8">
                                        <input type="text" class="form-control" placeholder="contrasena" name="password">
                                    </div>
                                </div>
                            </center>
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
<%@include file="WEB-INF/jspf/bottom.jsp" %>