package com.example.dan_t.mine.EventOption;

import android.app.Activity;
import android.content.Context;

import com.example.dan_t.mine.Event;
import com.example.dan_t.mine.EventOptionActivity;

public class MusicTypeEventOption extends EventOption {

    private int numberOfChoices;

    public MusicTypeEventOption(Activity activity, Event event) {
        super(activity, EventOptionType.MUSIC, event, "Music Choices", "https://i.imgur.com/JCxhLOc.jpg");
        this.numberOfChoices = 7;
    }

    @Override
    public void fire() {

    }

    @Override
    public String getLabel() {
        return super.getLabel() + "\n" + "Number of Choices: " + numberOfChoices;
    }

}
