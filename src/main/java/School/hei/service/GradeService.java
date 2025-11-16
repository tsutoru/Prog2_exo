package School.hei.service;

import School.hei.*;
import java.time.Instant;

public class GradeService {

    public double getExamGrade(Exam exam, Student student, Instant t) {
        return student.getNotes().stream()
                .filter(n -> n.getExam().getId() == exam.getId())
                .findFirst()
                .map(n -> n.getValueAt(t))
                .orElse(0.0);
    }

    public double getCourseGrade(Course course, Student student, Instant t) {
        double total = 0;
        double totalCoef = 0;

        for (Exam exam : course.getExams()) {
            double grade = getExamGrade(exam, student, t);
            total += grade * exam.getCoefficient();
            totalCoef += exam.getCoefficient();
        }

        if (totalCoef == 0) return 0;

        return total / totalCoef;
    }
}
