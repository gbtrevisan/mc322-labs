package com.unicamp.mc322.lab05.notebook.note.reminder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class WeeklyReminder extends Reminder {

    private final ArrayList<Integer> weekDays;

    public WeeklyReminder(String title, String description, ArrayList<Integer> weekDays) {
        super(title, description);
        this.weekDays = weekDays;
    }

    @Override
    public boolean matchDateTime(LocalDateTime dateTime) {
        return weekDays.contains(dateTime.getDayOfWeek().getValue());
    }

    @Override
    public boolean matchDate(LocalDate date) {
        return weekDays.contains(date.getDayOfWeek().getValue());
    }

}
