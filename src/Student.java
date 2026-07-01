public class Student {

    // Fields (Encapsulation)
    private int id;
    private String name;
    private String email;
    private String level;

    // Default Constructor
    public Student() {

    }

    // Parameterized Constructor
    public Student(int id, String name, String email, String level) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.level = level;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLevel() {
        return level;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    // Polymorphism
    public double calculateGPA() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Student ID : " + id +
                "\nName : " + name +
                "\nEmail : " + email +
                "\nLevel : " + level;
    }
}