import java.sql.*;

public class StudentDAO {

    Connection conn;

    public StudentDAO() throws SQLException {
        conn = DataConnectivity.createConnection();
    }

    // CREATE
    public void addStudent(Student s) {

        try {
            String sql = "INSERT INTO students VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getLevel());

            ps.executeUpdate();
            System.out.println("Student added");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // READ
    public void viewStudents() {

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("email") + " | " +
                                rs.getString("level")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // UPDATE
    public void updateStudentEmail(int id, String email) {

        try {
            String sql = "UPDATE students SET email = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Student updated");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // DELETE
    public void deleteStudent(int id) {

        try {
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Student deleted");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
