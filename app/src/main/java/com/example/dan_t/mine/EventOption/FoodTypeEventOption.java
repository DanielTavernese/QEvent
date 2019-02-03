package com.example.dan_t.mine.EventOption;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.dan_t.mine.CardviewFood;
import com.example.dan_t.mine.Event;
import com.example.dan_t.mine.EventOptionActivity;

public class FoodTypeEventOption extends EventOption {

    public FoodTypeEventOption(Activity activity, Event event) {
        super(activity, EventOptionType.FOOD, event, "Food Choices", "https://i.imgur.com/zvGe8P7.jpg");
    }

    @Override
    public void fire() {

        Intent intent = new Intent(getActivity(), CardviewFood.class);
        getActivity().startActivity(intent);

    }
}
