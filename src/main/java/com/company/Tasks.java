package com.company;

public class Tasks {
    String name;
    boolean complete;

    public Tasks(String name, boolean complete) {
        this.name = name;
        this.complete = complete;
    }

    public static boolean isCompleted(String status) {
        if ("Выполнено".equals(status)) return true;
        else return false;
    }
}