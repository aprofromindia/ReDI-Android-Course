package com.github.aprofromindia.playmapview.http;

import com.github.aprofromindia.playmapview.entities.Venue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface VenueService {

    @GET("/venues")
    Call<List<Venue>> getVenues();

    @POST("/venues")
    Call<Void> createVenue(Venue venue);

    @PATCH("/venues")
    Call<Void> updateVenue(Venue venue);

    @DELETE("/venues/")
    Call<Void> deleteVenue(Venue venue);
}
