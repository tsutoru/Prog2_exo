package School.hei;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ExamGrade {

    private Student student;
    private Exam exam;
    private double initialValue;
    private final List<ExamHistoryEntry> history = new ArrayList<>();

    public ExamGrade(Student student, Exam exam, double initialValue) {
        this.student = student;
        this.exam = exam;
        this.initialValue = initialValue;
    }

    public Student getStudent() { return student; }
    public Exam getExam() { return exam; }
    public double getInitialValue() { return initialValue; }

    public List<ExamHistoryEntry> getHistory() { return history; }

    public void addChange(double newValue, String reason, Instant when) {
        history.add(new ExamHistoryEntry(newValue, when, reason));
    }

    public double getValueAt(Instant t) {
        double value = initialValue;
        for (ExamHistoryEntry change : history) {
            if (!change.getWhen().isAfter(t)) {
                value = change.getNewValue();
            }
        }
        return value;
    }
}
