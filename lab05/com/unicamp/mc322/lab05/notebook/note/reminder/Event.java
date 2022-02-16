package com.unicamp.mc322.lab05.notebook.note.reminder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Event extends Reminder {

    private final LocalDateTime dateTime;

    public Event(String title, String description, LocalDateTime dateTime) {
        super(title, description);
        this.dateTime = dateTime;
    }

    @Override
    public boolean matchDateTime(LocalDateTime dateTime) {
            return this.dateTime.equals(dateTime);
    }

    @Override
    public boolean matchDate(LocalDate date) {
        return (dateTime.getYear() == date.getYear() &&
                dateTime.getMonth().equals(date.getMonth()) &&
                dateTime.getDayOfMonth() == date.getDayOfMonth());
    }

}
