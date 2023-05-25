package com.wizeline.containers.messages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

    public Message(String topic, String message, String footNote) {
        setTopic(topic);
        setMessage(message);
        setFootNote(footNote);
    }

    private String topic;

    private String message;

    private String footNote;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message + " on " + DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss").format(LocalDateTime.now());
    }

    public String getFootNote() {
        return footNote;
    }

    public void setFootNote(String footNote) {
        this.footNote = footNote;
    }
}
