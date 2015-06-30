<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="proy.modelo.dao.personaDao" %>
<%@page  import="proy.modelo.dao.Impl.PersonaDaoImpl"%>
<%@page  import="proy.modelo.entidad.Usuario" %>
<!DOCTYPE html>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
        <link type="text/css" rel="stylesheet" href="file/css/estilos2.css"/>
        <link rel="shortcut icon" type="image/x-icon"  href="file/img/icono pestaña2.ico"/>
        <link rel="stylesheet" href="boostrap/css/bootstrap.css">
        <title>INGRESAR</title>
    </head>
    <body>
    <center>
        <header>   
            <div class="container">
                <div class="fondo">
                    <div class="row">          
                    <div class="col-md-3">
                        <div class="logo">
                            <a  href="login.jsp"><img  src="file/img/icono pestaña.png"  class="img-responsive" alt="Imagen responsive"></a>                        
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="text1">
                            <b><h2>EMPRESA DE TRANSPORTE</h2> </b>
                        </div>
                        <div class="text2">
                            <b><h1>SELVA AMAZONICA.SAC</h1></b>
                        </div>
                    </div>
                    <div class="col-md-3" align="center">
                        <div class="text3" align="center" >
                            <h3>Encuentranos en:</h3>   
                            <a href="" ><img  src="file/img/fb-logo - copia.png" class="img-responsive" alt="imagen responsive"/>  </a>
                              </div>                      
                    </div>
                </div>
                    <br>
                </div>
            </div>
        </header>
        <div class="container">
        <div class="container well" id="sha">
            <div class="row">
                <div class="col-md-12">
                     <h2 class=" form-signin-heading"><center><strong>Ingresa Aqu&iacute;</strong></center></h2>
                     <br>
                </div>
            </div>
            <div class="row col-md-12">
              <div class="col-md-12">
                  <form class="for" action="inicio" method="post" style="text-align:center;">
                            <div class="user">
                                <input type="Usuario" class="form-control" style=" text-align: center;" placeholder="Usuario" name="usuario" required autofocus>

                            </div>
                      <br>
                            <div class="contra" style="text-align:center;">
                                <input type="password" class="form-control" placeholder="Contrase&ntilde;a" name="password" required>
                            </div>
                            <button class="envia " type="submit" value="Iniciar seci&oacute;n">
                                <strong><a href="index.jsp">Iniciar seci&oacute;n</a></strong>
                            </button>
                        </form>
                </div>
            </div>  
            </div>
                  </center>
                            </div>
                               
                            </div>
                        </div>
                    </div>    
                </div>

            </div>
        </article>



    <script src="jquery/jquery-1.11.2.min.js"></script>
    <script src="boostrap/js/bootstrap.js"></script>
    
    </center>
</body>
</html>
