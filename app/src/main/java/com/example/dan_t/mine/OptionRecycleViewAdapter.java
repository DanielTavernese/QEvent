package com.example.dan_t.mine;

import android.content.Context;
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
import com.example.dan_t.mine.EventOption.EventOption;
import com.example.dan_t.mine.EventOption.EventOptionType;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class OptionRecycleViewAdapter extends RecyclerView.Adapter<OptionRecycleViewAdapter.OptionViewHolder> {

    private static final String TAG = "RecycleViewAdapter";

    private ArrayList<EventOption> mEvents = new ArrayList<>();

    private Context mContext;

    public OptionRecycleViewAdapter(Context context, ArrayList<EventOption> events) {
        mEvents = events;
        mContext = context;
    }

    @NonNull
    @Override
    public OptionRecycleViewAdapter.OptionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        OptionRecycleViewAdapter.OptionViewHolder viewholder = new OptionRecycleViewAdapter.OptionViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull OptionRecycleViewAdapter.OptionViewHolder viewHolder, final int i) {

        final EventOption event = mEvents.get(i);

        Glide.with(mContext).asBitmap().load(event.getImagePath()).into(viewHolder.imageView);

        viewHolder.imageName.setText(event.getLabel());

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on " + event.getName());

                EventType eventType = EventType.forName(event.getName());

                event.fire();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class OptionViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView imageName;
        RelativeLayout parentLayout;

        public OptionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            // imageDate = itemView.findViewById(R.id.image_date);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
