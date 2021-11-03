package com.company;


import java.io.File;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {

        String filename;
        Actions actions = new Actions();
        Scanner input = new Scanner(System.in);

        System.out.print("Привет! Это программа для создания To-Do листа. Введи название файла, где будут храниться/уже сохранены задачи(без .txt): ");
        filename = input.nextLine();
        File taskFile = new File(filename + ".txt");
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
                    actions.addTask(taskFile, input);
                    break;
                case 2:
                    actions.removeTask(taskFile, input);
                    break;
                case 3:
                    actions.showTasks(taskFile);
                    break;
                case 4:
                    System.out.print("Введите имя файла: ");
                    filename = input.nextLine();
                    taskFile = new File(filename + ".txt");
                    if (taskFile.createNewFile())
                        System.out.println("Программа не нашла файл с таким именем, поэтому он был создан\n");
                    else System.out.println("Файл с таким именем найден\n");
                    break;
                case 5:
                    actions.changeStatus(taskFile, input);
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


