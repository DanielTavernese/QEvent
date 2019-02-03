package com.example.dan_t.mine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterJson extends RecyclerView.Adapter<AdapterJson.AdapterViewholder> {
    
    private Context mContext;
    private ArrayList<EatingLocation> mFoodLists;

    public AdapterJson(Context context, ArrayList<EatingLocation> mFoodLi){

        mContext = context;
        mFoodLists = mFoodLi;


    }

    @NonNull
    @Override
    public AdapterJson.AdapterViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.food_card,viewGroup,false);
        return new AdapterViewholder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterViewholder holder, int position) {
        EatingLocation currentItem = mFoodLists.get(position);

        String name = currentItem.getName();
        String address = currentItem.getAddress();

        holder.mTextViewName.setText(name);
        holder.mTextViewlocation.setText(address);

    }

    @Override
    public int getItemCount() {
        return mFoodLists.size();
    }

    public class AdapterViewholder extends RecyclerView.ViewHolder{
        public TextView mTextViewName;
        public TextView mTextViewlocation;


        public AdapterViewholder(@NonNull View itemView) {
            super(itemView);
            mTextViewlocation = itemView.findViewById(R.id.Location);
            mTextViewName = itemView.findViewById(R.id.Name);
        }
    }




}
