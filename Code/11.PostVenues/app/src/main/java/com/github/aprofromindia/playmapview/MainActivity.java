package com.github.aprofromindia.playmapview;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.github.aprofromindia.playmapview.entities.Venue;
import com.github.aprofromindia.playmapview.functional.Consumer;
import com.github.aprofromindia.playmapview.ui.fragments.RetainFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    //private static final String NETWORK_FRAGMENT_TAG = .getString(R.string.NETWORK_FRAGMENT_TAG);
    private static final float DEFAULT_ZOOM_LEVEL = 12;
    private static final LatLng BERLIN = new LatLng(52.523924,13.403962);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNetworkFragment();
        //setupMapView();
        FloatingActionButton createNewVenue = (FloatingActionButton) this.findViewById(R.id.action_create_venue);
        createNewVenue.setVisibility(View.INVISIBLE);
        createNewVenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateVenueActivity.class));
            }
        });
    }

    private void setupNetworkFragment() {
        RetainFragment retainFragment = (RetainFragment) getSupportFragmentManager().findFragmentByTag(getString(R.string.NETWORK_FRAGMENT_TAG));
        if (retainFragment == null) {
            retainFragment = new RetainFragment();
            getSupportFragmentManager().beginTransaction().add(retainFragment, getString(R.string.NETWORK_FRAGMENT_TAG)).commit();
        }
        retainFragment.getPlaces(new Consumer<List<Venue>>() {
            @Override
            public void apply(List<Venue> venues) {
                setupMapView(venues);
            }
        });
        //retainFragment.getCategories...
    }

    private void setupMapView(List<Venue> venues) {
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapView);

        mapFragment.getMapAsync(new myOnMapReadyCallback(venues) );

    }

    private class myOnMapReadyCallback implements OnMapReadyCallback {

        private List<Venue> venues;

        public myOnMapReadyCallback(List<Venue> venues){
            this.venues = venues;
        }

        @Override
        public void onMapReady(final GoogleMap googleMap) {
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BERLIN, DEFAULT_ZOOM_LEVEL));
            MainActivityPermissionsDispatcher
                    .enableMyLocationWithCheck(MainActivity.this, googleMap);
            showVenues(googleMap, venues);

            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    // Creating a marker
                    MarkerOptions markerOptions = new MarkerOptions();

                    // Setting the position for the marker
                    markerOptions.position(latLng);

                    // Clears the previously touched position
                    googleMap.clear();

                    // Show venues
                    showVenues(googleMap, venues);

                    // Adds marker to map
                    googleMap.addMarker(markerOptions);

                    FloatingActionButton createNewVenue = (FloatingActionButton) findViewById(R.id.action_create_venue);
                    createNewVenue.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    private void showVenues(GoogleMap googleMap, List<Venue> venues) {
        for(int listIndex = 0; listIndex < venues.size(); listIndex++){
            Venue venue = venues.get(listIndex);
            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(venue.getLatitude(), venue.getLongitude()))
                    .title(venue.getName()));
        }
    }


    @SuppressWarnings("MissingPermission")
    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    void enableMyLocation(GoogleMap googleMap) {
        googleMap.setMyLocationEnabled(true);
    }


    @OnPermissionDenied(Manifest.permission.ACCESS_FINE_LOCATION)
    void showPermissionDeniedInfo() {
        Toast.makeText(this, "Please enable Location permission for proper app usage",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
