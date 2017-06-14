package com.daimler.fb.android.myapplication.http;

import com.daimler.fb.android.myapplication.entities.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apro on 13-06-2017.
 */

class UserListDeserializer implements JsonDeserializer<List<User>> {

    @Override
    public List<User> deserialize(JsonElement json,
                                Type typeOfT,
                                JsonDeserializationContext context) throws JsonParseException {
        List<User> users = new ArrayList<>();

        JsonArray usersJson = json.getAsJsonObject()
                .getAsJsonObject("_embedded")
                .getAsJsonArray("users");

        for (JsonElement userJson :
                usersJson) {
            JsonObject object = userJson.getAsJsonObject();

            final String name = object.getAsJsonPrimitive("name").getAsString();
            final int age = object.getAsJsonPrimitive("age").getAsInt();
            final String subject = object.getAsJsonPrimitive("subject").getAsString();
            users.add(new User(name, age, subject));
        }
        return users;
    }
}
