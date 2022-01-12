package com.example.a1_recyclerviewcustombasicadapterjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    public static final int TYPE_AVAILABLE_YES = 0;
    public static final int TYPE_UNAVAILABLE_NO = 1;

    Context context;
    ArrayList<Student> studentArrayList;

    public CustomAdapter(Context context, ArrayList<Student> studentArrayList) {
        this.context = context;
        this.studentArrayList = studentArrayList;
    }

    @Override
    public int getItemViewType(int position) {
        Student student = studentArrayList.get(position);
        if (student.availabale) {
            return TYPE_AVAILABLE_YES;
        } else {
            return TYPE_UNAVAILABLE_NO;
        }

    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_AVAILABLE_YES){
            View view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
            return new CustomViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.unavailable_item, parent, false);
            return new CustomViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.tvOrder.setText(String.valueOf(position + 1));
        holder.tvFullName.setText(studentArrayList.get(position).fullName);
        holder.tvAge.setText(String.valueOf(studentArrayList.get(position).age));
    }


    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        TextView tvOrder = itemView.findViewById(R.id.order_no_item);
        TextView tvFullName = itemView.findViewById(R.id.tv_fullname_item);
        TextView tvAge = itemView.findViewById(R.id.tv_age_item);
    }
}
