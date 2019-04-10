package com.bawazir.myapplicationjobshee3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> students;
    private Context context;
    private OnAdapterClickListener listener;

    interface OnAdapterClickListener {
        void onClick(Student student);
    }

    public StudentAdapter(List<Student> students, Context context, OnAdapterClickListener listener) {
        this.students = students;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_studens, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder viewHolder, int i) {
        Student student = students.get(i);
        viewHolder.name.setText(student.getName());
        viewHolder.id.setText(student.getId());
    }

    @Override
    public int getItemCount() {
        return (students != null ? students.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            id = itemView.findViewById(R.id.id);
            itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = students.get(getAdapterPosition());

                Toast.makeText(context, student.getName(), Toast.LENGTH_SHORT)
                        .show();
            }
        });
        }
    }
}
