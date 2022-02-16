package com.unicamp.mc322.lab05.notebook.note.reminder;

import com.unicamp.mc322.lab05.notebook.note.Note;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reminder extends Note {

    public Reminder(String title, String description) {
        super(title, description);
    }

    public boolean matchDateTime(LocalDateTime dateTime) {
        return true;
    }

    public boolean matchDate(LocalDate date) {
        return true;
    }

}
