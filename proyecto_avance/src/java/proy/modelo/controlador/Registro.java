/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proy.modelo.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proy.modelo.dao.Impl.PersonaDaoImpl;
import proy.modelo.dao.personaDao;
import proy.modelo.entidad.Conductor;
import proy.modelo.entidad.Persona;
import proy.modelo.entidad.Vehiculo;

/**
 *
 * @author Windows 8.1
 */
public class Registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    personaDao dao = new PersonaDaoImpl();
    Persona persona = new Persona();
     Conductor c = new Conductor(); 
     Vehiculo vehiculo = new Vehiculo();
     
    String action = request.getParameter("action"); action = action == null ? "" : action;
    String licencia = request.getParameter("licencia"); licencia = licencia == null ? "" : licencia;
    String nombres = request.getParameter("nombres");  nombres = nombres == null ? "" :nombres;
    String id_persona = request.getParameter("id_persona");  id_persona = id_persona == null ? "" :id_persona;
    String apellidos = request.getParameter("apellidos");apellidos = apellidos == null ? "" :apellidos;
    String dni = request.getParameter("dni"); dni = dni == null ? "" : dni;
    String genero = request.getParameter("genero");genero = genero == null ? "" :genero;
    String fec_nacimiento = request.getParameter("fecNacimiento");fec_nacimiento = fec_nacimiento == null ? "" :fec_nacimiento;
    String direccion = request.getParameter("direccion"); direccion = direccion == null ? "" :direccion;
    String telefono = request.getParameter("telefono"); telefono = telefono == null ? "" : telefono; 
     String idModelo = request.getParameter("modelo");idModelo = idModelo == null ? "" : idModelo;
    String idColor = request.getParameter("color");idColor = idColor == null ? "" : idColor;
    String idMarca = request.getParameter("marca"); idMarca = idMarca == null ? "" : idMarca;
    String nroPlaca = request.getParameter("nplaca"); nroPlaca = nroPlaca == null ? "" : nroPlaca;
    String mensaje = "";
   
    
   switch(action){
       case "registrarpersona":
        persona.setNombres(nombres);
        persona.setApellidos(apellidos);
        persona.setDni(dni);
        persona.setGenero(genero);
        persona.setFec_nacimiento(fec_nacimiento);
        persona.setDireccion(direccion);
        persona.setTelefono(telefono);
        if (dao.agregarpersona(persona)) {
            persona=dao.Obtenerid(dni);
            id_persona=persona.getIdPersona();
              c.setIdConductor(id_persona);
              c.setNroLicencia(licencia);
               if(dao.insertarConductor(c)){
                 request.setAttribute("mensaje", "Se registro correctamente");
                }else{
                 request.setAttribute("mensaje", "No se registró");
               }
        } 
        request.getRequestDispatcher("opci_reegistrar.jsp").forward(request, response);
           break;
           case "registrarvehiculo":
        vehiculo.setIdModelo(idModelo);
        vehiculo.setIdColor(idColor);
        vehiculo.setIdMarca(idMarca);
        vehiculo.setNroPlaca(nroPlaca);

        if (dao.insertarVehiculo(vehiculo)) {
         request.setAttribute("mensaje", "Se registro correctamente");
        } else {
             request.setAttribute("mensaje", "No se registró");
        }
    
        request.getRequestDispatcher("opci_reegistrar.jsp").forward(request, response);
           break;
        
           default:
               break;
   }
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Registro</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Registro at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
