package com.github.aprofromindia.parcelable;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.aprofromindia.parcelable.databinding.ActivityMainBinding;
import com.github.aprofromindia.parcelable.viewModels.MainVM;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVm(new MainVM(binding));
    }
}
