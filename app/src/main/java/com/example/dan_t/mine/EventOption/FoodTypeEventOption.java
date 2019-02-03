package com.example.dan_t.mine.EventOption;

import android.content.Context;

import com.example.dan_t.mine.Event;
import com.example.dan_t.mine.EventOptionActivity;

public class FoodTypeEventOption extends EventOption {

    public FoodTypeEventOption(EventOptionActivity context, Event event) {
        super(context, event, "Food Choices", "https://i.imgur.com/zvGe8P7.jpg");
    }

    @Override
    public void fire() {

    }
}
