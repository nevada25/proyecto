package proy.modelo.entidad;
// Generated 21/06/2015 10:04:22 AM by Hibernate Tools 3.6.0



/**
 * Usuario generated by hbm2java
 */
public class Usuario {


     private String idUsuario;
     private String login;
     private String password;
    
     
    public Usuario() {
    }

	
    public Usuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


