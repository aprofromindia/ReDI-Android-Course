package com.github.aprofromindia.recyclerViewSample.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.aprofromindia.recyclerViewSample.R;
import com.github.aprofromindia.recyclerViewSample.entities.Student;
import com.github.aprofromindia.recyclerViewSample.ui.adapters.StudentsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int STUDENTS_NUM = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new StudentsAdapter(setupStudents()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @NonNull
    private List<Student> setupStudents() {
        final List<Student> students = new ArrayList<>(STUDENTS_NUM);
        students.add(new Student("Tom", "Male", R.drawable.frog));
        students.add(new Student("Jill", "Female", R.drawable.frog));
        students.add(new Student("Jenny", "Female", R.drawable.frog));
        return students;
    }
}
