package com.example.dan_t.mine.EventOption;

import android.app.Activity;
import android.content.Context;

import com.example.dan_t.mine.Event;
import com.example.dan_t.mine.EventOptionActivity;

public abstract class EventOption {

    private Event event;

    private String name;

    private EventOptionType type;

    private String imagePath;

    private Activity activity;

    public EventOption(Activity activity, EventOptionType type, Event event, String name, String imagePath) {
        this.activity = activity;
        this.type  = type;
        this.event = event;
        this.name = name;
        this.imagePath = imagePath;
    }

    public abstract void fire();

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
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

    public EventOptionType getType() {
        return type;
    }

    public Activity getActivity() {
        return activity;
    }
}
