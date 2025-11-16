package School.hei;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String label;
    private int credits;
    private Teacher teacher;

    private final List<Exam> exams = new ArrayList<>();

    public Course(int id, String label, int credits, Teacher teacher) {
        this.id = id;
        this.label = label;
        this.credits = credits;
        this.teacher = teacher;
    }

    public int getId() { return id; }
    public String getLabel() { return label; }
    public int getCredits() { return credits; }
    public Teacher getTeacher() { return teacher; }

    public void setLabel(String label) { this.label = label; }
    public void setCredits(int credits) { this.credits = credits; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public List<Exam> getExams() {
        return exams;
    }

    public void addExam(Exam exam) {
        if (exam != null && !exams.contains(exam)) {
            exams.add(exam);
        }
    }

    public void removeExam(Exam exam) {
        exams.remove(exam);
    }
}
