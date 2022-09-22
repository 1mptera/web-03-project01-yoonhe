package models;

import java.util.ArrayList;
import java.util.List;

public class Pomodoro {
    private int quantity = 1;
    private int inProgressSessionIndex = 1;
    private List<Objective> objectives = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();

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
}
