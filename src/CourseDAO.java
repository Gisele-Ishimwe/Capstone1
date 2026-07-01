import java.sql.*;

public class CourseDAO {

    Connection conn;

    public CourseDAO() throws SQLException {
        conn = DataConnectivity.createConnection();
    }

    // CREATE
    public void addCourse(Course c) {

        try {
            String sql = "INSERT INTO courses VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, c.getId());
            ps.setString(2, c.getTitle());
            ps.setInt(3, c.getCredits());

            ps.executeUpdate();
            System.out.println("Course added");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // READ
    public void viewCourses() {

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM courses");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getInt("credits")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // UPDATE
    public void updateCourseTitle(int id, String title) {

        try {
            String sql = "UPDATE courses SET title = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, title);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Course updated");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // DELETE
    public void deleteCourse(int id) {

        try {
            String sql = "DELETE FROM courses WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Course deleted");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
