package realEstate.persistence.db;
import realEstate.util.TypeValidator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
        private final TypeValidator data = new TypeValidator();
        private static DataBaseConnection instance;
        private final Connection connection;

        private static final String URL = "jdbc:mysql://localhost:3306/inmobiliaria_Manuela_Bermudez_Realtor";
        private static final String USER = "root";
        private static final String PASSWORD = "";

        private DataBaseConnection() {
            try{
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                data.Mensaje("Conexión a la base de datos establecida");
            } catch (SQLException e) {
                throw new RuntimeException("Error al conectar a la base de datos",e);
            }
        }

        public static synchronized DataBaseConnection getInstance() {
            if (instance == null) {
                instance = new DataBaseConnection();
            }
            return instance;
        }

        public Connection getConnection() {
            return connection;
        }
}
