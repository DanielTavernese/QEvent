package com.example.dan_t.mine;

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

public class EventOptionActivity extends AppCompatActivity {

    private ArrayList<EventOption> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        String eventName = getIntent().getStringExtra("name");

        EventType event = EventType.forName(eventName);

        for(EventOptionType type : event.getEvent().getOptions()) {
            events.add(type.getEventOption(event.getEvent(), this));
        }

        initRecyclerView();
    }


    public void initRecyclerView(){

        RecyclerView recyclerView = findViewById(R.id.event_view);

        OptionRecycleViewAdapter adapter = new OptionRecycleViewAdapter(this, events);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
