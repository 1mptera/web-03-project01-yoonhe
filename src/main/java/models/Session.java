package models;

public class Session {
    private Objective objective;
    private Task task;
    private String status;
    private String concentrationLabel;
    private boolean completed;

    public Session() {
        this.completed = false;
        this.status = "Waiting";
        this.concentrationLabel = "보통";
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void start() {
        status = "InProgress";
    }

    public String status() {
        return status;
    }

    public void end() {
        status = "Exit";
    }

    public void completed() {
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setConcentrationLevel(String concentrationLabel) {
        this.concentrationLabel = concentrationLabel;
    }

    public String getConcentrationLabel() {
        return concentrationLabel;
    }
}
