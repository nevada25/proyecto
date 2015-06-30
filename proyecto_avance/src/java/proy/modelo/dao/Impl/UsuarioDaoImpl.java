/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proy.modelo.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import proy.modelo.conexion.ConectarOracle;
import proy.modelo.dao.UsuarioDao;
import proy.modelo.entidad.Usuario;

/**
 *
 * @author Windows 8.1
 */
public class UsuarioDaoImpl implements UsuarioDao{
    
    public Connection open() {
        return ConectarOracle.conectar();
    }

    @Override
    public String ComprobarUsuario(String login, String password) {
        String idUsuario = null;
        String query = "SELECT id_usuario FROM Usuario WHERE upper(login)='"+login.toUpperCase()+"' AND password='"+password+"' ";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = open().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                idUsuario = rs.getString("id_usuario");
            }
            open();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            try {
                open();
            } catch (Exception ex) {
            }
        }
        return idUsuario;
    }


}
