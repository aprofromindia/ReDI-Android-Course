package com.github.aprofromindia.basicActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButtons();

        showMessage("onCreate just called!");
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void setupButtons() {

        final View button = findViewById(R.id.main_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(MainActivity.this, DetailActivity.class));
            }
        });

        final View buttonDialog = findViewById(R.id.dialog_btn);
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        showMessage("onStart just called!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showMessage("onResume just called!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showMessage("onPause just called!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showMessage("onStop just called!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showMessage("onDestroy just called!");
    }

    private void showAlertDialog() {

        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Hey! A button to show me was clicked!")
               .setTitle("Notification");

        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
