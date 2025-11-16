package School.hei;

import java.util.ArrayList;
import java.util.List;

public class Promotion {
    private String name;
    private final List<Student> students = new ArrayList<>();

    public Promotion(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Student> getStudents() { return students; }

    public void addStudent(Student s) {
        students.add(s);
    }
}

