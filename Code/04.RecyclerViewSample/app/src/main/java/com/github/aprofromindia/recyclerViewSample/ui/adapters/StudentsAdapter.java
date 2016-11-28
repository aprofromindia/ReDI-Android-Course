package com.github.aprofromindia.recyclerViewSample.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.aprofromindia.recyclerViewSample.R;
import com.github.aprofromindia.recyclerViewSample.entities.Student;

import java.util.List;

/**
 * Created by achoudh on 27/11/2016.
 */
public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder> {

    private List<Student> students;

    public StudentsAdapter(@NonNull List<Student> students) {
        this.students = students;
    }

    @Override
    public StudentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_list_row, parent, false);
        return new StudentsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StudentsViewHolder holder, final int position) {
        Student student = students.get(position);
        holder.studentIV.setImageResource(student.getPhoto());
        holder.nameTV.setText(student.getName());
        holder.genderTV.setText(student.getGender());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    static class StudentsViewHolder extends RecyclerView.ViewHolder {

        ImageView studentIV;
        TextView nameTV;
        TextView genderTV;

        StudentsViewHolder(View itemView) {
            super(itemView);
            studentIV = (ImageView) itemView.findViewById(R.id.stud_pic_iv);
            nameTV = (TextView) itemView.findViewById(R.id.stud_name_tv);
            genderTV = (TextView) itemView.findViewById(R.id.stud_gender_tv);
        }
    }
}
