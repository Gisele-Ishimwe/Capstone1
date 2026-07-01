import java.sql.*;

public class EnrollmentDAO {

    Connection conn;

    public EnrollmentDAO() throws SQLException {
        conn = DataConnectivity.createConnection();
    }

    // CREATE (ENROLL)
    public void enroll(int studentId, int courseId) {

        try {
            String sql = "INSERT INTO enrollments VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ps.executeUpdate();
            System.out.println("Student enrolled");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // READ (JOIN QUERY - VERY IMPORTANT)
    public void viewEnrollments() {

        try {
            String sql = """
                SELECT s.name, c.title
                FROM students s
                JOIN enrollments e ON s.id = e.student_id
                JOIN courses c ON c.id = e.course_id
            """;

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + " -> " +
                                rs.getString("title")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // DELETE
    public void deleteEnrollment(int studentId, int courseId) {

        try {
            String sql = "DELETE FROM enrollments WHERE student_id = ? AND course_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ps.executeUpdate();
            System.out.println("Enrollment deleted");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}