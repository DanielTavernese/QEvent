package com.example.dan_t.mine.EventOption;

import android.app.Activity;
import android.content.Context;

import com.example.dan_t.mine.Event;
import com.example.dan_t.mine.EventOptionActivity;

public enum EventOptionType {

    LINE() {

        @Override
        public EventOption getEventOption(Event event, Activity activity) {
            return new LineEventOption(activity, event);
        }
    },

    FOOD() {
        @Override
        public EventOption getEventOption(Event event, Activity activity) {
            return new FoodTypeEventOption(activity, event);
        }
    },

    MUSIC() {
        @Override
        public EventOption getEventOption(Event event, Activity activity) {
            return new MusicTypeEventOption(activity, event);
        }
    };

    public abstract EventOption getEventOption(Event event, Activity activity);

}
