package com.github.aprofromindia.freewifi.venues;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import com.github.aprofromindia.freewifi.BR;
import com.github.aprofromindia.freewifi.data.Venue;
import com.github.aprofromindia.freewifi.data.repositories.VenueRepository;

import java.util.List;

public class MainViewModel extends BaseObservable {
    private List<Venue> venues;
    private VenueRepository repository;

    MainViewModel(@NonNull VenueRepository repository) {
        assert repository != null;
        this.repository = repository;
        this.repository.getVenues();
    }

    @Bindable
    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
        notifyPropertyChanged(BR.venues);
    }
}
