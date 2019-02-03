package com.example.dan_t.mine.EventOption;

import android.content.Context;
import android.content.Intent;

import com.example.dan_t.mine.CardviewFood;
import com.example.dan_t.mine.Event;
import com.example.dan_t.mine.EventOptionActivity;

public class FoodTypeEventOption extends EventOption {

    public FoodTypeEventOption(EventOptionActivity context, Event event) {
        super(context, event, "Food Choices", "https://i.imgur.com/zvGe8P7.jpg");
    }

    @Override
    public void fire() {

        Intent intent = new Intent(getContext(), CardviewFood.class);
        getContext().startActivity(intent);

    }
}
