package com.github.aprofromindia.parcelable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.aprofromindia.parcelable.entities.EMail;

public class MainActivity extends AppCompatActivity {

    private static final String EMAIL_KEY = "EMAIL_KEY";
    private EMail eMail;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        if (savedInstanceState != null){
            eMail = savedInstanceState.getParcelable(EMAIL_KEY);
            textView2.setText(eMail.getBody());
        }
    }

    private void setupUI() {

        final TextView textView = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Button Clicked");
                eMail = new EMail("harry@harry.com", "email body");
                textView2.setText(eMail.getBody());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(EMAIL_KEY, eMail);
    }
}
