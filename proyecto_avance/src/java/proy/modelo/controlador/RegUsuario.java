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
import proy.modelo.entidad.Persona;
import proy.modelo.entidad.Usuario;

/**
 *
 * @author Windows 8.1
 */
public class RegUsuario extends HttpServlet {

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
         Usuario u = new Usuario();
        
    String action = request.getParameter("action"); action = action == null ? "" : action;
    String id_usuario = request.getParameter("id_usuario"); id_usuario = id_usuario == null ? "" : id_usuario;
    String login = request.getParameter("login"); login =  login == null ? "" : login;
    String password = request.getParameter("password"); password = password == null ? "" : password;
    String nombres = request.getParameter("nombres");  nombres = nombres == null ? "" :nombres;
    String id_persona = request.getParameter("id_persona");  id_persona = id_persona == null ? "" :id_persona;
    String apellidos = request.getParameter("apellidos");apellidos = apellidos == null ? "" :apellidos;
    String dni = request.getParameter("dni"); dni = dni == null ? "" : dni;
    String genero = request.getParameter("genero");genero = genero == null ? "" :genero;
    String fec_nacimiento = request.getParameter("fecNacimiento");fec_nacimiento = fec_nacimiento == null ? "" :fec_nacimiento;
    String direccion = request.getParameter("direccion"); direccion = direccion == null ? "" :direccion;
    String telefono = request.getParameter("telefono"); telefono = telefono == null ? "" : telefono; 
    
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
              u.setIdUsuario(id_persona);
              u.setLogin(login);
              u.setPassword(password);
               if(dao.insertarUsuario(u)){
                 request.setAttribute("mensaje", "Se registro correctamente");
                }else{
                 request.setAttribute("mensaje", "No se registró");
               }    
        } 
      request.getRequestDispatcher("opci_reegistrar.jsp").forward(request, response);
           break;
        
           default:
               break;
   }
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
