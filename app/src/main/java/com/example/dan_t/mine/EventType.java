package com.example.dan_t.mine;

import com.example.dan_t.mine.EventOption.EventOptionType;

import java.sql.Time;

public enum EventType {

    MUSIC_FESTIVAL(new Event("Music Festival", "https://i.imgur.com/j4n5tUe.jpg",
            new Date(12, 22, 2019, 12, 40, Date.DateType.PM)) {

        @Override
        public EventOptionType[] getOptions() {
            return new EventOptionType[] {
                    EventOptionType.MUSIC
            };
        }
    }),

    FOOD_FESTIVAL(new Event("Food Festival", "https://i.imgur.com/L05mXYc.jpg",
            new Date(12, 25, 2019, 12, 40, Date.DateType.AM)) {

        @Override
        public EventOptionType[] getOptions() {
            return new EventOptionType[] {
                    EventOptionType.LINE,
                    EventOptionType.FOOD
            };
        }

    }),

    QHACKS(new Event("Qhacks", "https://i.imgur.com/bSWY4mm.jpg",
            new Date(02, 1, 2019, 7, 00, Date.DateType.PM)) {

        @Override
        public EventOptionType[] getOptions() {
            return new EventOptionType[] {
                    EventOptionType.LINE
            };
        }

    });

    private Event event;

    EventType(Event event) {
        this.event = event;
    }

    public static EventType forName(String name) {
        EventType eventType = null;
        for(EventType type : values()) {
            if(name.equals(type.getEvent().getName())) {
                eventType = type;
            }
        }
        return eventType;
    }

    public Event getEvent() {
        return event;
    }
}
