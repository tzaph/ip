package task;

import exception.AronaInvalidDateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a "Event" task,
 * which is a task with a start time and end time attached.
 *
 * @author Maximilliano Utomo
 */
public class Event extends Task {
    /**
     * The start time of the task.
     */
    LocalDate startTime;
    /**
     * The end time of the task.
     */
    LocalDate endTime;

    /**
     * A public constructor for the task.Event.
     * @param desc - the description of the task
     * @param startTime - the start time of the task
     * @param endTime - the end time of the task
     */
    public Event(String desc, String startTime, String endTime) throws AronaInvalidDateException {
        super(desc);
        try {
            this.startTime = LocalDate.parse(startTime);
            this.endTime = LocalDate.parse(endTime);
        } catch (DateTimeParseException e) {
            throw new AronaInvalidDateException("");
        }
    }

    @Override
    public String toDataFormat() {
        return "E|" + super.toDataFormat() + "|" + this.startTime + "|" + this.endTime;
    }

    /**
     * Represent the task into a String format applicable for printing output.
     * Uses an extra [E] to represent a task.Event.
     * @return A String representation of the task.Event
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() +
                " (from: " + this.startTime.format(DateTimeFormatter.ofPattern("MMM d yyyy")) +
                " to: " + this.endTime.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
