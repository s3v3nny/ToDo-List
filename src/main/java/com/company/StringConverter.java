package com.company;

import java.util.ArrayList;

public class StringConverter implements Converter {
    public ArrayList<Tasks> fromString(String FileString) {
        ArrayList<Tasks> tasksList = new ArrayList<>();

        String[] taskArray = FileString.split("\n");
        if ("".equals(FileString)) return tasksList;

        for (int i = 0; i < taskArray.length; i++) {
            String[] nameAndStatus = taskArray[i].split(", ");
            Tasks tasks = new Tasks(nameAndStatus[0], Tasks.isCompleted(nameAndStatus[1]));
            tasksList.add(tasks);
        }

        return tasksList;
    }
}
