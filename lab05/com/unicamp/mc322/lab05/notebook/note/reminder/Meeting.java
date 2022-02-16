package com.unicamp.mc322.lab05.notebook.note.reminder;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Meeting extends Event {

    private final ArrayList<Person> participants;

    public Meeting(String title, String description, LocalDateTime dateTime, ArrayList<Person> participants) {
        super(title, description, dateTime);
        this.participants = participants;
    }

    public boolean isConfirmed(Person person) {
        return participants.contains(person);
    }

    public String confirmParticipants() {
        StringBuilder formattedString = new StringBuilder("Meeting confirmed participants: \n");
        participants.forEach(person -> formattedString.append("- ").append(person.toString()).append("\n"));
        return formattedString.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (!getClass().equals(other.getClass()))
            return false;
        return this == other;
    }

}
