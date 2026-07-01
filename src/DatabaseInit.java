import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInit {

    public static void createTables() {

        try {

            Connection conn = DataConnectivity.createConnection();
            Statement stmt = conn.createStatement();

            String students = """
                CREATE TABLE IF NOT EXISTS students (
                    id INT PRIMARY KEY,
                    name VARCHAR(100),
                    email VARCHAR(100),
                    level VARCHAR(20)
                )
            """;

            String courses = """
                CREATE TABLE IF NOT EXISTS courses (
                    id INT PRIMARY KEY,
                    title VARCHAR(100),
                    credits INT
                )
            """;

            String enrollments = """
                CREATE TABLE IF NOT EXISTS enrollments (
                    student_id INT,
                    course_id INT,
                    PRIMARY KEY (student_id, course_id)
                )
            """;

            stmt.execute(students);
            stmt.execute(courses);
            stmt.execute(enrollments);

            System.out.println("Tables created successfully!");

            conn.close();
            stmt.close();

        } catch (Exception e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }
}
