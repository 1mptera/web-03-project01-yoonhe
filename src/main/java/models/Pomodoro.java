package models;

import java.util.ArrayList;
import java.util.List;

public class Pomodoro {
    private List<Objective> objectives = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
    private int quantity = 1;

    public List<Objective> getObjectives() {
        return objectives;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setQuantity(int i) {
        quantity = i;
    }

    public int getQuantity() {
        return quantity;
    }
}
