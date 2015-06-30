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
import proy.modelo.dao.ViajeDao;
import proy.modelo.entidad.Boleto;
import proy.modelo.entidad.Ciudad;
import proy.modelo.entidad.Conductor;
import proy.modelo.entidad.Persona;
import proy.modelo.entidad.Vehiculo;
import proy.modelo.entidad.Viaje;

/**
 *
 * @author CARSA COMPUTO
 */
public class ViajeDaoImpl implements ViajeDao {

    public Connection open() {
        return ConectarOracle.conectar();
    }

    @Override
    public List<Ciudad> listarCiudad() {

        List<Ciudad> lista = new ArrayList<Ciudad>();
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from ciudad";
        Ciudad ciudad = null;
        try {
            st = open().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ciudad = new Ciudad();
                ciudad.setIdCiudad(rs.getString("id_ciudad"));
                ciudad.setNombre(rs.getString("nombre"));
                lista.add(ciudad);
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
    public boolean RegistrarViaje(Viaje viaje) {
        boolean estado = false;
        Statement st = null;
        String query = "insert into viaje (fecha_viaje, "
                + "hora_viaje, "
                + "estado, "
                + "id_conductor, "
                + "id_vehiculo, "
                + "id_ciudad_salida, "
                + "id_ciudad_destino) values('"
                + viaje.getFechaViaje() + "','"
                + viaje.getHoraViaje() + "','1','"
                + viaje.getIdConductor()+ "','"
                + viaje.getIdVehiculo()+ "','"
                + viaje.getIdCiudadSalida() + "','"
                + viaje.getIdCiudadDestino() + "')";

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

    @Override
    public List<Persona> listarConductor() {
        List<Persona> lista = new ArrayList<Persona>();
        Statement st = null;
        ResultSet rs = null;
        String sql = "select c.id_conductor,p.nombres, p.apellidos "
                + "from persona p,conductor c "
                + "where p.id_persona=c.id_conductor";
        Persona persona = null;
        try {
            st = open().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                persona = new Persona();
                persona.setIdPersona(rs.getString("id_conductor"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                lista.add(persona);
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
    public List<Vehiculo> listarVehiPlaca() {
        List<Vehiculo> lista = new ArrayList<Vehiculo>();
        Statement st = null;
        ResultSet rs = null;
        String sql = "select v.id_vehiculo, v.nro_placa from vehiculo v";
        Vehiculo vehiculo = null;
        try {
            st = open().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                vehiculo = new Vehiculo();
                vehiculo.setIdVehiculo(rs.getString("id_vehiculo"));
                vehiculo.setNroPlaca(rs.getString("nro_placa"));
                lista.add(vehiculo);
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
    public List<Conductor> listarConductorViaje(String id) {
        List<Conductor> lista = new ArrayList<Conductor>();
        Statement st = null;
        ResultSet rs = null;
        String sql = "select p.APELLIDOS, p.NOMBRES, v.FECHA_VIAJE, v.HORA_VIAJE, ve.NRO_PLACA, "
                + " ciu.NOMBRE as ciudad_destino, v.id_viaje "
                + " from persona p, conductor c, viaje v, vehiculo ve,ciudad ciu "
                + "   where p.ID_PERSONA=c.ID_CONDUCTOR "
                + "	  and c.ID_CONDUCTOR=v.ID_CONDUCTOR "
                + "	  and v.ID_VEHICULO=ve.ID_VEHICULO "
                + "	  and v.ID_CIUDAD_DESTINO=ciu.ID_CIUDAD "
                + "	  and v.ID_CIUDAD_DESTINO='" + id + "' and v.estado='1'" ;
        Conductor conductor = null;
        try {
            st = open().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                conductor = new Conductor();
                conductor.setApellidos(rs.getString("apellidos"));
                conductor.setNombres(rs.getString("nombres"));
                conductor.setFecha_viaje(rs.getString("fecha_viaje"));
                conductor.setHora_viaje(rs.getString("hora_viaje"));
                conductor.setNro_placa(rs.getString("nro_placa"));
                conductor.setCiudadDestino(rs.getString("ciudad_destino"));
                conductor.setIdViaje(rs.getString("id_viaje"));
               
                lista.add(conductor);
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
    public boolean eliminarViajes(String id_viajes) {
        boolean estado = false;
        Statement st = null;
        String query = "update viaje set estado='0' where id_viaje='" + id_viajes + "'";
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

    @Override
    public List<Persona> buscarPasajero(String dni) {

        List<Persona> lista = new ArrayList<Persona>();
        Statement st = null;
        ResultSet rs = null;
        Persona persona = null;
        String query = "select p.id_persona, p.NOMBRES, p.APELLIDOS, p.GENERO, p.DNI, p.TELEFONO "
                + "from persona p, pasajero pa  "
                + "where p.ID_PERSONA=pa.ID_PASAJERO and p.dni='"+dni+"' ";
        try {
            st = open().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                persona = new Persona();
                persona.setIdPersona(rs.getString("id_persona"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setGenero(rs.getString("genero"));
                persona.setDni(rs.getString("dni"));
                persona.setTelefono(rs.getString("telefono"));
                lista.add(persona);
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
    public boolean RegistrarBoleto(Boleto boleto) {
         boolean estado = false;
        Statement st = null;
        String query = "insert into boleto (id_boleto, "
                + "valor_pagar, "
                + " boletos, "
                + "id_pasajero, "
                + "id_viaje) values('','"
                + boleto.getValorPagar()+ "','"
                + boleto.getBoletos()+ "','"
                + boleto.getIdPasajero()+ "','"
                +boleto.getIdViaje()+"')";

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
