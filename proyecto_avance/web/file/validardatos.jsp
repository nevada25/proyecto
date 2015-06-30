
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pro.modelo.dao.*,pro.modelo.entidad.*,pro.modelo.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>validacion de la palabra</title>
    </head>
    <body>
    <%


   Usuario.admin p= new  Usuario.admin();


       p.setUsuario(request.getParameter("usuario"));
       p.setcontrasena(request.getParameter("contrasena"));


       String res=p.insertar3();


if(res.equals("-1")) {
      out.print("entraste clic aqui para entrar");
              %>
<a href="menu.jsp">entrar ya</a>
<%
      }



       else if (res.equals("1")){
         out.print("fallo la autentificacion ");}


       else{
           out.print("algo pasa ");
           }


                %>

        
    </body>
</html>
