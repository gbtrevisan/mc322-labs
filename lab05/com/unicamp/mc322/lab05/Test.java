package com.unicamp.mc322.lab05;

import com.unicamp.mc322.lab05.notebook.NoteBook;
import com.unicamp.mc322.lab05.notebook.note.reminder.*;
import com.unicamp.mc322.lab05.notebook.time.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        Reminder reminder;

        NoteBook noteBook = new NoteBook();

        reminder = new Reminder("Eat vegetables", "Got to keep healthy.");
        noteBook.addReminder(reminder);
        reminder = new Reminder("Drink more water", "I got to keep my self hydrated ...");
        noteBook.addReminder(reminder);

        reminder = new MonthlyReminder("Dog`s vet", "Need to bring Nina and Thor to the vet.", Month.MAY);
        noteBook.addReminder(reminder);
        reminder = new MonthlyReminder("Go to the beach", "Take a trip to the closest beach.", Month.MAY);
        noteBook.addReminder(reminder);

        ArrayList<Integer> weekDays = new ArrayList<>();
        weekDays.add(WeekDay.MONDAY);
        weekDays.add(WeekDay.TUESDAY);
        weekDays.add(WeekDay.WEDNESDAY);
        weekDays.add(WeekDay.FRIDAY);

        reminder = new WeeklyReminder("Go to the gim", "Workout on the La Fitness Gim.", weekDays);
        noteBook.addReminder(reminder);

        weekDays.clear();
        weekDays.add(WeekDay.MONDAY);
        weekDays.add(WeekDay.WEDNESDAY);
        weekDays.add(WeekDay.FRIDAY);
        reminder = new WeeklyReminder("Personal project", "Keep adding new features to the N.A.M.E.L.E.S.S project.", weekDays);
        noteBook.addReminder(reminder);

        reminder = new Event(
                "Brother`s weeding",
                "Buy present and go to my brothers weeding",
                LocalDateTime.of(2021, Month.MAY, 2, 18, 0, 0));
        noteBook.addReminder(reminder);
        reminder = new Event(
                "Play Among Us",
                "Test the new map that was recently added.",
                LocalDateTime.of(2021, Month.MAY, 2, 14, 30, 0));
        noteBook.addReminder(reminder);

        ArrayList<Person> participants = new ArrayList<>();
        participants.add(new Person("Gabriel Luiz Trevisan", "g177967@dac.unicamp.br", "(35) 988978137"));
        participants.add(new Person("Jonathan Marquez", "j132317@dac.unicamp.br", "(35) 978123218"));

        reminder = new Meeting(
                "Project meeting",
                "Meeting to introduce the new guy.",
                LocalDateTime.of(2021, Month.MAY, 3, 13, 30, 0),
                participants);
        noteBook.addReminder(reminder);
        noteBook.confirmMeetingParticipants((Meeting) reminder);

        participants.clear();
        participants.add(new Person("Me", "myemail@email.com", "(90) 981212313"));
        participants.add(new Person("Mom", "momemail@email.com", "(90) 913812321"));
        participants.add((new Person("Dad", "dademail@email.com", "(90) 987731321")));

        reminder = new Meeting(
                "Family meeting",
                "Talk about leaving the country.",
                LocalDateTime.of(2021, Month.MAY, 9, 15, 0, 0),
                participants);
        noteBook.addReminder(reminder);
        noteBook.confirmMeetingParticipants((Meeting) reminder);

        noteBook.showTodayReminders();
        noteBook.showReminders(LocalDateTime.of(2021, Month.MAY, 2, 18, 0, 0));
        noteBook.showReminders(LocalDate.of(2021, Month.MAY, 3));
        noteBook.showReminders(LocalDate.of(2021, Month.MAY, 2), LocalDate.of(2021, Month.JULY, 2));

    }

}
