package com.example.dan_t.mine.EventOption;

import android.content.Context;

import com.example.dan_t.mine.Event;
import com.example.dan_t.mine.EventOptionActivity;

public enum EventOptionType {

    LINE() {

        @Override
        public EventOption getEventOption(Event event, EventOptionActivity context) {
            return new LineEventOption(context, event);
        }
    },

    FOOD() {
        @Override
        public EventOption getEventOption(Event event, EventOptionActivity context) {
            return new FoodTypeEventOption(context, event);
        }
    },

    MUSIC() {
        @Override
        public EventOption getEventOption(Event event, EventOptionActivity context) {
            return new MusicTypeEventOption(context, event);
        }
    };

    public abstract EventOption getEventOption(Event event, EventOptionActivity context);

}
