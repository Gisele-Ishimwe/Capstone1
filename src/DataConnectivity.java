import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnectivity {

    public static Connection createConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/UniversityDB",
                "postgres",
                "Imissyou13@"
        );
    }
}