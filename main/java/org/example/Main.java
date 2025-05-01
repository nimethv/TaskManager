package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import task.management.Task;
import task.management.TaskManager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        int op;

        do {
            System.out.println("-------- TASK TRACKER --------");
            System.out.println("1 - Add Task");
            System.out.println("2 - Update Task");
            System.out.println("3 - Delete Task");
            System.out.println("4 - List all Tasks");
            System.out.println("5 - List all done Tasks");
            System.out.println("6 - List all not done Tasks");
            System.out.println("7 - List all in progress Tasks");
            System.out.println("0 - Exit");

            op = sc.nextInt();
            sc.nextLine();
            while (op < 0 || op > 7) {
                System.out.println("Type a valid number, please (0 a 7): ");
                op = sc.nextInt();
                sc.nextLine();
            }

            switch (op) {
                case 1:
                    System.out.println("New task description:");
                    String desc = sc.nextLine();

                    System.out.println("Status (todo, in progress, done):");
                    String status = sc.nextLine();

                    Task novaTask = new Task(desc, status);
                    manager.addTask(novaTask);
                    System.out.println("Task added!");
                    break;

                case 2:
                    System.out.println("Task ID:");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();

                    Task taskToUpdate = manager.findTaskById(idUpdate);
                    if (taskToUpdate != null) {
                        System.out.println("New description:");
                        String newDesc = sc.nextLine();

                        System.out.println("New status (todo, in progress, done):");
                        String newStatus = sc.nextLine();

                        taskToUpdate.updateTask(newDesc, newStatus);
                        System.out.println("Task updated!");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 3:
                    System.out.println("Task ID:");
                    int idDelete = sc.nextInt();
                    sc.nextLine();

                    Task taskToDelete = manager.findTaskById(idDelete);
                    if (taskToDelete != null) {
                        manager.deleteTask(taskToDelete);
                        System.out.println("Task deleted!");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 4:
                    System.out.println("All task:");
                    manager.listAllTasks();
                    break;

                case 5:
                    System.out.println("Done task:");
                    manager.listTasksByStatus("done");
                    break;

                case 6:
                    System.out.println("Todo task:");
                    manager.listTasksByStatus("todo");
                    break;

                case 7:
                    System.out.println("In progress task:");
                    manager.listTasksByStatus("in progress");
                    break;

                case 0:
                    System.out.println("Bye ...");
                    break;

                default:
                    System.out.println("Invalid option. Please, try again.");
            }
            mapper.writeValue(new File("/home/melyssa/IdeaProjects/TaskTracker/src/main/java/json/data.json"), manager);
            System.out.println();
        } while (op != 0);

        sc.close();
    }
}