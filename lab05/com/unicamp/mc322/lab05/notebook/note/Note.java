package com.unicamp.mc322.lab05.notebook.note;

public class Note {

    private Title title;
    private Description description;

    public Note(String title, String description) {
        this.title = new Title(title);
        this.description = new Description(description);
    }

    public void changeTitle(String newTitle) {
        title = new Title(newTitle);
    }

    public void changeDescription(String newDescription) {
        description = new Description(newDescription);
    }

    @Override
    public String toString() {
        StringBuilder formattedString = new StringBuilder("[" + title + "]");
        if (!description.toString().isBlank())
            formattedString.append(" - ").append(description);
        return formattedString.toString();
    }

}
