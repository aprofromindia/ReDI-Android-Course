package com.github.aprofromindia.freewifi.venues;

import android.Manifest;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.github.aprofromindia.freewifi.R;
import com.github.aprofromindia.freewifi.data.repositories.VenueRepository;
import com.github.aprofromindia.freewifi.databinding.ActivityMainBinding;
import com.github.aprofromindia.freewifi.ui.activities.BaseActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import es.dmoral.toasty.Toasty;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends BaseActivity<MainViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
        setupMap();
    }

    @Override
    public MainViewModel provideViewModel() {
        return new MainViewModel(VenueRepository.getInstance());
    }

    private void setupMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_fragment);

        mapFragment.getMapAsync(googleMap -> {
            MainActivityPermissionsDispatcher
                    .showMyLocationWithCheck(MainActivity.this, googleMap);
        });
    }

    @OnShowRationale(Manifest.permission.ACCESS_FINE_LOCATION)
    void showRationale(PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("We need your location to show nearby Wifi access points")
                .setPositiveButton("Ok", (dialog, button) -> request.proceed())
                .show();
    }

    @SuppressWarnings("MissingPermission")
    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    void showMyLocation(GoogleMap map) {
        map.setMyLocationEnabled(true);
    }

    @OnPermissionDenied(Manifest.permission.ACCESS_FINE_LOCATION)
    void showPermissionDeniedInfo() {
        Toasty.info(this, "Please enable location access for proper usage",
                Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.ACCESS_FINE_LOCATION)
    void showNeverAskInfo() {
        Toasty.warning(this, "", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
