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

public class AddEventActivity  extends AppCompatActivity {

    private static final String TAG = "AddEventActivity";

    private ArrayList<EventOption> events = new ArrayList<>();

    private OptionAddRecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_main);

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        fillEvents();
        initRecyclerView();
    }



    private void fillEvents() {
        for(EventOptionType type : EventOptionType.values()) {
            events.add(type.getEventOption(null, this));
        }
    }


    private void initRecyclerView(){

        RecyclerView recyclerView = findViewById(R.id.search_view);

        adapter = new OptionAddRecycleViewAdapter(this, events);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        Log.d(TAG, "Hello");
        inflater.inflate(R.menu.event_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }



    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, AddNewEventActivity.class);
        startActivity(intent);
    }

}