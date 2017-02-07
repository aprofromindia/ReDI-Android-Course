package com.github.aprofromindia.freewifi.data.repositories;

import android.support.annotation.NonNull;

import com.github.aprofromindia.freewifi.data.Venue;
import com.github.aprofromindia.freewifi.http.RestClient;
import com.github.aprofromindia.freewifi.http.VenueService;

import java.util.List;

public class VenueRepository {
    private static VenueRepository instance = new VenueRepository();
    private List<Venue> venues;
    private VenueService service = RestClient.getInstance()
            .createService(VenueService.class);

    private VenueRepository() {
    }

    public static VenueRepository getInstance() {
        return instance;
    }

    public void getVenues() {
        if (venues != null) {

        } else {
            service.getVenues()
                    .subscribe(v -> this.venues = v,
                            throwable -> {
                                this.venues = null;
                            });
        }
    }

    public void createVenue(@NonNull Venue v) {
        service.createVenue(v)
                .subscribe(venue -> {
                    venues.add(venue);
                }, throwable -> {

                });
    }

    public void updateVenue(@NonNull Venue v) {
        service.updateVenue(v.getId(), v)
                .subscribe(venue -> {
                    int index = venues.indexOf(v);
                    venues.set(index, venue);
                }, throwable -> {

                });
    }

    public void deleteVenue(@NonNull Venue v) {
        service.deleteVenue(v.getId())
                .subscribe(venue -> {
                    venues.remove(venue);
                }, throwable -> {

                });
    }
}
