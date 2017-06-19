package com.daimler.fb.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimler.fb.android.myapplication.entities.User;
import com.daimler.fb.android.myapplication.http.RestClient;
import com.daimler.fb.android.myapplication.http.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RestClient client = RestClient.getInstance();
        final UserService userService = client.createService(UserService.class);
        final TextView textView = (TextView) findViewById(R.id.text_view);

        final Button createUserButton = (Button) findViewById(R.id.user_btn);

        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final User user = new User("Angela", 60, "Physics");
                userService.createUser(user).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(MainActivity.this, "User created", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d(TAG, t.getLocalizedMessage());
                    }
                });
            }
        });

        userService.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){
                    List<User> users = response.body();
                    textView.setText(users.get(0).toString());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }
}
