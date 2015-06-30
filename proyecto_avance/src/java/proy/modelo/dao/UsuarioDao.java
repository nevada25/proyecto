/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proy.modelo.dao;


import proy.modelo.entidad.Usuario;

/**
 *
 * @author Windows 8.1
 */
public interface UsuarioDao {
    public String ComprobarUsuario(String login, String password);
     
}
