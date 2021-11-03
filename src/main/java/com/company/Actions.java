package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

public class Actions {

    public void addTask(File taskFile, Scanner input) throws Exception {
        String task;
        FileWriter writer = new FileWriter(taskFile, true);
        System.out.print("Введите задачу: ");
        task = input.nextLine();
        writer.write(task + ", Не выполнено" + "\n");
        writer.flush();
    }

    public void removeTask(File taskFile, Scanner input) throws Exception {
        String taskString;
        ArrayList<Tasks> tasksList = new ArrayList<>();
        FileReader fr = new FileReader(taskFile);
        BufferedReader taskReader = new BufferedReader(fr);
        String[] nameAndStatus;

        taskString = taskReader.readLine();
        while (taskString != null) {
            nameAndStatus = taskString.split(", ");
            Tasks tasks = new Tasks(nameAndStatus[0], Tasks.isCompleted(nameAndStatus[1]));
            tasksList.add(tasks);
            taskString = taskReader.readLine();
        }

        int i = 0;
        int choice;
        for (Tasks s : tasksList) System.out.println(++i + " " + s.name);
        System.out.print("Введите номер задачи для удаления: ");

        FileWriter writer = new FileWriter(taskFile, false);

        choice = input.nextInt();
        input.nextLine();
        tasksList.remove(choice - 1);
        for (Tasks s : tasksList) {
            writer.write(s.name + ", ");
            if (s.complete) writer.write("Выполнено" + "\n");
            else writer.write("Не выполнено" + "\n");

            writer.flush();
        }
    }

    public void showTasks(File taskFile) throws Exception {
        String taskString;
        ArrayList<Tasks> tasksList = new ArrayList<>();
        FileReader fr = new FileReader(taskFile);
        BufferedReader taskReader = new BufferedReader(fr);
        String[] nameAndStatus;

        taskString = taskReader.readLine();
        while (taskString != null) {
            nameAndStatus = taskString.split(", ");
            Tasks tasks = new Tasks(nameAndStatus[0], Tasks.isCompleted(nameAndStatus[1]));
            tasksList.add(tasks);
            taskString = taskReader.readLine();
        }
        for (Tasks s : tasksList) {
            System.out.print(s.name + ", ");
            if (s.complete) System.out.println("Выполнено");
            else System.out.println("Не выполнено");
        }
    }

    public void changeStatus(File taskFile, Scanner input) throws Exception {
        String taskString;
        ArrayList<Tasks> tasksList = new ArrayList<>();
        FileReader fr = new FileReader(taskFile);
        BufferedReader taskReader = new BufferedReader(fr);
        String[] nameAndStatus;

        taskString = taskReader.readLine();
        while (taskString != null) {
            nameAndStatus = taskString.split(", ");
            Tasks tasks = new Tasks(nameAndStatus[0], Tasks.isCompleted(nameAndStatus[1]));
            tasksList.add(tasks);
            taskString = taskReader.readLine();
        }

        int i = 0;
        int choice;
        for (Tasks s : tasksList) {
            System.out.print(++i + " " + s.name + ", ");
            if (s.complete) System.out.println("Выполнено");
            else System.out.println("Не выполнено");
        }
        System.out.print("Введите номер задачи для изменения статуса на 'Выполнено': ");
        choice = input.nextInt();
        input.nextLine();
        tasksList.get(choice - 1).complete = true;

        FileWriter writer = new FileWriter(taskFile, false);

        for (Tasks s : tasksList) {
            writer.write(s.name + ", ");
            if (s.complete) writer.write("Выполнено" + "\n");
            else writer.write("Не выполнено" + "\n");

            writer.flush();
        }
    }
}