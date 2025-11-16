package School.hei;

import java.time.Instant;

public class ExamHistoryEntry {
    private double newValue;
    private Instant when;
    private String reason;

    public ExamHistoryEntry(double newValue, Instant when, String reason) {
        this.newValue = newValue;
        this.when = when;
        this.reason = reason;
    }

    public double getNewValue() {
        return newValue;
    }

    public Instant getWhen() {
        return when;
    }

    public String getReason() {
        return reason;
    }
}
