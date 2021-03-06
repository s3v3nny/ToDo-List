package com.company;


import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {

        Actions actions = new Actions();
        Scanner input = new Scanner(System.in);
        boolean rightType = false;
        String fileType = "";

        System.out.print("Привет! Это программа для создания To-Do листа. Введи название файла, где будут храниться/уже сохранены задачи(Ты можешь использовать .txt или .json, просто допиши нужное расширение): ");
        String fileName = input.nextLine();
        do {
            if (fileName.split("\\.")[1].equals("json")) {
                rightType = true;
                actions.converter = new JsonConverter();
            } else if (fileName.split(".")[1].equals("txt")) {
                rightType = true;
                actions.converter = new StringConverter();
            } else {
                System.out.print("Проверьте правильность ввода расширения: ");
                fileName = input.nextLine();
            }
        } while (!rightType);
        Path tasksPath = Path.of(fileName);
        File taskFile = new File(fileName);
        if (taskFile.createNewFile())
            System.out.println("Программа не нашла файл с таким именем, поэтому он был создан");
        else System.out.println("Файл с таким именем найден");

        int choice;
        do {
            System.out.println("1. Добавить задачу.");
            System.out.println("2. Удалить задачу.");
            System.out.println("3. Посмотреть список задач.");
            System.out.println("4. Изменить файл с задачами.");
            System.out.println("5. Изменить статус задачи.");
            System.out.println("6. Выйти из программы.");
            System.out.print("Выберите пункт: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    actions.addTask(tasksPath, input);
                    break;
                case 2:
                    actions.removeTask(tasksPath, input);
                    break;
                case 3:
                    actions.showTasks(tasksPath);
                    break;
                case 4:
                    System.out.print("Введите имя файла: ");
                    fileName = input.nextLine();
                    do {
                        if (fileName.split(".")[1].equals("json")) {
                            rightType = true;
                            actions.converter = new JsonConverter();
                        } else if (fileName.split(".")[1].equals("txt")) {
                            rightType = true;
                            actions.converter = new StringConverter();
                        } else {
                            System.out.print("Проверьте правильность ввода расширения: ");
                            fileName = input.nextLine();
                        }
                    } while (!rightType);
                    taskFile = new File(fileName + ".txt");
                    tasksPath = Path.of(fileName + ".txt");
                    if (taskFile.createNewFile())
                        System.out.println("Программа не нашла файл с таким именем, поэтому он был создан\n");
                    else System.out.println("Файл с таким именем найден\n");
                    break;
                case 5:
                    actions.changeStatus(tasksPath, input);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Проверьте правильность ввода.");
                    break;
            }
        } while (choice != 6);
    }
}


