package School.hei;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Grade {
    private final Student student;
    private final Exam exam;
    private double initialValue;
    private final List<GradeHistoryEntry> history = new ArrayList<>();

    public Grade(Student student, Exam exam, double initialValue) {
        this.student = student;
        this.exam = exam;
        this.initialValue = initialValue;
    }

    public Student getStudent() {
        return student;
    }

    public Exam getExam() {
        return exam;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public List<GradeHistoryEntry> getHistory() {
        return history;
    }

    public void addHistoryEntry(GradeHistoryEntry entry) {
        history.add(entry);
    }
}
