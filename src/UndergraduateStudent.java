public class UndergraduateStudent extends Student {

    public UndergraduateStudent() {
        super();
    }

    public UndergraduateStudent(int id, String name, String email, String level) {
        super(id, name, email, level);
    }

    @Override
    public double calculateGPA() {
        return 3.2;

    }
}
