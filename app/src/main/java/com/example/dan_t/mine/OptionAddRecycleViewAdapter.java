package com.example.dan_t.mine;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dan_t.mine.EventOption.EventOption;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class OptionAddRecycleViewAdapter  extends RecyclerView.Adapter<OptionAddRecycleViewAdapter.OptionAddRecycleViewHolder> implements Filterable {

    private ArrayList<EventOption> mEvents = new ArrayList<>();

    private ArrayList<EventOption> mEventsFull = new ArrayList<>();

    private Context mContext;

    public OptionAddRecycleViewAdapter(Context context, ArrayList<EventOption> events) {
        mContext = context;
        mEvents = events;
        mEventsFull = new ArrayList<>(mEvents);
    }

    @NonNull
    @Override
    public OptionAddRecycleViewAdapter.OptionAddRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        OptionAddRecycleViewAdapter.OptionAddRecycleViewHolder viewholder = new OptionAddRecycleViewAdapter.OptionAddRecycleViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull OptionAddRecycleViewAdapter.OptionAddRecycleViewHolder viewHolder, final int i) {
        final EventOption event = mEvents.get(i);

        Glide.with(mContext).asBitmap().load(event.getImagePath()).into(viewHolder.imageView);


        viewHolder.imageName.setText(event.getName());

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EventType eventType = EventType.forName(event.getName());

                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext, event.getName() + " Has been added to Events!", Toast.LENGTH_SHORT).show();
                        MainActivity.getEventOptions().add(event);
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }

        });
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<EventOption> filteredList = new ArrayList<EventOption>();

            if(constraint == null || constraint.length() == 0) {
                filteredList.addAll(mEventsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(EventOption event : mEventsFull) {
                    if(event.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(event);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mEvents.clear();
            mEvents.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class OptionAddRecycleViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView imageName;
        RelativeLayout parentLayout;

        public OptionAddRecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }



}

