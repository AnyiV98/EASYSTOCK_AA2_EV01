import modelo.Usuario;
import dao.UsuarioDAO;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Simulación de prueba de conexión a la base de datos
        System.out.println("🎉 Simulación: conexión probada correctamente (sin DB real).");

        // creación de usuario
        UsuarioDAO dao = new UsuarioDAO();
        Usuario nuevo = new Usuario();
        nuevo.setNoIdentificacion("123456789");
        nuevo.setNombre("Anyi");
        nuevo.setApellido("Velásquez");
        nuevo.setCorreo("anyi@example.com");
        nuevo.setIdRol(2); // ejemplo
        nuevo.setContrasena("segura123");
        nuevo.setEstado("activo");

        System.out.println("Simulación: Usuario creado correctamente: " + nuevo.getNombre());

        //  listado de usuarios
        List<Usuario> usuarios = List.of(nuevo); // lista simulada
        System.out.println("📋 Lista de usuarios:");
        for (Usuario u : usuarios) {
            System.out.println(" - " + u.getNombre() + " " + u.getApellido());
        }

        //  actualización
        if (!usuarios.isEmpty()) {
            Usuario primero = usuarios.get(0);
            primero.setNombre("Anyi Actualizada");
            primero.setEstado("inactivo");
            System.out.println("Simulación: Usuario actualizado a: " + primero.getNombre());
        }

        // eliminación
        if (!usuarios.isEmpty()) {
            Usuario ultimo = usuarios.get(usuarios.size() - 1);
            System.out.println("Simulación: Usuario eliminado: " + ultimo.getNombre());
        }

        System.out.println("✅ Programa ejecutado correctamente (sin conexión real).");
    }
}
