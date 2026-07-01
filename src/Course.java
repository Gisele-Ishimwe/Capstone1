public class Course {

    private int id;
    private String title;
    private int credits;

    public Course() {

    }

    public Course(int id, String title, int credits) {
        this.id = id;
        this.title = title;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course ID: " + id +
                "\nTitle: " + title +
                "\nCredits: " + credits;
    }
    System.out.println("Course module feature working");
}
