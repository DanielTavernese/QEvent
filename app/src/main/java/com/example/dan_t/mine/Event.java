package com.example.dan_t.mine;

import com.example.dan_t.mine.EventOption.EventOption;
import com.example.dan_t.mine.EventOption.EventOptionType;

import java.sql.Time;

public abstract class Event {

    private String name;

    private String imageURL;

    private Date date;

    public Event(String name, String imageURL, Date date) {
        this.name = name;
        this.imageURL = imageURL;
        this.date = date;
    }

    public abstract EventOptionType[] getOptions();


    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Date getDate() {
        return date;
    }
}
