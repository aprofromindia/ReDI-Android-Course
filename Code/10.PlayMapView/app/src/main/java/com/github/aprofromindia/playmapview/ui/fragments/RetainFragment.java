package com.github.aprofromindia.playmapview.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.github.aprofromindia.playmapview.entities.Venue;
import com.github.aprofromindia.playmapview.functional.Consumer;
import com.github.aprofromindia.playmapview.http.RestClient;
import com.github.aprofromindia.playmapview.http.VenueService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetainFragment extends Fragment {

    private VenueService service = RestClient.getInstance().createService(VenueService.class);
    private List<Venue> venues;
    private Consumer<List<Venue>> getConsumer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void getPlaces(final Consumer<List<Venue>> consumer) {
        getConsumer = consumer;
        if (venues == null) {
            Call<List<Venue>> call = service.getVenues();
            call.enqueue(new Callback<List<Venue>>() {
                @Override
                public void onResponse(Call<List<Venue>> call, Response<List<Venue>> response) {
                    if (response.isSuccessful()) {
                        venues = response.body();
                        getConsumer.apply(venues);
                    } else {
                        showNetError();
                    }
                }

                @Override
                public void onFailure(Call<List<Venue>> call, Throwable t) {
                    showNetError();
                }
            });
        } else {
            getConsumer.apply(venues);
        }
    }

    public void createPlace() {
    }

    public void updatePlace() {
    }

    public void deletePlace() {
    }

    private void showNetError(){
        Toast.makeText(getActivity(), "Network error!", Toast.LENGTH_SHORT).show();
    }
}
