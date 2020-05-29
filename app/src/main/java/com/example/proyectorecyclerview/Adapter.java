package com.example.proyectorecyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<MyHolder> {
    Context c;
    ArrayList<Model> models;

    public Adapter(Context c, ArrayList<Model> models){
         this.c=c;
         this.models=models;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
         View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);
         return new MyHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position){
        holder.mTitle.setText(models.get(position).getTitle());
        holder.mDescription.setText(models.get(position).getDescription());
        holder.mImageView.setImageResource(models.get(position).getImg());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String hTitle=models.get(position).getTitle();
                String hDescription=models.get(position).getDescription();
                String hTeacher=models.get(position).getTeacher();
                String hDay=models.get(position).getDay();
                String hTime=models.get(position).getTime();
                String hDate=models.get(position).getDate();
                BitmapDrawable bitmapDrawable=(BitmapDrawable)holder.mImageView.getDrawable();
                Bitmap bitmap=bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

                byte[]bytes=stream.toByteArray();
                Intent intent=new Intent(c, Activity2.class);

                intent.putExtra("iTitle", hTitle);
                intent.putExtra("iDescription", hDescription);
                intent.putExtra("iTeacher", hTeacher);
                intent.putExtra("iDay", hDay);
                intent.putExtra("iTime", hTime);
                intent.putExtra("iDate", hDate);
                intent.putExtra("iImage", bytes);
                c.startActivity(intent);
                notifyItemChanged(position);
            }

        });
    }
    @Override
    public int getItemCount(){
        return models.size();
    }
}
