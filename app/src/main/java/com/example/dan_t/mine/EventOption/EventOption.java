package com.example.dan_t.mine.EventOption;

import android.content.Context;

import com.example.dan_t.mine.Event;
import com.example.dan_t.mine.EventOptionActivity;

public abstract class EventOption {

    private Event event;

    private String name;

    private String imagePath;

    private EventOptionActivity context;

    public EventOption(EventOptionActivity context, Event event, String name, String imagePath) {
        this.context = context;
        this.event = event;
        this.name = name;
        this.imagePath = imagePath;
    }

    public abstract void fire();

    public Event getEvent() {
        return event;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getLabel() {
        return name;
    }

    public EventOptionActivity getContext() {
        return context;
    }
}
