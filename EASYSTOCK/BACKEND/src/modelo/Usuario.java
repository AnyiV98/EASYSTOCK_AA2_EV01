package modelo;
import modelo.Usuario;
public class Usuario {
    private int idUsuario;
    private String noIdentificacion;
    private String nombre;
    private String apellido;
    private String correo;
    private int idRol;
    private String contrasena;
    private String fechaCreacion;         
    private String ultimaActualizacion;   
    private String estado;

    // Constructor vacío
    public Usuario() {}

    // Constructor completo
    public Usuario(int idUsuario, String noIdentificacion, String nombre, String apellido,
                   String correo, int idRol, String contrasena, String fechaCreacion,
                   String ultimaActualizacion, String estado) {
        this.idUsuario = idUsuario;
        this.noIdentificacion = noIdentificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.idRol = idRol;
        this.contrasena = contrasena;
        this.fechaCreacion = fechaCreacion;
        this.ultimaActualizacion = ultimaActualizacion;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNoIdentificacion() { return noIdentificacion; }
    public void setNoIdentificacion(String noIdentificacion) { this.noIdentificacion = noIdentificacion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public int getIdRol() { return idRol; }
    public void setIdRol(int idRol) { this.idRol = idRol; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getUltimaActualizacion() { return ultimaActualizacion; }
    public void setUltimaActualizacion(String ultimaActualizacion) { this.ultimaActualizacion = ultimaActualizacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
