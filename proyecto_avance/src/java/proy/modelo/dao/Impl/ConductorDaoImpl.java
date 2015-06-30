/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proy.modelo.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import proy.modelo.conexion.ConectarOracle;
import proy.modelo.dao.conductorDao;
import proy.modelo.entidad.Conductor;
import proy.modelo.entidad.Listar_Pasajeros;

/**
 *
 * @author Windows 8.1
 */
public class ConductorDaoImpl implements conductorDao{
 public Connection open() {
        return ConectarOracle.conectar();
    }
    @Override
    public List<Conductor> ListarConductor() {
         List<Conductor> lista = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        Conductor con = null;
     String query = " select p.NOMBRES as nombres, p.APELLIDOS as apellidos, v.FECHA_VIAJE as fecha, v.HORA_VIAJE as hora, c.NRO_LICENCIA as licencia, vh.NRO_PLACA as placa, cs.NOMBRE as Salida, cd.NOMBRE as Destino " +
                        " from persona p, conductor c, viaje v,vehiculo vh, ciudad cs, ciudad cd " +
                        " where p.ID_PERSONA=c.ID_CONDUCTOR  and c.ID_CONDUCTOR=v.ID_CONDUCTOR and v.ID_VEHICULO=vh.ID_VEHICULO  and v.ID_CIUDAD_SALIDA=cs.ID_CIUDAD and v.ID_CIUDAD_DESTINO=cd.ID_CIUDAD ";
        try {
            st = open().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                con = new Conductor();
                con.setNombres(rs.getString("nombres"));
                con.setApellidos(rs.getString("apellidos"));
                con.setFecha_viaje(rs.getString("fecha"));
                con.setHora_viaje(rs.getString("hora"));
                con.setNroLicencia(rs.getString("licencia"));
                con.setNro_placa(rs.getString("placa"));
                con.setCiudadSalida(rs.getString("Salida"));
                con.setCiudadDestino(rs.getString("Destino"));
                lista.add(con);
            }
            open().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                open().close();
            } catch (Exception ex) {
            }
        }

        return lista;
    }

    @Override
    public List<Conductor> ListaDatosConductor() {
              List<Conductor> lista = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        Conductor con = null;
     String query = " select p.NOMBRES as nombres, p.APELLIDOS as apellidos, p.DNI as dni, p.FEC_NACIMIENTO as F_nacimiento, p.DIRECCION as direccion, p.TELEFONO as cell, c.NRO_LICENCIA as licencia " +
                    " from persona p, conductor c " +
                    " where p.ID_PERSONA=c.ID_CONDUCTOR ";
        try {
            st = open().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                con = new Conductor();
                con.setNombres(rs.getString("nombres"));
                con.setApellidos(rs.getString("apellidos"));
               con.setDni(rs.getString("dni"));
               con.setFec_nacimiento(rs.getString("F_nacimiento"));
               con.setDireccion(rs.getString("direccion"));
               con.setTelefono(rs.getString("cell"));
                con.setNroLicencia(rs.getString("licencia"));
                
                lista.add(con);
            }
            open().close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                open().close();
            } catch (Exception ex) {
            }
        }

        return lista;
    }

    @Override
    public boolean EliminarConductor(String idc) {
        boolean flat = false;
        Statement st = null;
        String query = " delete from conductor where id_conductor = '"+idc+"' ";
        
        try {
            st = open().createStatement();
            st.executeUpdate(query);
            open().commit(); 
            open().close();
            flat = true;
        } catch (Exception e) {
            e.printStackTrace();
            flat = false;
            System.out.println(e.getMessage());
            try {
                open().rollback();
                open().close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return flat;
    }
    
    
}
