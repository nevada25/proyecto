/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proy.modelo.dao;

import java.util.List;
import proy.modelo.entidad.Conductor;

/**
 *
 * @author Windows 8.1
 */
public interface conductorDao {
    public List<Conductor> ListarConductor();
    public List<Conductor> ListaDatosConductor();
    public boolean EliminarConductor(String idcon);
}
