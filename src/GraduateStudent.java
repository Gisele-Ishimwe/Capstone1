public class GraduateStudent extends Student {

    public GraduateStudent() {
        super();
    }

    public GraduateStudent(int id, String name, String email, String level) {
        super(id, name, email, level);
    }

    @Override
    public double calculateGPA() {
        return 3.8;
    }
}