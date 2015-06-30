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
import proy.modelo.dao.listasDao;
import proy.modelo.entidad.Conductor;

/**
 *
 * @author Windows 8.1
 */
public class listasDaoImpl implements listasDao{
 public Connection open() {
        return ConectarOracle.conectar();
    }

    @Override
    public List<Conductor> ListarConductor() {
        List<Conductor> lista = new ArrayList<Conductor>();
        Statement st = null;
        ResultSet rs = null;
        Conductor cp = null;
        String query = "select c.id_conductor as idc, p.nombres as name, p.apellidos as ape, p.dni as dn, "
                + " p.TELEFONO as celu, p.direccion as dire, p.genero as sexo, p.FEC_NACIMIENTO as fn, "
                + " from persona p, conductor c"
                + " where p.id_persona=c.id_conductor and " ;

        try {
            st = open().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                cp = new Conductor();
                cp.setIdConductor(rs.getString("idc")); 
                cp.setNombres(rs.getString("name"));
                cp.setApellidos(rs.getString("ape"));
                cp.setDni(rs.getString("dn"));
                cp.setTelefono(rs.getString("celu"));
                cp.setDireccion(rs.getString("dire"));
                cp.setGenero(rs.getString("sexo"));
                cp.setFec_nacimiento(rs.getString("fn"));
                lista.add(cp);
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
    public boolean eliminarConductor(String id_conductor) {
            boolean estado = false;
        Statement st = null;
        String query = "delete conductor where id_conductor='" + id_conductor + "'";
        try {
            st = open().createStatement();
            st.executeUpdate(query);
            open().commit();
            open().close();
            estado = true;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                open().rollback();
                estado = false;
                open().close();
            } catch (Exception ex) {
            }
        }
        return estado;
    }
    
    
}
