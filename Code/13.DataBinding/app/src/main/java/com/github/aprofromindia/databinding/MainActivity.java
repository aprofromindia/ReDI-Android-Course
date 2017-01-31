package com.github.aprofromindia.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.aprofromindia.databinding.databinding.ActivityMainBinding;
import com.github.aprofromindia.databinding.entities.Cycle;
import com.github.aprofromindia.databinding.entities.Student;
import com.github.aprofromindia.databinding.viewModels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        MainViewModel vm = new MainViewModel(new Student("Tom", "Hiddlestone", 1234),
                new Cycle("Giant"), this);
        binding.setViewModel(vm);
    }
}
