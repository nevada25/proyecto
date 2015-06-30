
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>www.transporte.com</title>
        <link rel="stylesheet" href="css/estilos.css">
        <link rel="shortcut icon" type="image/x-icon" href="img/icono pestana2.ico" />
        <link rel="stylesheet" href="boostrap/css/bootstrap.css">
        
    </head>
    <body>
        <jsp:useBean id="idUsuario" scope="session" class="java.lang.String" />
        <jsp:useBean id="login" scope="request" class="java.lang.String" />
       <%
            {
                if(idUsuario.equals(""))

                response.sendRedirect("error.jsp");
            }
        %>
        <section id="general">

            <header>
                <div>
                    <div class="cabecera col-xs-12">
                        <img   class="logo_cabeza" src="file/img/icono pestaña.png"/>
                        SELVA AMAZONICA
                    </div>
                </div>
            </header>
            <!-- codigo de navegacion-->

            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only" >MENU</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand"  href="index.jsp">MENU PRINCIPAL</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="index.jsp">INICIO <span class="sr-only"></span></a></li>
                            <li><a   href="quienes_somos.jsp">QUIENES SOMOS</a></li>
                            

                            <%-- registros --%>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" >REGISTROS<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="opci_reegistrar.jsp">
                                            <span class="" aria-hidden="true"></span>
                                            Registrar Personas 
                                        </a></li>
                                    <li><a href=" viaje.jsp">Registrar Viajes</a></li>
                                     <li><a href=" listarConductorViaje.jsp">Venta de Pasajes</a></li>
                                     <li><a href=" nuevoUsuario.jsp">Registrar nuevo usuario</a></li>
                                </ul>
                            </li>
                              <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" >REPORTES<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="RepPasajero.jsp">Pasajeros y sus Viajes</a></li>
                                    <li><a href="repConductor.jsp">Conductores y sus Viajes</a></li>
                                      <li><a href="DatosConductores.jsp">Conductores y sus datos personales</a></li>
                                </ul>
                            </li>
                            <%----- VISTAS----%> 
                           
                            <li class="dropdown"><a  href="#" class="dropdown-toggle" data-toggle="dropdown">VISTAS<b class="caret"></b></a>
                                <ul  class="dropdown-menu">
                                    <li><a  href="vistapersonal.jsp" ><center><img src="file/img/1434165422_88.png" class="img-responsive"/></center></a></li>
                                    <li><a href="vistavehiculo.jsp"><center><img  src="file/img/1433495942_truck.png"  class="img-responsive"/> </center></a></li>
                                </ul> 

                            <li><a    href="cerrarsesion">SALIR</a></li>   
                            

                        </ul>



                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>













