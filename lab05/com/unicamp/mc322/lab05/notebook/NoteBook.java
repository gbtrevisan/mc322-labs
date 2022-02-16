package com.unicamp.mc322.lab05.notebook;

import com.unicamp.mc322.lab05.notebook.note.reminder.Meeting;
import com.unicamp.mc322.lab05.notebook.note.reminder.Reminder;
import com.unicamp.mc322.lab05.notebook.note.reminder.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class NoteBook {

    private final ArrayList<Reminder> reminders;
    private final Out out;

    public NoteBook() {
        reminders = new ArrayList<>();
        out = new Out();
    }

    private ArrayList<Reminder> getRemindersOfDate(LocalDate date) {
        ArrayList<Reminder> remindersOfDate = new ArrayList<>();
        for (Reminder reminder : reminders) {
            if (reminder.matchDate(date))
                remindersOfDate.add(reminder);
        }
        return  remindersOfDate;
    }

    public void addReminder(Reminder reminder) {
        if (!reminders.contains(reminder))
            reminders.add(reminder);
    }

    public void cancelReminder(Reminder reminder) {
        reminders.remove(reminder);
    }

    public void showTodayReminders() {
        showReminders(LocalDate.now());
    }

    public void showReminders(LocalDate date) {
        out.displayText("Date: " + date + "\n");
        ArrayList<Reminder> remindersOfDate = getRemindersOfDate(date);
        if (remindersOfDate.isEmpty())
            out.displayText("No reminders today ;)\n");
        else
            remindersOfDate.forEach(reminder -> out.displayText("* " + reminder + "\n"));
        out.displayBlankLine();
    }

    public void showReminders(LocalDate dateBefore, LocalDate dateAfter) {
        ArrayList<Reminder> remindersOfDay;
        while (!dateBefore.equals(dateAfter)) {
            remindersOfDay = getRemindersOfDate(dateBefore);
            if (!remindersOfDay.isEmpty()) {
                out.displayDiv();
                out.displayBlankLine();
                out.displayText("Date: " + dateBefore + "\n");
                out.displayBlankLine();
                for (Reminder reminder : remindersOfDay)
                    out.displayText("* " + reminder + "\n");
                out.displayDiv();
            }
            dateBefore = dateBefore.plusDays(1);
        }
    }

    public void showReminders(LocalDateTime dateTime) {
        ArrayList<Reminder> remindersOfDate = getRemindersOfDate(dateTime.toLocalDate());
        if (!remindersOfDate.isEmpty()) {
            out.displayText("Date: " + dateTime.toLocalDate() + " | "  + dateTime.toLocalTime() + "\n");
            for (Reminder reminder : remindersOfDate)
                if (reminder.matchDateTime(dateTime))
                    out.displayText("* " + reminder + "\n");
        } else
            out.displayText("No reminders today ;)");
        out.displayBlankLine();
    }

    public void confirmMeetingParticipants(Meeting meeting) {
        out.displayText(meeting.confirmParticipants());
        out.displayBlankLine();
    }

    public boolean confirmMeetingParticipant(Person person, Meeting meeting) {
        return meeting.isConfirmed(person);
    }

}
