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
import proy.modelo.dao.PasajeroDao;
import proy.modelo.entidad.Listar_Pasajeros;

/**
 *
 * @author Windows 8.1
 */
public class PasajeroDaoImpl implements PasajeroDao{

    public Connection open() {
        return ConectarOracle.conectar();
    }
    
    @Override
    public List<Listar_Pasajeros> ListarPasajero() {
        List<Listar_Pasajeros> lista = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        Listar_Pasajeros lp = null;
        String query = " select p.nombres as nombres, p.apellidos as apellidos, v.fecha_viaje as Fecha, v.hora_viaje as hora, c.nombre as Salida, cd.nombre as Destino " +
                        " from persona p, pasajero pa, boleto b, viaje v, ciudad c, ciudad cd " +
                        " where p.id_persona=pa.id_pasajero and pa.id_pasajero=b.id_pasajero and b.id_viaje=v.id_viaje " +
                        " and v.id_ciudad_salida=c.id_ciudad and v.id_ciudad_destino=cd.id_ciudad ";

        try {
            st = open().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                lp = new Listar_Pasajeros();
                lp.setNombres(rs.getString("nombres"));
                lp.setApellidos(rs.getString("apellidos"));
                lp.setFechaViaje(rs.getString("Fecha"));
                lp.setHoraSalida(rs.getString("hora"));
                lp.setCiudadSalida(rs.getString("Salida"));
                lp.setCiudadDestino(rs.getString("Destino"));
                lista.add(lp);
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
    
}
