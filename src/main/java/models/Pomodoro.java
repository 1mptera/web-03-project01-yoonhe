package models;

import java.util.ArrayList;
import java.util.List;

public class Pomodoro {
    private int quantity = 0;
    private int inProgressSessionIndex = 1;
    private List<Objective> objectives = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();

    public List<Objective> objectives() {
        return objectives;
    }

    public List<Task> tasks() {
        return tasks;
    }

    public void setQuantity(int i) {
        quantity = i;
    }

    public int quantity() {
        return quantity;
    }

    public int currentInProgressSessionIndex() {
        return inProgressSessionIndex;
    }

    public void addSession(Session session) {
        inProgressSessionIndex += 1;

        sessions.add(session);
    }

    public List<Session> sessions() {
        return sessions;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
