package com.github.aprofromindia.playmapview.http;

/**
 * Created by achoudh on 09/01/2017.
 */
public class RestClient {
    private static RestClient ourInstance = new RestClient();

    public static RestClient getInstance() {
        return ourInstance;
    }

    private RestClient() {
    }


}
