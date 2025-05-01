package task.management;

import java.util.ArrayList;

public class TaskManager {
    private final ArrayList<Task> taskList = new ArrayList<>();

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(Task task) {
        taskList.remove(task);
    }

    public void listAllTasks() {
        if (taskList.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        }
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    public Task findTaskById(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void listTasksByStatus(String status) {
        boolean found = false;
        for (Task task : taskList) {
            if (task.getStatus().equalsIgnoreCase(status)) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nenhuma tarefa com status '" + status + "' encontrada.");
        }
    }
}