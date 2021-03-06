package com.github.aprofromindia.playmapview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.github.aprofromindia.playmapview.entities.Venue;
import com.github.aprofromindia.playmapview.entities.VenueBuilder;
import com.github.aprofromindia.playmapview.functional.Consumer;
import com.github.aprofromindia.playmapview.ui.fragments.RetainFragment;

public class CreateVenueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_venue);

        // layout elements
        final EditText edName = (EditText) this.findViewById(R.id.ed_name);
        final EditText edAddress = (EditText) this.findViewById(R.id.ed_address);
        final EditText edDescription = (EditText) this.findViewById(R.id.ed_description);
        final Spinner spCategory = (Spinner) this.findViewById(R.id.sp_category);
        Button btnCreate = (Button) this.findViewById(R.id.btn_create_venue);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Venue venue = new VenueBuilder()
                        .addName(edName.getText().toString())
                        .addAddress(edAddress.getText().toString())
                        .addDescription(edDescription.getText().toString())
                        .addCategory(spCategory.getSelectedItem().toString())
                        //.addCoordinates()
                        .build();

                addVenue(venue);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    private void addVenue(Venue venue) {
        RetainFragment retainFragment = (RetainFragment) getSupportFragmentManager().findFragmentByTag(getString(R.string.NETWORK_FRAGMENT_TAG));

        if(        venue != null
                && venue.getName() != null && ! venue.getName().equals( "" )
                && venue.getAddress() != null && ! venue.getAddress().equals( "" )
                && venue.getDescription() != null && ! venue.getDescription().equals( "" )
                && venue.getCategory() != null && ! venue.getCategory().equals( "" )
                && venue.getLatitude() != 0
                && venue.getLongitude() != 0) {

            retainFragment.createPlace(new Consumer<Venue>() {

                @Override
                public void apply(Venue venue) {

                }
            });
        }
    }
}
