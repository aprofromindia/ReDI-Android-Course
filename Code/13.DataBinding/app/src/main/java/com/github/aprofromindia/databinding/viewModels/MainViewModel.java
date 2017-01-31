package com.github.aprofromindia.databinding.viewModels;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;

import com.github.aprofromindia.databinding.entities.Cycle;
import com.github.aprofromindia.databinding.entities.Student;

public class MainViewModel {
    private Student student;
    private Cycle cycle;
    private Context context;
    private String text;

    public MainViewModel(Student student, Cycle cycle, Context context) {
        this.student = student;
        this.cycle = cycle;
        this.context = context;
    }

    public void mainBtnClicked(View v) {
        Toast.makeText(context, "Button pressed", Toast.LENGTH_SHORT).show();
    }

    public void textChanged(Editable s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    public Student getStudent() {
        return student;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
