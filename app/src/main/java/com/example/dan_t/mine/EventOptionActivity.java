package com.example.dan_t.mine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.dan_t.mine.EventOption.EventOption;
import com.example.dan_t.mine.EventOption.EventOptionType;

import java.util.ArrayList;
import java.util.List;

public class EventOptionActivity extends AppCompatActivity {

    private static ArrayList<EventOption> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        String eventName = getIntent().getStringExtra("name");

        EventType event = EventType.forName(eventName);

        setTitle(event.getEvent().getName());

        events.clear();

        for(EventOptionType type : event.getEvent().getOptions()) {
            events.add(type.getEventOption(event.getEvent(), this));
        }

        RecyclerView recyclerView = findViewById(R.id.event_view);
        initRecyclerView(this, recyclerView);
    }


    public static void initRecyclerView(Context context, RecyclerView recyclerView){

        OptionRecycleViewAdapter adapter = new OptionRecycleViewAdapter(context, events);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
