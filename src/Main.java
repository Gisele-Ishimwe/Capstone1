import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            DatabaseInit.createTables();

            Scanner scanner = new Scanner(System.in);

            StudentDAO studentDAO = new StudentDAO();
            CourseDAO courseDAO = new CourseDAO();
            EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

            while (true) {

                System.out.println("\n===== UNIVERSITY MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student Email");
                System.out.println("4. Delete Student");

                System.out.println("5. Add Course");
                System.out.println("6. View Courses");
                System.out.println("7. Update Course Title");
                System.out.println("8. Delete Course");

                System.out.println("9. Enroll Student");
                System.out.println("10. View Enrollments (JOIN)");
                System.out.println("11. Delete Enrollment");

                System.out.println("12. Exit");

                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                switch (choice) {

                    // STUDENT
                    case 1 -> {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();

                        System.out.print("Name: ");
                        String name = scanner.next();

                        System.out.print("Email: ");
                        String email = scanner.next();

                        System.out.print("Level (UG/GRAD): ");
                        String level = scanner.next();

                        studentDAO.addStudent(new Student(id, name, email, level));
                    }

                    case 2 -> studentDAO.viewStudents();

                    case 3 -> {
                        System.out.print("Student ID: ");
                        int id = scanner.nextInt();

                        System.out.print("New Email: ");
                        String email = scanner.next();

                        studentDAO.updateStudentEmail(id, email);
                    }

                    case 4 -> {
                        System.out.print("Student ID: ");
                        int id = scanner.nextInt();
                        studentDAO.deleteStudent(id);
                    }

                    // COURSE
                    case 5 -> {
                        System.out.print("Course ID: ");
                        int id = scanner.nextInt();

                        System.out.print("Title: ");
                        String title = scanner.next();

                        System.out.print("Credits: ");
                        int credits = scanner.nextInt();

                        courseDAO.addCourse(new Course(id, title, credits));
                    }

                    case 6 -> courseDAO.viewCourses();

                    case 7 -> {
                        System.out.print("Course ID: ");
                        int id = scanner.nextInt();

                        System.out.print("New Title: ");
                        String title = scanner.next();

                        courseDAO.updateCourseTitle(id, title);
                    }

                    case 8 -> {
                        System.out.print("Course ID: ");
                        int id = scanner.nextInt();
                        courseDAO.deleteCourse(id);
                    }

                    // ENROLLMENT
                    case 9 -> {
                        System.out.print("Student ID: ");
                        int sid = scanner.nextInt();

                        System.out.print("Course ID: ");
                        int cid = scanner.nextInt();

                        enrollmentDAO.enroll(sid, cid);
                    }

                    case 10 -> enrollmentDAO.viewEnrollments();

                    case 11 -> {
                        System.out.print("Student ID: ");
                        int sid = scanner.nextInt();

                        System.out.print("Course ID: ");
                        int cid = scanner.nextInt();

                        enrollmentDAO.deleteEnrollment(sid, cid);
                    }

                    case 12 -> {
                        System.out.println("Exiting system...");
                        System.exit(0);
                    }

                    default -> System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }
    }
}