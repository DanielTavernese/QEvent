package com.example.dan_t.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.dan_t.mine.EventOption.EventOption;
import com.example.dan_t.mine.EventOption.EventOptionType;

import java.util.Iterator;

public class AddNewEventActivity extends AppCompatActivity {

    boolean ran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnew);

        final AppCompatEditText name = (AppCompatEditText) findViewById(R.id.add_event_name);

        final AppCompatEditText url = (AppCompatEditText) findViewById(R.id.add_event_url);

        final AppCompatEditText date = (AppCompatEditText) findViewById(R.id.add_event_date);

        Button button = (Button) findViewById(R.id.add_event_option);

        Button showButton = (Button) findViewById(R.id.show_event_option);

        Button exectuteButton = (Button) findViewById(R.id.execute_event);


        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(AddNewEventActivity.this, AddEventActivity.class);
                startActivity(intent);
                return false;
            }
        });

        showButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(AddNewEventActivity.this, SearchNewEventActivity.class);
                startActivity(intent);
                return false;
            }
        });

        exectuteButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(ran) {
                    return false;
                }

                ran = true;
                String dates[] = date.getText().toString().split("/");
                Date date =  new Date(Integer.parseInt(dates[0]),
                        Integer.parseInt(dates[1]), Integer.parseInt(dates[2]), Integer.parseInt(dates[3]), Integer.parseInt(dates[4]), Date.DateType.valueOf(dates[5]));
                final EventOptionType[] types = new EventOptionType[MainActivity.getEventOptions().size()];

                Iterator<EventOption> iterator = MainActivity.getEventOptions().iterator();

                int index = 0;

                while(iterator.hasNext()) {
                    types[index] = iterator.next().getType();
                    index++;
                }



                MainActivity.getActiveEvents().add(new Event(name.getText().toString(), url.getText().toString(), date) {

                    @Override
                    public EventOptionType[] getOptions() {
                        return types;
                    }
                });



                //Event event = new Event()

                Intent intent = new Intent(AddNewEventActivity.this, MainActivity.class);
                startActivity(intent);
                return false;
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        MainActivity.getEventOptions().clear();
        startActivity(intent);
    }


}
