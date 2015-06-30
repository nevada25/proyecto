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
import proy.modelo.dao.Impl.ViajeDaoImpl;
import proy.modelo.dao.ViajeDao;
import proy.modelo.entidad.Viaje;

/**
 *
 * @author Windows 8.1
 */
public class registroviaje extends HttpServlet {

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
    
    ViajeDao vd = new ViajeDaoImpl();
    Viaje viajes = new Viaje();

    String idConductor = request.getParameter("conductor");
    idConductor = idConductor == null ? "" : idConductor;
    String idVehiculo = request.getParameter("vehiculo");
    idVehiculo = idVehiculo == null ? "" : idVehiculo;
    String enviar = request.getParameter("enviar");
    enviar = enviar == null ? "" : enviar;
    String IdCiudadSalida = request.getParameter("ciudadSalida");
    IdCiudadSalida = IdCiudadSalida == null ? "" : IdCiudadSalida;
    String IdCiudadDestino = request.getParameter("ciudaDestino");
    IdCiudadDestino = IdCiudadDestino == null ? "" : IdCiudadDestino;
    String horaViaje = request.getParameter("hora");
    horaViaje = horaViaje == null ? "" : horaViaje;
    String fechaViaje = request.getParameter("fechaviaje");
    fechaViaje = fechaViaje == null ? "" : fechaViaje;

   
    if(enviar.equals("Guardar")){
    viajes.setIdConductor(idConductor);
    viajes.setIdVehiculo(idVehiculo);
    viajes.setIdCiudadSalida(IdCiudadSalida);
    viajes.setIdCiudadDestino(IdCiudadDestino);
    viajes.setHoraViaje(horaViaje);
    viajes.setFechaViaje(fechaViaje);
    if (vd.RegistrarViaje(viajes)) {
      request.setAttribute("mensaje","Se registro");
    } else {
          request.setAttribute("mensaje","No se registro");
    }
     request.getRequestDispatcher("viaje.jsp").forward(request, response);
    }
    if(enviar.equals("Enviar"))
    {
         
      request.getRequestDispatcher("listarConductorViaje.jsp").forward(request, response);
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
