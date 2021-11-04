package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class JsonConverter implements Converter{

    public ArrayList<Tasks> fromString(String FileString){
        Gson gson = new GsonBuilder().create();
        ArrayList<Tasks> tasksList = new ArrayList<>();

        if ("{}".equals(FileString) || "".equals(FileString)) return tasksList;

        TypeToken<List<Tasks>> token = new TypeToken<List<Tasks>>() {};
        List<Tasks> tempList = gson.fromJson(FileString, token.getType());
        tasksList = new ArrayList<Tasks>(tempList);

        return tasksList;
    }

    public String asString(ArrayList<Tasks> tasksList){
        String jsonString = new Gson().toJson(tasksList);
        return jsonString;
    }
}
