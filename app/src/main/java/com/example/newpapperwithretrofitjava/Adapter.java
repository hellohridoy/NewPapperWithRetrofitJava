package com.example.newpapperwithretrofitjava;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<Model>arraylistofmodel;

    public Adapter(Context context, ArrayList<Model> arraylistofmodel) {
        this.context = context;
        this.arraylistofmodel = arraylistofmodel;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,webView.class);
                intent.putExtra("url",arraylistofmodel.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.mtime.setText("Published At:-"+arraylistofmodel.get(position).getPublishedAt());
        holder.mauthor.setText(arraylistofmodel.get(position).getAuthor());
        holder.mheading.setText(arraylistofmodel.get(position).getTitle());
        holder.mcontent.setText(arraylistofmodel.get(position).getDescription());
        Glide.with(context).load(arraylistofmodel.get(position).getUrlToImage()).into(holder.imageView);



    }

    @Override
    public int getItemCount() {
       return arraylistofmodel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading,mcontent,mauthor,mtime;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mheading=itemView.findViewById(R.id.mainheading);
            mcontent=itemView.findViewById(R.id.content);
            mauthor=itemView.findViewById(R.id.author);
            mtime=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.imageView);
            cardView=itemView.findViewById(R.id.cardview);

        }
    }
}
