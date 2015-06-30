package proy.modelo.entidad;
// Generated 21/06/2015 10:04:22 AM by Hibernate Tools 3.6.0



/**
 * Persona generated by hbm2java
 */
public class Persona  {


     private String idPersona;
     private String nombres;
     private String apellidos;
     private String dni;
     private String genero;
     private String fec_nacimiento;
     private String direccion;
     private String telefono;

    public Persona() {
    }

	
    public Persona(String idPersona) {
        this.idPersona = idPersona;
    }
    public Persona(String idPersona, String nombres, String apellidos, String dni, String genero, String fec_nacimiento, String direccion, String telefono) {
       this.idPersona = idPersona;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.dni = dni;
       this.genero = genero;
       this.fec_nacimiento = fec_nacimiento;
       this.direccion = direccion;
       this.telefono = telefono;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFec_nacimiento() {
        return fec_nacimiento;
    }

    public void setFec_nacimiento(String fec_nacimiento) {
        this.fec_nacimiento = fec_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   
}


