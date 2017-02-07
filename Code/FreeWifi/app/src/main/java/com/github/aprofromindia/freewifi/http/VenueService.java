package com.github.aprofromindia.freewifi.http;

import com.github.aprofromindia.freewifi.data.Venue;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface VenueService {

    @GET("/venues")
    Observable<List<Venue>> getVenues();

    @POST("/venues")
    Observable<Venue> createVenue(@Body Venue venue);

    @PATCH("/venues{id}")
    Observable<Venue> updateVenue(@Path("id")long id, @Body Venue venue);

    @DELETE("/venues/{id}")
    Observable<Venue> deleteVenue(@Path("id")long id);
}