package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Actions {

    Converter converter;

    public void addTask(Path tasksPath, Scanner input) throws Exception {
        System.out.print("Введите задачу: ");
        String task = input.nextLine() + ", Не выполнено\n";
        Files.writeString(tasksPath, task, StandardOpenOption.APPEND);
    }

    public void removeTask(Path tasksPath, Scanner input) throws Exception {
        ArrayList<Tasks> tasksList = new ArrayList<>();

        String taskString = Files.readString(tasksPath);
        tasksList = this.converter.fromString(taskString);

        int i = 0;
        int choice;
        for (Tasks s : tasksList) System.out.println(++i + " " + s.name);
        System.out.print("Введите номер задачи для удаления: ");
        choice = input.nextInt();
        input.nextLine();
        tasksList.remove(choice - 1);

        Files.writeString(tasksPath, "");

        for (Tasks s : tasksList) {
            String outputString;
            if (s.complete) outputString = s.name + ", " + "Выполнено\n";
            else outputString = s.name + ", " + "Не выполнено\n";
            Files.writeString(tasksPath, outputString, StandardOpenOption.APPEND);
        }
    }

    public void showTasks(Path tasksPath) throws Exception {
        ArrayList<Tasks> tasksList = new ArrayList<>();

        String taskString = Files.readString(tasksPath);
        tasksList = this.converter.fromString(taskString);

        for (Tasks s : tasksList) {
            String outputString;
            if (s.complete) outputString = s.name + ", " + "Выполнено";
            else outputString = s.name + ", " + "Не выполнено";
            System.out.println(outputString);
        }
    }

    public void changeStatus(Path tasksPath, Scanner input) throws Exception {
        ArrayList<Tasks> tasksList = new ArrayList<>();

        String taskString = Files.readString(tasksPath);
        tasksList = this.converter.fromString(taskString);

        int i = 0;
        int choice;
        for (Tasks s : tasksList) {
            String outputString;
            if (s.complete) outputString = ++i + " " + s.name + ", Выполнено";
            else outputString = ++i + " " + s.name + ", Не выполнено";
            System.out.println(outputString);
        }
        System.out.print("Введите номер задачи для изменения статуса на 'Выполнено': ");
        choice = input.nextInt();
        input.nextLine();
        tasksList.get(choice - 1).complete = true;

        Files.writeString(tasksPath, "");

        for (Tasks s : tasksList) {
            String outputString;
            if (s.complete) outputString = s.name + ", " + "Выполнено\n";
            else outputString = s.name + ", " + "Не выполнено\n";
            Files.writeString(tasksPath, outputString, StandardOpenOption.APPEND);
        }
    }
}