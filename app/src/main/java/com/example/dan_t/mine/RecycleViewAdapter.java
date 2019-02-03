package com.example.dan_t.mine;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private static final String TAG = "RecycleViewAdapter";

    private ArrayList<Event> mEvents = new ArrayList<>();


    private Context mContext;

    public RecycleViewAdapter(Context context, ArrayList<Event> events) {
        mEvents = events;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        final Event event = mEvents.get(i);
        Glide.with(mContext).asBitmap().load(event.getImageURL()).into(viewHolder.imageView);

        viewHolder.imageName.setText(event.getName() + "\n" + Date.monthString(event.getDate().getMonth()) + " " + event.getDate().getDay() + " "
                + ", " + event.getDate().getYear() + "\n" + event.getDate().getHour() + ":" + String.format("%02d", event.getDate().getMinute()) + " " + event.getDate().getType().toString());



        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on " + event.getName());

                EventType eventType = EventType.forName(event.getName());

                Intent intent = new Intent(mContext, EventOptionActivity.class);
                intent.putExtra("name", event.getName());

                mContext.startActivity(intent);

                Toast.makeText(mContext, event.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView imageName;
        TextView imageDate;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
           // imageDate = itemView.findViewById(R.id.image_date);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
