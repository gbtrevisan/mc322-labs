package com.unicamp.mc322.lab05.notebook.note.reminder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyReminder extends Reminder {

    private final int month;

    public MonthlyReminder(String title, String description, int month) {
        super(title, description);
        this.month = month;
    }

    @Override
    public boolean matchDateTime(LocalDateTime dateTime) {
        return month == dateTime.getMonth().getValue();
    }

    @Override
    public boolean matchDate(LocalDate date) {
        return month == date.getMonth().getValue();
    }

}
