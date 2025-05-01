package task.management;

import java.util.Calendar;
import java.util.Random;

public class Task {
    private int id;
    private String description;
    private String status;
    private Calendar createdAt;
    private Calendar updatedAt;

    public Task(String description, String status) {
        this.id = new Random().nextInt(1000);
        this.description = description;
        this.status = status;
        this.createdAt = Calendar.getInstance();
        this.updatedAt = Calendar.getInstance();
    }

    public void updateTask(String newDesc, String newStat) {
        this.description = newDesc;
        this.status = newStat;
        this.updatedAt = Calendar.getInstance();
    }

    public int getId() { return id; }

    public String getDescription() { return description; }

    public String getStatus() { return status; }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "ID: " + id + " | Desc: " + description + " | Status: " + status;
    }
}