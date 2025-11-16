package GradeServiceTest;

import School.hei.*;
import School.hei.service.GradeService;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class GradeServiceTest {

    @Test
    public void testGetExamGrade_initialValue() {
        // Arrange
        Student s = new Student(1, "Dupont", "Paul", null, "p@test.com", "000", "G1", null);
        Course c = new Course(1, "PROG1", 5, null);
        Exam e = new Exam(1, "Exam1", c, Instant.now(), 2);
        c.addExam(e);

        ExamGrade grade = new ExamGrade(s, e, 12.0);
        s.addNote(grade);

        GradeService service = new GradeService();

        // Act
        double result = service.getExamGrade(e, s, Instant.now());

        // Assert
        assertEquals(12.0, result);
    }

    @Test
    public void testGetExamGrade_withHistory() {
        // Arrange
        Student s = new Student(1, "Dupont", "Paul", null, "p@test.com", "000", "G1", null);
        Course c = new Course(1, "PROG1", 5, null);
        Exam e = new Exam(1, "Exam1", c, Instant.now(), 2);
        c.addExam(e);

        ExamGrade grade = new ExamGrade(s, e, 10.0);
        grade.addChange(14.0, "Correction", Instant.parse("2024-01-01T10:00:00Z"));
        grade.addChange(16.0, "Re-correction", Instant.parse("2024-01-02T10:00:00Z"));
        s.addNote(grade);

        GradeService service = new GradeService();

        // Act
        double valueBefore = service.getExamGrade(e, s, Instant.parse("2024-01-01T09:00:00Z"));
        double valueMiddle = service.getExamGrade(e, s, Instant.parse("2024-01-01T12:00:00Z"));
        double valueAfterAll = service.getExamGrade(e, s, Instant.parse("2024-01-03T10:00:00Z"));

        // Assert
        assertEquals(10.0, valueBefore);   // avant toute modif
        assertEquals(14.0, valueMiddle);   // après la première modif
        assertEquals(16.0, valueAfterAll); // après la deuxième modif
    }
    @Test
    public void testGetCourseGrade() {
        // Arrange
        Student s = new Student(1, "Dupont", "Paul", null, "p@test.com", "000", "G1", null);
        Teacher t = new Teacher(1, "Prof", "X", null, "t@test.com", "111", "Backend");

        Course course = new Course(1, "PROG1", 5, t);

        Exam e1 = new Exam(1, "Exam1", course, Instant.now(), 2);
        Exam e2 = new Exam(2, "Exam2", course, Instant.now(), 3);

        course.addExam(e1);
        course.addExam(e2);

        ExamGrade g1 = new ExamGrade(s, e1, 10.0);
        ExamGrade g2 = new ExamGrade(s, e2, 15.0);

        s.addNote(g1);
        s.addNote(g2);

        GradeService service = new GradeService();

        // Act
        double result = service.getCourseGrade(course, s, Instant.now());

        // Assert
        // calcul attendu = (10 * 2 + 15 * 3) / 5 = 13
        assertEquals(13.0, result);
    }

}
