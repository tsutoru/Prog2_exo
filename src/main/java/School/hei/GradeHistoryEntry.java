package School.hei;

import java.time.Instant;

import java.time.Instant;

public class GradeHistoryEntry {
    private final double value;
    private final Instant date;
    private final String reason;

    public GradeHistoryEntry(double value, Instant date, String reason) {
        this.value = value;
        this.date = date;
        this.reason = reason;
    }

    public double getValue() { return value; }
    public Instant getDate() { return date; }
    public String getReason() { return reason; }
}


