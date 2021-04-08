package com.utssttbbandung.npm19552011182;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterZodiak extends RecyclerView.Adapter<RecyclerAdapterZodiak.ViewHolder> {
    private ArrayList<com.utssttbbandung.npm19552011182.Zodiak> zodiakArrayList;
    private Context context;
    private com.utssttbbandung.npm19552011182.ItemClickListener itemClickListener;

    public RecyclerAdapterZodiak(Context context, ArrayList<com.utssttbbandung.npm19552011182.Zodiak>teamArrayList) {
        this.zodiakArrayList = teamArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_zodiak,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textZodiak.setText(zodiakArrayList.get(position).getZodiak());
        holder.textBrith.setText(zodiakArrayList.get(position).getBrith());
        holder.imgZodiak.setImageResource(Integer.parseInt(zodiakArrayList.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return zodiakArrayList !=null ? zodiakArrayList.size():0;
    }

    public void setItemClickListener(com.utssttbbandung.npm19552011182.ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        TextView textZodiak, textBrith;
        ImageView imgZodiak;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textZodiak = itemView.findViewById(R.id.text_zodiak);
            textBrith = itemView.findViewById(R.id.text_brith);
            imgZodiak = itemView.findViewById(R.id.img_zodiak);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onClick(v, getAdapterPosition());
            }
        }
    }
}
