package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // ⚙️ Parámetros de conexión
    private static final String URL = "jdbc:sqlserver://localhost;databaseName=Easystock;integratedSecurity=true;";
    // Si quieres usar usuario/contraseña en lugar de integratedSecurity, usa:
    // private static final String URL = "jdbc:sqlserver://localhost;databaseName=Easystock;";
    private static final String USUARIO = "sa";
    private static final String CONTRASENA = "Anyi0516";

    // 🔌 Obtener conexión
    public static Connection getConnection() {
        Connection conexion = null;
        try {
            // Cargar el driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establecer la conexión
            // Si usas integratedSecurity, no necesitas USUARIO y CONTRASENA
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            System.out.println("✅ Conexión exitosa.");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: Driver JDBC no encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }

    // 🧹 Cerrar conexión
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("🔒 Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("⚠️ Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}



