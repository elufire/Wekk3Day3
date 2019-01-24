package com.example.wekk3day3;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wekk3day3.user.Picture;
import com.example.wekk3day3.user.Result;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<Result> resultsArrayList;
    String TAG;

    public RecyclerViewAdapter(ArrayList<Result> resultsArrayList) {
        this.resultsArrayList = resultsArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        Result result = resultsArrayList.get(position);

        if (result != null) {
            String name = result.getName().getFirst();
            String picture = result.getPicture().getMedium();
            viewHolder.setResult(result);
            viewHolder.name.setText(name);
            Glide.with(viewHolder.itemView.getContext()).load(picture).into(viewHolder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return resultsArrayList != null ? resultsArrayList.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;

        Result itemResult;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgView);
            name = itemView.findViewById(R.id.rvName);
            //setResult(result);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   EventBus.getDefault().post(new ResultEvent(itemResult));
                }
            });
        }


        public void setResult(Result itemResult){ this.itemResult = itemResult;}
    }

    public void addResult(Result result){
        //System.out.println(name);
        resultsArrayList.add(result);
        notifyDataSetChanged();
    }
}