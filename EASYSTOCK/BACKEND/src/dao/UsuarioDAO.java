package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;
import modelo.ConexionBD;

public class UsuarioDAO {

    // Insertar Usuario
    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIOS (no_identificacion, nombre, apellido, correo, id_rol, contrasena, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNoIdentificacion());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido());
            stmt.setString(4, usuario.getCorreo());
            stmt.setInt(5, usuario.getIdRol());
            stmt.setString(6, usuario.getContrasena());
            stmt.setString(7, usuario.getEstado());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar usuario.");
            e.printStackTrace();
            return false;
        }
    }

    // Consultar Usuarios
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM USUARIOS";

        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("no_identificacion"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getInt("id_rol"),
                    rs.getString("contrasena"),
                    rs.getString("fecha_creacion"),
                    rs.getString("ultima_actualizacion"),
                    rs.getString("estado")
                );
                lista.add(u);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al consultar usuarios.");
            e.printStackTrace();
        }

        return lista;
    }

    // Actualizar Usuario
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE USUARIOS SET nombre = ?, apellido = ?, correo = ?, id_rol = ?, contrasena = ?, estado = ?, ultima_actualizacion = GETDATE() WHERE id_usuario = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getCorreo());
            stmt.setInt(4, usuario.getIdRol());
            stmt.setString(5, usuario.getContrasena());
            stmt.setString(6, usuario.getEstado());
            stmt.setInt(7, usuario.getIdUsuario());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar usuario.");
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar Usuario
    public boolean eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM USUARIOS WHERE id_usuario = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar usuario.");
            e.printStackTrace();
            return false;
        }
    }
}

