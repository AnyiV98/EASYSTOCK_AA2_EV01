import dao.UsuarioDAO;
import modelo.Usuario;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();

        System.out.println("=== LOGIN ===");
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        // Buscar todos los usuarios
        List<Usuario> usuarios = dao.obtenerUsuarios();
        boolean loginExitoso = false;

        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo) && u.getContrasena().equals(contrasena)) {
                loginExitoso = true;
                System.out.println("✅ Login exitoso. Bienvenido: " + u.getNombre() + " " + u.getApellido());
                break;
            }
        }

        if (!loginExitoso) {
            System.out.println("❌ Usuario o contraseña incorrectos.");
        }

        // Mostrar lista completa de usuarios
        System.out.println("\n📋 Lista de usuarios en la base de datos:");
        for (Usuario u : usuarios) {
            System.out.println(" - " + u.getNombre() + " " + u.getApellido() + " | Rol ID: " + u.getIdRol());
        }

        scanner.close();
    }
}
